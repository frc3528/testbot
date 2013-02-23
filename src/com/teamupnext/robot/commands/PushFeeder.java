/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.commands.CommandBase;

/**
 *
 * @author jousley
 */
public class PushFeeder extends CommandBase {
    
    public PushFeeder() {   
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        setTimeout(RobotMap.FEEDER_PUSH_TIMEOUT);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        feeder.pushFeeder();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        feeder.zeroSolenoids();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
