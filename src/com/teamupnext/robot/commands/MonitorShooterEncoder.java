/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;

/**
 *
 * @author TeamUpNextControls
 */
public class MonitorShooterEncoder extends CommandBase {
    
    private boolean encoderOff = false;
    
    public MonitorShooterEncoder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(timeSinceInitialized() < .5) {
            return;
        }
        
        if(!isSpinning() && isPowered()) {
            //Encoder isn't working
            shooter.setPID(0.0, 0.0, 0.0, RobotMap.SHOOTER_KF);
            encoderOff = true;
            System.out.println("Turned off encoder control");
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return encoderOff;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private boolean isSpinning() {
        return shooter.getEncoderCount() > 0;
    }
    
    private boolean isPowered() {
        return shooter.getOutputPower() != 0.0;
    }
}
