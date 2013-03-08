package com.teamupnext.robot.subsystems;

import com.teamupnext.helperPackage.HomemadeEncoder;
import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.Utils;
import com.teamupnext.robot.commands.MonitorShooterEncoder;
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

    private Talon motor;
    private PIDController PIDController;
    private HomemadeEncoder encoder;
    private DriverStationLCD lcd;
    private MonitorShooterEncoder monitor;
    private double powerChange = 0.05;
    private boolean isFailed = false;
    private int setpoint = 0;
    private int speedChange = 2;
    
    public PIDShooter() throws CANTimeoutException {
        super();
        
        monitor = new MonitorShooterEncoder();
        
        encoder = new HomemadeEncoder(7, 1);
        motor = new Talon(RobotMap.SHOOTER_PWM_CHANNEL);
        PIDController = new PIDController(RobotMap.SHOOTER_KP, RobotMap.SHOOTER_KI, RobotMap.SHOOTER_KD, RobotMap.SHOOTER_KF, encoder, motor);
        PIDController.setOutputRange(0, 1);
        PIDController.setInputRange(0, 88);
        PIDController.setPercentTolerance(1.0);
        encoder.start();
        encoder.reset();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new RunShooter());
    }
    
    public void setToDefault()
    {
        isFailed = false;
    }
    
    public void setEncoderFailMode(boolean failed)
    {
        setPID(0.0, 0.0, 0.0, RobotMap.SHOOTER_KF);
        isFailed = true;
    }
    
    public void setPID(double KP, double KI, double KD, double KF) {
        PIDController.setPID(KP, KI, KD, KF);
    }
    
    public void setSpeed(int rps) {
        this.setpoint = rps;
        PIDController.setSetpoint(setpoint);
    }
    
    public double getOutputPower() {
        return Utils.roundstrip(motor.get());
    }
    
    public double getSetpoint() {
        return setpoint;
    }
    
    public boolean isOnPIDSetpoint() {
        return isFailed || PIDController.onTarget();
    }
    
    public double getRPS() {
        return encoder.getRPS();
    }
    
    public int getPIDSetpoint() {
        return setpoint;
    }
    
    public int getShooterEncoderCount() {
        return encoder.getCount();
    }
    
    public int getEncoderCount() {
        return encoder.getCount();
    }
    
    public void startShooter() {
        monitor.start();
        encoder.reset();
        PIDController.enable();
    }
    
    public void stopShooter() {
        monitor.cancel();
        PIDController.disable();
    }
    
    public void increase() {
        if (setpoint < 88) {
           setSpeed(setpoint + speedChange);
        }
    }

    public void decrease() {      
        if(setpoint > 0) {
            if(setpoint <= powerChange) {
                setSpeed(0);
            } else {
                setSpeed(setpoint - speedChange);
            }
        }
    }

    public void stop() {
        setSpeed(0);
    }
}
