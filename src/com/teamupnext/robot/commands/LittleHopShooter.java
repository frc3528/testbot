/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;

/**
 *
 * @author Team Up Next
 */
public class LittleHopShooter extends CommandBase {
    
    public LittleHopShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {       
       shooter.setPower(RobotMap.SHOOTER_HOP_SPEED);
       setTimeout(RobotMap.SHOOTER_LITTLE_HOP_TIMEOUT);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        shooter.setPower(RobotMap.SHOOTING_POWER_DEFAULT);
    }

    protected void interrupted() {
    }
}
