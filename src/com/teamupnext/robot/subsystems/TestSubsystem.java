/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author TeamUpNextControls
 */
public class TestSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Relay testSpike;
    
    public TestSubsystem() {
        testSpike = new Relay(2);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setForward() {
        testSpike.set(Relay.Value.kForward);        
    }
    
    public void setReverse() {
        testSpike.set(Relay.Value.kReverse);
    }
}
