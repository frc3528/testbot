/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.HomemadeEncoder;
import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import com.teamupnext.robot.commands.RunShooter;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.GearTooth;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.PIDCommand;
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
    private PIDController shootingPID;
    private HomemadeEncoder shooterEncoder;
    private DriverStationLCD lcd;
    private double power = 0;
    private double powerChange = 0.05;
    
    public Shooter() throws CANTimeoutException {
        super();
        
        shootingMotor = new Talon(RobotMap.SHOOTER_PWM_CHANNEL);//CANJaguar(RobotMap.SHOOTER_CAN);
        shootingPID = new PIDController(RobotMap.SHOOTER_KP, RobotMap.SHOOTER_KI, RobotMap.SHOOTER_KD, shooterEncoder, shootingMotor);
        shooterEncoder = new HomemadeEncoder(7, 1);
        shooterEncoder.start();
        shooterEncoder.reset();
    }
    
    public double getShooterRPS() {
        return shooterEncoder.getRPS();
    }
    
    public int getShooterEncoderCount() {
        return shooterEncoder.getCount();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new RunShooter());
    }
    
    public void setPower(double power){
        this.power = power;
    }
    
    public double getPower() {
        return power;
    }
    
    public void runShooter() {        
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

        setPower(Utils.roundstrip(power + powerChange));
    }

    public void decreasePower() {      
        if(power <= 0.0) {
            return;
        }
        
        setPower(Utils.roundstrip(power - powerChange));
    }

    public void stop() {
        setPower(0);
        System.out.println("STOPPING");
    }
}
