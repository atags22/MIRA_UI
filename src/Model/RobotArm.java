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
            Joint j = new Joint(i);
            kinematicChain.add(j);
        }
    }

    /*
    public void updateActiveJoints(int numActive){
        for(int i = 0; i < kinematicChain.size(); i++){
            if(i+1 < numActive){
                kinematicChain.get(i).setActive();
            }
            else{
                kinematicChain.get(i).setDisabled();
            }
        }
    }*/

    //TODO: Make CAN_ID class
    public void updateArmPosition(ArrayList<Double> newAngles){
        for(int i = 0; i < newAngles.size(); i++){
            //TODO: Should this be a try/catch in case we try to update more joints than we have?
            kinematicChain.get(i).updateSetpoint(newAngles.get(i));
        }
    }

    public void updateJointPosition(int jointNum, double newAngle){
        //Hardcore java people would use stream or lambda function somehow
        kinematicChain.get(jointNum-1).updateSetpoint(newAngle);

    }

    //Joint Num is always 1 indexed. Arrays are 0 indexed.
    public ArrayList<Double> getAngles(){
        ArrayList<Double> toReturn = new ArrayList<>();
        for(Joint j : this.kinematicChain){
            toReturn.add(j.getSetpoint());
        }
        return toReturn;
    }

    public Double getAngle(int jointNum){
        return kinematicChain.get(jointNum-1).getSetpoint();
    }

    public void associateCANaddr(int jointNum, int canID){
        kinematicChain.get(jointNum-1).setCAN_ID(canID);
    }

    public void setActiveStatus(int jointNum, boolean active){
        kinematicChain.get(jointNum-1).setActiveStatus(active);
    }
}
