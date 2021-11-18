
package br.com.bandtec.safesystem.usb;

import java.util.ArrayList;
import java.util.List;
import oshi.hardware.UsbDevice;
import oshi.hardware.platform.windows.WindowsUsbDevice;
import br.com.bandtec.safesystem.src.ConexaoBD;
import br.com.bandtec.safesystem.src.models.Agencia;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import br.com.bandtec.safesystem.src.models.DispositivoPadrao;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class DispositivoUsb {
    
    private List<UsbDevice> devices ;
    List<UsbDevice> dispUsb;
    
    
    //METODSO QUE ACESSAM OS DEICES

    private DispositivoUsb() {
        //PEGANDO TODA A ARVORE DE DISPOSITIVOS DO WINDOWS
        this.devices = WindowsUsbDevice.getUsbDevices(false);
        //CRIANDO UMA LISTA SÓ PARA OS DISPOSITIVOS USB
        this.dispUsb = new ArrayList<>();
    }
    
    private void verificarUSB(){
        for (UsbDevice device : devices) {
            String unique = device.getUniqueDeviceId();
            String usb = "USBSTOR\\DISK&VEN";
            String mouse = "HID\\VID";
            String teclado = " ACPI";
     //  System.out.println("NOME: " + device.getName() + " UNIQUE: " + device.getUniqueDeviceId() +" VENDOR: "+ device.getVendor());
            if(unique.contains(usb.substring(0, 15)) || unique.contains(mouse.substring(0, 5)) || unique.contains(teclado.substring(0, 4))){
                this.dispUsb.add(device);
//          System.out.println("NOME: " + device.getName() + " UNIQUE: " + device.getUniqueDeviceId() +" SERIAL: "+ device.getVendor());
                  
            }
        }
    }
    
    public void retornarListaUsb(){
        this.verificarUSB();
    }
    
    public void InsereUsbTabelaPadrao(){
        
        this.verificarUSB();
        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());
      
        for (UsbDevice usbDevice : dispUsb) {
            List<DispositivoPadrao> disp = con.query("select * from dispositivoPadrao where uniqueDevice = ?", new BeanPropertyRowMapper(DispositivoUsb.class), usbDevice.getUniqueDeviceId());
//            System.out.println(disp.size());
            if(disp.size() >= 1){
                System.out.println(usbDevice.getName() + " JÁ ESTA CADASTRADO!");
            }else{
                con.update("INSERT INTO dispositivoPadrao (productid, uniqueDevice, nome, fkMaquina)"
                + "VALUES (?, ?, ?, )", usbDevice.getProductId(), usbDevice.getUniqueDeviceId(), usbDevice.getName());
                System.out.println("DISPOSITIVOS " + usbDevice.getName() + " CADSATRO!");
            }      
        }
        
              
    }
    
    public void verificarDispositivoEstranho(){
        this.verificarUSB();
        
        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());
//        System.out.println(dispUsb.size());
                
        for (UsbDevice usbDevice : dispUsb) {
            List<DispositivoPadrao> disp = con.query("select * from dispositivoPadrao where uniqueDevice = ?", new BeanPropertyRowMapper(DispositivoUsb.class), usbDevice.getUniqueDeviceId());
//            System.out.println(disp.size());
            if(disp.size() >= 1){
                System.out.println("NENHUM DISPOSITIVO ESTRANHO ENCONTRADO");
            }else{
                System.out.println("DISPOSITIVO ESTRANHO ENCONTRADO");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String horaAtual = dtf.format(LocalDateTime.now());
                
                con.update("INSERT INTO dispositivoEstranho (productId, "
                        + "uniqueDevice, nome, dataHora) VALUES (?, ?, ?, ?)",
                        usbDevice.getProductId(), usbDevice.getUniqueDeviceId(),
                        usbDevice.getName(), horaAtual);
            }        
         }      
     }
            
       

    

    
    public static void main(String[] args) {
            DispositivoUsb usb = new DispositivoUsb();
            usb.verificarDispositivoEstranho();
            
//            usb.verificarUSB();
            
//            System.out.println(usb.dispUsb.size());
            

            
            
    }
    
    
    
    
}
