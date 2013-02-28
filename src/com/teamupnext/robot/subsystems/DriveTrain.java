/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import com.teamupnext.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class DriveTrain extends Subsystem {
    
    private RobotDrive drive;
    
    private Jaguar right;
    private Jaguar left;
    
    private int sensitivity = RobotMap.DEFAULT_JOYSTICK_SENSITIVITY;
    
    public DriveTrain() {
        super("DriveTrain");
        
        left = new Jaguar(RobotMap.DRIVE_LEFT_PWM);
        right = new Jaguar(RobotMap.DRIVE_RIGHT_PWM);
        
        drive = new RobotDrive(left, right);    
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoystick());
    }
    
    public void drive(double left, double right){
        double leftPower = Utils.rampSpeed(left, sensitivity/10);
        double rightPower = Utils.rampSpeed(right, sensitivity/10);
        drive.tankDrive( leftPower , rightPower);
    }
    
    public void stopDrive() {
        drive(0,0);
    }
    
    public int getSensitivity() {
        return sensitivity;
    }
    
    public void decreaseSensitivity() {
        if(sensitivity > 0) {
            sensitivity -= 1;
        }
    }
    
    public void increaseSensitivity() {
        if(sensitivity < 10) {
            sensitivity += 1;
        }
    }
    
    public void setMotorSafety(boolean enabled) {
        right.setSafetyEnabled(enabled);
        left.setSafetyEnabled(enabled);
    }
}
