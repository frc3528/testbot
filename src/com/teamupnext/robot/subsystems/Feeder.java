package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.PneumaticDevice;
import com.teamupnext.helperPackage.PneumaticHelper;
import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class Feeder extends Subsystem implements PneumaticDevice {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
   
   private PneumaticHelper feeder;
   private double pullTime = RobotMap.FEEDER_PULL_TIMEOUT;
   
   public Feeder() {
       feeder = new PneumaticHelper(RobotMap.FEEDER_PUSH_SOLENOID_CHANNEL, 
               RobotMap.FEEDER_PULL_SOLENOID_CHANNEL, 
               RobotMap.FEEDER_PULL_SOLENOID_CHANNEL);       
   }
   
   public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
   
   public void pushFeeder() {
       System.out.println("feeding");
       feeder.push();
   } 
   
   public void pullFeeder() {      
       feeder.pull();
   }
   
   public void zeroSolenoids() {
       feeder.reset();
   }

    public void setToDefaultPosition() {
        pullTime = RobotMap.FEEDER_PULL_TIMEOUT;
        feeder.setToDefault();
    }

    public void setUseExtendedPullTime(boolean use) {
        if(use) {
            pullTime = RobotMap.FEEDER_EXTENDED_PULL_TIMEOUT;
        } else {
            pullTime = RobotMap.FEEDER_PULL_TIMEOUT;
        }
    }

    public double getPullTime() {
        return pullTime;
    }
}
