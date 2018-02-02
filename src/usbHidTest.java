import org.hid4java.HidDevice;
import org.hid4java.HidManager;
import org.hid4java.HidServices;
import org.hid4java.HidServicesListener;
import org.hid4java.event.HidServicesEvent;

public class usbHidTest implements HidServicesListener{

    public usbHidTest() {
        HidServices hidServices = null;
        // Get HID services
        hidServices = HidManager.getHidServices();
        hidServices.addHidServicesListener(this);

// Provide a list of attached devices
        for (HidDevice hidDevice : hidServices.getAttachedHidDevices()) {
            System.out.println(hidDevice);
            byte[] inData = null;
            while(!hidDevice.open()){

            }
            System.out.println("Waiting 10 seconds...");
            hidDevice.read(inData, 10000);
            System.out.println(inData);

        }
    }


    @Override
    public void hidDeviceAttached(HidServicesEvent event) {

    }

    @Override
    public void hidDeviceDetached(HidServicesEvent event) {

    }

    @Override
    public void hidFailure(HidServicesEvent event) {

    }
}
