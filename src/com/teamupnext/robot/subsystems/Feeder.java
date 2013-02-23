/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
   private PneumaticHelper holder;
   
   public Feeder() {
       feeder = new PneumaticHelper(RobotMap.FEEDER_PUSH_SOLENOID_CHANNEL, 
               RobotMap.FEEDER_PULL_SOLENOID_CHANNEL, 
               RobotMap.FEEDER_PULL_SOLENOID_CHANNEL);
       
       holder = new PneumaticHelper(RobotMap.HOLDER_PUSH_SOLENOID_CHANNEL, 
               RobotMap.HOLDER_PULL_SOLENOID_CHANNEL, 
               RobotMap.HOLDER_PUSH_SOLENOID_CHANNEL);
       
   }
   
   public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
   
   public void pushFeeder() {
       feeder.push();
   } 
   
   public void pullFeeder() {      
       feeder.pull();
   }
   
   public void pushHolder() {    
       holder.push();
   }
   
   public void pullHolder() {     
       holder.pull();
   }
   
   public void zeroSolenoids() {
       feeder.reset();
       holder.reset();
   }

    public void setToDefaultPosition() {
        holder.setToDefault();
        feeder.setToDefault();
    }
}
