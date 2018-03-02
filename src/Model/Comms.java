package Model;


import gnu.io.NRSerialPort;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Comms {


    //TODO: Figure out how to make an HID object
    private DataInputStream ins;
    private DataOutputStream outs;

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

        ins = new DataInputStream(serial.getInputStream());
        outs = new DataOutputStream(serial.getOutputStream());
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
        //int b = ins.read();
//        int b = (int) ((newAngle / 360.) * 255.);
        String toSend = Integer.toString((int) (newAngle * 8192 / 100.));
        System.out.println("Int Value: " + toSend);
        try {
            outs.write(toSend.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendEnableStatus(int jointNum, boolean status){

    }

    void attachIDtoJoint(int jointNum, int jointID){

    }

}
