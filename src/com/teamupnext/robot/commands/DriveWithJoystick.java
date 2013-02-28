/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author jousley
 */
public class DriveWithJoystick extends CommandBase {
    
    private Joystick stick;
    
    public DriveWithJoystick() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stick = oi.getDrivingJoystick();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {        
        double leftPower = stick.getRawAxis(RobotMap.LEFT_Y_AXIS_INDEX);
        double rightPower = stick.getRawAxis(RobotMap.RIGHT_Y_AXIS_INDEX);
        
        leftPower = Utils.rampSpeed(leftPower);
        rightPower = Utils.rampSpeed(rightPower);
        
        driveTrain.drive(leftPower, rightPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
