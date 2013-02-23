/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import com.teamupnext.robot.commands.RunShooter;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //speed controller
    private Talon shootingMotor;
    private DriverStationLCD lcd;
    private double power = 0;
    
    public Shooter() throws CANTimeoutException {
        super();
        
        shootingMotor = new Talon(RobotMap.SHOOTER_PWM_CHANNEL);//CANJaguar(RobotMap.SHOOTER_CAN);
        //shootingMotor.setSafetyEnabled(true);
        //shootingMotor.setExpiration(RobotMap.DEFAULT_MOTOR_SAFETY_EXPIRATION);
        //power = RobotMap.SHOOTING_POWER_DEFAULT;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new RunShooter());
    }
    
    public void setPower(double power){
        this.power = power;
        //shootingMotor.setX(power);
    }
    
    public double getPower() {
        return power;
    }
    
    public void runShooter() { 
        /*if(power == shootingMotor.getX()) {
            System.out.println("power on shooter: " + shootingMotor.getX());
            return;
        }*/
        
        shootingMotor.set(power);
    }
    
    /*public double getCurrent() {
        return shootingMotor.getOutputCurrent();
    }
    
    public double getOutputVoltage() {
        return shootingMotor.getOutputVoltage();
    }
    
    public double getBusVoltage() throws CANTimeoutException {
        return shootingMotor.getBusVoltage();
    }*/    
    
    public void increasePower() {
        if (power >= 1.0) {
            return;
        }

        setPower(Utils.roundstrip(power + 0.1));
    }

    public void decreasePower() {      
        if(power <= -1.0) {
            return;
        }
        
        setPower(Utils.roundstrip(power - 0.1));
    }

    public void stop() throws CANTimeoutException {
        setPower(0);
        System.out.println("STOPPING");
    }
}
