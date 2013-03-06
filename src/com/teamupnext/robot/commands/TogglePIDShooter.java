/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

/**
 *
 * @author TeamUpNextControls
 */
public class TogglePIDShooter extends CommandBase {
    
    private boolean isOn = false;
    
    private int off = 0;
    private int pyramidSetpoint = 55;
    private int feederSetpoint = 65;
    
    public TogglePIDShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(isOn) {
            new StopPIDShooter().start();
            isOn = false;
        } else {
            new StartPIDShooter().start();
            isOn = true;
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}