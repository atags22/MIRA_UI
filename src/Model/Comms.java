package Model;



public class Comms {


    //TODO: Figure out how to make an HID object


    //This class is now a Singleton.
    private Comms(){
        System.out.println("Enumerating Devices ...");
        for(String s: NRSerialPort.getAvailableSerialPorts()){
            System.out.println("Availible port: "+s);
        }
        String port = "/dev/ttyACM0";
        int baudRate = 115200;
        NRSerialPort serial = new NRSerialPort(port, baudRate);
        serial.connect();

        DataInputStream ins = new DataInputStream(serial.getInputStream());
        DataOutputStream outs = new DataOutputStream(serial.getOutputStream());



    }
    private static Comms localInstance;
    public static Comms getInstance(){
        if (localInstance == null){
            localInstance = new Comms();
        }
        return localInstance;
    }


    void sendJointUpdate(int jointNum, double newAngle){
        //convert double to 12-bit int
        int b = ins.read();
        System.out.println("Int Value: " + Integer.toString(b));
        outs.write(b);
    }

    void sendEnableStatus(int jointNum, boolean status){

    }

    void attachIDtoJoint(int jointNum, int jointID){

    }

}
