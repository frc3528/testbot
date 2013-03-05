package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.HomemadeEncoder;
import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author jousley
 */
public class PIDShooter extends Subsystem {

    private Talon shootingMotor;
    private PIDController shootingPID;
    private HomemadeEncoder shooterEncoder;
    private DriverStationLCD lcd;
    private double power = 0;
    private double powerChange = 0.05;
    
    private int setSpeed = 0;
    private int speedChange = 5;
    
    public PIDShooter() throws CANTimeoutException {
        super();
        
        shooterEncoder = new HomemadeEncoder(7, 1);
        shootingMotor = new Talon(RobotMap.SHOOTER_PWM_CHANNEL);
        shootingPID = new PIDController(RobotMap.SHOOTER_KP, RobotMap.SHOOTER_KI, RobotMap.SHOOTER_KD, RobotMap.SHOOTER_KF, shooterEncoder, shootingMotor);
        shootingPID.setOutputRange(0, 1);
        shootingPID.setInputRange(0, 88);
        shootingPID.setPercentTolerance(1.0);
        shooterEncoder.start();
        shooterEncoder.reset();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new RunShooter());
    }
    
    public void setSpeed(int rps) {
        this.setSpeed = rps;
        shootingPID.setSetpoint(setSpeed);
    }
    
    public void setPower(double power){
        this.power = power;
    }
    
    public double getPower() {
        return Utils.roundstrip(shootingMotor.get());
    }
    
    public double getSpeed() {
        return setSpeed;
    }
    
    public boolean isOnPIDSetpoint() {
        return shootingPID.onTarget();
    }
    
    public double getRPS() {
        return shooterEncoder.getRPS();
    }
    
    public int getPIDSetpoint() {
        return setSpeed;
    }
    
    public int getShooterEncoderCount() {
        return shooterEncoder.getCount();
    }
    
    public void startShooter() {
        shootingPID.enable();
    }
    
    public void stopShooter() {
        shootingPID.disable();
    }
    
    /*public void runShooter() {        
        shootingMotor.set(power);
    }*/
    
    public void increase() {
        if (power < 1.0) {
            //setPower(Utils.roundstrip(power + powerChange));
        }

        if (setSpeed < 88) {
           setSpeed(setSpeed + speedChange);
        }
    }

    public void decrease() {      
        if(power > 0.0) {
           //setPower(Utils.roundstrip(power - powerChange));
        }
        
        if(setSpeed > 0) {
            if(setSpeed <= powerChange) {
                setSpeed(0);
            } else {
                setSpeed(setSpeed - speedChange);
            }
        }
    }

    public void stop() {
        setPower(0);
        setSpeed(0);
    }
}
