package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class RobotArm {
    ArrayList<Joint> kinematicChain;

    public RobotArm(){
        kinematicChain = new ArrayList<Joint>();
        for(int i = 1; i <=6; i++){
            Joint j = new Joint();
            kinematicChain.add(j);
        }
    }

    void updateActiveJoints(int numActive){
        for(int i = 0; i < kinematicChain.size(); i++){
            if(i+1 < numActive){
                kinematicChain.get(i).setActive();
            }
            else{
                kinematicChain.get(i).setDisabled();
            }
        }
    }

    //TODO: Make CAN_ID class
    void updateArmPosition(HashMap<Integer,Double> newAngles){
        for(Joint j : kinematicChain){
            //TODO: Should this be a try/catch in case we try to update with an invalid ID?
            j.updateSetpoint(newAngles.get(j.CAN_ID));
        }
    }

    void updateJointPosition(int jointNum, double newAngle){
        //Hardcore java people would use stream or lambda function somehow


    }

    HashMap<Integer,Double> getAngles(){
        HashMap<Integer,Double> toReturn = new HashMap<>();
        for(Joint j : this.kinematicChain){
            toReturn.put(j.CAN_ID,j.setPoint);
        }
        return toReturn;
    }
}
