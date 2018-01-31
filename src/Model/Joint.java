package Model;

import java.util.HashMap;

/**
 * Contains all info about a particular joint
 * -CAN ID
 * -Joint Type
 * -DH Parameters
 * -Current Setpoint
 * -PID Constants
 */
public class Joint {
    //TODO: MAke this an instance of CAN_ID object
    int CAN_ID;
    //TODO: Make Joint Type class/enum
    double setPoint;
    boolean jointEnabled; //Should the motor ever try to turn?
    HashMap<String,Double> dhParams; //d, theta, r, alpha
    HashMap<String,Double> pidConstants; //kp, ki, kd

    public Joint(int canAddr){
        this.CAN_ID = canAddr;
    }
    public void init(){

    }
    //TODO: Basic setters/getters
    public void updateSetpoint(double newPoint){
        this.setPoint = newPoint;
    }
    public double getSetpoint(){ return this.setPoint; }
}
