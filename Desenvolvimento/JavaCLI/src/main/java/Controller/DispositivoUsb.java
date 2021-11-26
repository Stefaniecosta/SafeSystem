package Controller;

import Model.DispositivoPadrao;
import Model.Maquina;
import java.util.ArrayList;
import java.util.List;
import oshi.hardware.UsbDevice;
import oshi.hardware.platform.windows.WindowsUsbDevice;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.hardware.platform.linux.LinuxUsbDevice;
import java.sql.Timestamp;
import org.springframework.dao.DataAccessException;

public class DispositivoUsb {

    //recebe valor em verificarUSB()
    public List<UsbDevice> devices;
    private List<UsbDevice> dispUsb;
    private final Sistema sistema;

    //recebe valor no construtor
    private Timestamp ultimoAlertaSlack;

    //METODSO QUE ACESSAM OS DEVICES
    public DispositivoUsb() {
        this.sistema = new Sistema();

        //CRIA VARIAVEL COM DATA ATUAL DA CONSTRUÇÂO
        this.ultimoAlertaSlack = new Timestamp(System.currentTimeMillis());
    }

    public void verificarUSB() {

        try {

            //VERIFICAÇÃO DO TIPO DE SISTEMA OPERACIONAL
            if (sistema.getSistemaOperacional().equalsIgnoreCase("Windows")) {
                this.devices = WindowsUsbDevice.getUsbDevices(false);
            } else if (sistema.getSistemaOperacional().equalsIgnoreCase("Linux") || sistema.getSistemaOperacional().equalsIgnoreCase("Ubuntu")) {
                this.devices = LinuxUsbDevice.getUsbDevices(false);
            }

            //CRIANDO UMA LISTA SÓ PARA OS DISPOSITIVOS USB
            this.dispUsb = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Falha na leitura dos Dispositivos");
            System.out.println(e.getMessage());
            Log log = new Log(e.getMessage(), "Falha na leitura dos Dispositivos");
        }

        try {
            if (sistema.getSistemaOperacional().equalsIgnoreCase("Windows")) {
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
            } else if (sistema.getSistemaOperacional().equalsIgnoreCase("Linux") || sistema.getSistemaOperacional().equalsIgnoreCase("Ubuntu")) {
                for (UsbDevice device : devices) {
                    String unique = device.getUniqueDeviceId();
                    String usb = "/sys/devices";
                    if (unique.contains(usb.substring(0, 9))) {
                        this.dispUsb.add(device);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Falha validação dos Dispositivos");
            System.out.println(e.getMessage());
            Log log = new Log(e.getMessage(), "Falha validação dos Dispositivos");
        }

    }

    public void retornarListaUsb() {
        this.verificarUSB();
    }

    public Integer InsereUsbTabelaPadrao(Integer idCaixa) {

        this.verificarUSB();
        ConexaoBD config = new ConexaoBD();
        JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());
        Integer retorno = 0;

        for (UsbDevice usbDevice : dispUsb) {
            List<DispositivoPadrao> disp = con.query("select * from dispositivoPadrao where uniqueDevice = ?", new BeanPropertyRowMapper(DispositivoUsb.class), usbDevice.getUniqueDeviceId());
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

        try {

            this.verificarUSB();

            ConexaoBD config = new ConexaoBD();
            JdbcTemplate con = new JdbcTemplate(config.getBancoDeDados());

            for (UsbDevice usbDevice : dispUsb) {
                List<DispositivoPadrao> disp = con.query("select * from dispositivoPadrao where uniqueDevice = ?", new BeanPropertyRowMapper(DispositivoUsb.class), usbDevice.getUniqueDeviceId());
                if (disp.size() >= 1) {
                    //System.out.println("NENHUM DISPOSITIVO ESTRANHO ENCONTRADO");
                } else {
                    System.out.println("DISPOSITIVO ESTRANHO ENCONTRADO");

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    String horaAtual = dtf.format(LocalDateTime.now());

                    List<Maquina> maquinas = con.query("SELECT * FROM maquina WHERE idMaquina = ?", new BeanPropertyRowMapper(Maquina.class), idCaixa);

                    Integer fkAgencia = 0;

                    for (Maquina maquina : maquinas) {
                        fkAgencia = maquina.getFkAgencia();
                        break;
                    }
                    enviarSlack(idCaixa, fkAgencia, horaAtual);
                    con.update("INSERT INTO dispositivoEstranho (productId, "
                            + "uniqueDevice, nome,fkMaquina, dataHora) VALUES (?, ?, ?, ?, ?)",
                            usbDevice.getProductId(), usbDevice.getUniqueDeviceId(),
                            usbDevice.getName(), idCaixa, horaAtual);
                }
            }
        } catch (DataAccessException e) {
            System.out.println("Falha verificação de Dispositivo");
            System.out.println(e.getMessage());
            Log log = new Log(e.getMessage(), "Falha verificação de Dispositivo");
        }
    }

    public void enviarSlack(Integer idCaixa, Integer fkAgencia, String dataHoraDeteccao) {
        try {
            Timestamp hotaAtual = new Timestamp(System.currentTimeMillis());

            if (hotaAtual.getTime() - ultimoAlertaSlack.getTime() >= 60000) {
                Slack slack = new Slack(fkAgencia);
                slack.alertaDispositivo(idCaixa, dataHoraDeteccao);
                this.ultimoAlertaSlack = new Timestamp(System.currentTimeMillis());
            }
        } catch (Exception e) {
            System.out.println("Falha ao tentar enviar aviso no Slack");
            System.out.println(e.getMessage());
            Log log = new Log(e.getMessage(), "Falha ao tentar enviar aviso no Slack");
        }
    }

    public List<UsbDevice> getDispUsb() {
        return dispUsb;
    }

}
