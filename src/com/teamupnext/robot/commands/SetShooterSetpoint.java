/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

/**
 *
 * @author TeamUpNextControls
 */
public class SetShooterSetpoint extends CommandBase {
    
    private int setpoint;
    
    public SetShooterSetpoint(int setpoint) {
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.startShooter();
        shooter.setSpeed(setpoint);
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
