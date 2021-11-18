
import java.util.ArrayList;
import java.util.List;
import oshi.hardware.UsbDevice;
import oshi.hardware.platform.windows.WindowsUsbDevice;
import br.com.bandtec.safesystem.src.ConexaoBD;

public class DispositivoUsb {

    private List<UsbDevice> devices;
    List<UsbDevice> dispUsb;

    //METODSO QUE ACESSAM OS DEICES
    private DispositivoUsb() {
        //PEGANDO TODA A ARVORE DE DISPOSITIVOS DO WINDOWS
        this.devices = WindowsUsbDevice.getUsbDevices(false);
        //CRIANDO UMA LISTA SÓ PARA OS DISPOSITIVOS USB
        this.dispUsb = new ArrayList<>();
    }

    private void verificarUSB() {
        
        for (UsbDevice device : devices) {
            String unique = device.getUniqueDeviceId();
            String usb = "USBSTOR\\DISK&VEN";
            String mouse = "HID\\VID";
            String teclado = " ACPI";
            //System.out.println("NOME: " + device.getName() + " UNIQUE: " + device.getUniqueDeviceId() + " VENDOR: " + device.getVendor());
            if (unique.contains(usb.substring(0, 15)) || unique.contains(mouse.substring(0, 5)) || unique.contains(teclado.substring(0, 4))) {
                this.dispUsb.add(device);
                System.out.println("NOME: " + device.getName() + " UNIQUE: " + device.getUniqueDeviceId() + " SERIAL: " + device.getVendor());

            }

        }

        for (UsbDevice device : devices) {
            for (List<Dis> Dispo : listaDeRegistros) {

            }
        }
    }

    public void retornarListaUsb() {
        this.verificarUSB();
    }

    public void InsereDadosUsb() {

    }

    public static void main(String[] args) {
        DispositivoUsb usb = new DispositivoUsb();

        usb.verificarUSB();

        System.out.println(usb.dispUsb.size());

    }

}
