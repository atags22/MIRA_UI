package Model;



public class Comms {


    //TODO: Figure out how to make an HID object


    //This class is now a Singleton.
    private Comms(){}
    private static Comms localInstance;
    public static Comms getInstance(){
        if (localInstance == null){
            localInstance = new Comms();
        }
        return localInstance;
    }


    void sendJointUpdate(int jointNum, double newAngle){
        //convert double to 12-bit int
    }

    void sendEnableStatus(int jointNum, boolean status){

    }

    void attachIDtoJoint(int jointNum, int jointID){

    }

}
