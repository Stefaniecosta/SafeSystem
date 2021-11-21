package br.com.bandtec.safesystem.usb;

import java.util.ArrayList;
import java.util.List;
import oshi.hardware.UsbDevice;
import oshi.hardware.platform.windows.WindowsUsbDevice;
import br.com.bandtec.safesystem.src.ConexaoBD;
import br.com.bandtec.safesystem.src.models.Agencia;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import br.com.bandtec.safesystem.src.models.DispositivoPadrao;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.hardware.platform.linux.LinuxUsbDevice;

public class DispositivoUsb {

    public List<UsbDevice> devices;
    private List<UsbDevice> dispUsb;
    Sistema sistema = new Sistema();

    //METODSO QUE ACESSAM OS DEVICES
    public DispositivoUsb() {
        //VERIFICAÇÃO DO TIPO DE SISTEMA OPERACIONAL
        if(sistema.getSistemaOperacional().equalsIgnoreCase("Windows")){
            this.devices = WindowsUsbDevice.getUsbDevices(false);
        }else if(sistema.getSistemaOperacional().equalsIgnoreCase("Linux")){
            this.devices = LinuxUsbDevice.getUsbDevices(false);
        }
        
        //CRIANDO UMA LISTA SÓ PARA OS DISPOSITIVOS USB
        this.dispUsb = new ArrayList<>();
    }

    public void verificarUSB() {
        if(sistema.getSistemaOperacional().equalsIgnoreCase("Windows")){
            for (UsbDevice device : devices) {
               String unique = device.getUniqueDeviceId();
               String usb = "USBSTOR\\DISK&VEN";
               String mouse = "HID\\VID";
               String teclado = " ACPI";
               //  System.out.println("NOME: " + device.getName() + " UNIQUE: " + device.getUniqueDeviceId() +" VENDOR: "+ device.getVendor());
               if (unique.contains(usb.substring(0, 15)) || unique.contains(mouse.substring(0, 5)) || unique.contains(teclado.substring(0, 4))) {
                   this.dispUsb.add(device);
   //          System.out.println("NOME: " + device.getName() + " UNIQUE: " + device.getUniqueDeviceId() +" SERIAL: "+ device.getVendor());
               }
           }           
        }else if(sistema.getSistemaOperacional().equalsIgnoreCase("Linux")){
            for (UsbDevice device : devices) {
               String unique = device.getUniqueDeviceId();
               String usb = "/sys/devices";
               if (unique.contains(usb.substring(0, 9))){
                   this.dispUsb.add(device);
               }
            }
        }

    }

    public void retornarListaUsb() {
        this.verificarUSB();
    }

    public Integer InsereUsbTabelaPadrao() {

        this.verificarUSB();
        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());
        Integer retorno =0;

        for (UsbDevice usbDevice : dispUsb) {
            List<DispositivoPadrao> disp = con.query("select * from dispositivoPadrao where uniqueDevice = ?", new BeanPropertyRowMapper(DispositivoUsb.class), usbDevice.getUniqueDeviceId());
//            System.out.println(disp.size());
            if (disp.size() >= 1) {
                System.out.println(usbDevice.getName() + " JÁ ESTA CADASTRADO!");
                retorno = 1;
            } else {
                System.out.println(usbDevice.getName());
                con.update("INSERT INTO dispositivoPadrao (productid, uniqueDevice, nome)"
                        + " VALUES (?, ?, ?)", usbDevice.getProductId(), usbDevice.getUniqueDeviceId(), usbDevice.getName());
                System.out.println("DISPOSITIVOS " + usbDevice.getName() + " CADSATRO!");
                retorno = 2;
            }
        }
        return retorno;
    }

    public void verificarDispositivoEstranho(Integer idCaixa) {
        this.verificarUSB();

        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());
//        System.out.println(dispUsb.size());

        for (UsbDevice usbDevice : dispUsb) {
            List<DispositivoPadrao> disp = con.query("select * from dispositivoPadrao where uniqueDevice = ?", new BeanPropertyRowMapper(DispositivoUsb.class), usbDevice.getUniqueDeviceId());
//            System.out.println(disp.size());
            if (disp.size() >= 1) {
                System.out.println("NENHUM DISPOSITIVO ESTRANHO ENCONTRADO");
            } else {
                System.out.println("DISPOSITIVO ESTRANHO ENCONTRADO");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String horaAtual = dtf.format(LocalDateTime.now());

                con.update("INSERT INTO dispositivoEstranho (productId, "
                        + "uniqueDevice, nome,fkMaquina, dataHora) VALUES (?, ?, ?, ?, ?)",
                        usbDevice.getProductId(), usbDevice.getUniqueDeviceId(),
                        usbDevice.getName(), idCaixa, horaAtual);
            }
        }
    }

//    public static void main(String[] args) {;
//           DispositivoUsb usb = new DispositivoUsb();
////            usb.InsereUsbTabelaPadrao();
//        Sistema sistema = new Sistema();
//
//        System.out.println(sistema.getSistemaOperacional());
//
//        List<UsbDevice> devices;
//        devices = LinuxUsbDevice.getUsbDevices(false);
//        for (UsbDevice device : devices) {
//            System.out.println("NOME: " + device.getName() + " UNIQUE :" + device.getUniqueDeviceId() + " ID: " + device.getProductId());
//        }
//O LINUX DEVOLVE ISTO
//            Ubuntu
//xHCI Host Controller/sys/devices/pci0000:00/0000:00:14.0/usb1
//8087:0aaa/sys/devices/pci0000:00/0000:00:14.0/usb1/1-10
//Integrated_Webcam_HD/sys/devices/pci0000:00/0000:00:14.0/usb1/1-6
//USB Optical Mouse/sys/devices/pci0000:00/0000:00:14.0/usb1/1-1
//xHCI Host Controller/sys/devices/pci0000:00/0000:00:14.0/usb2
//
//NOME: xHCI Host Controller UNIQUE :/sys/devices/pci0000:00/0000:00:14.0/usb1
//NOME: 8087:0aaa UNIQUE :/sys/devices/pci0000:00/0000:00:14.0/usb1/1-10
//NOME: Cruzer Blade UNIQUE :/sys/devices/pci0000:00/0000:00:14.0/usb1/1-2
//NOME: Integrated_Webcam_HD UNIQUE :/sys/devices/pci0000:00/0000:00:14.0/usb1/1-6
//NOME: USB Optical Mouse UNIQUE :/sys/devices/pci0000:00/0000:00:14.0/usb1/1-1
//NOME: xHCI Host Controller UNIQUE :/sys/devices/pci0000:00/0000:00:14.0/usb2
//
//    }

    public List<UsbDevice> getDispUsb() {
        return dispUsb;
    }
    
    
}
