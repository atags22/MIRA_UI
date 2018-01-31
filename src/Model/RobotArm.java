package Model;

import java.util.HashMap;
import java.util.Set;

public class RobotArm {
    Set<Joint> kinematicChain;
    public RobotArm(){

    }
    //TODO: Make CAN_ID class
    void updateArmPosition(HashMap<Integer,Double> newAngles){
        for(Joint j : kinematicChain){
            //TODO: Should this be a try/catch in case we try to update with an invalid ID?
            j.updateSetpoint(newAngles.get(j.CAN_ID));
        }
    }

    HashMap<Integer,Double> getAngles(){
        HashMap<Integer,Double> toReturn = new HashMap<>();
        for(Joint j : this.kinematicChain){
            toReturn.put(j.CAN_ID,j.setPoint);
        }
        return toReturn;
    }
}
