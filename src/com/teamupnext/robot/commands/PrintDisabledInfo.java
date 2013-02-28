/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import InsightLT.DecimalData;
import InsightLT.InsightLT;
import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 * @author TeamUpNextControls
 */
public class PrintDisabledInfo extends CommandBase {
    
    // All stuff for the InsightLT unit
        /*
        //DriverStation
        ds = DriverStation.getInstance();
        double battVoltage = ds.getBatteryVoltage();
        
        // InsightLT
        display = new InsightLT(InsightLT.FOUR_ZONES);
        DecimalData disp_batteryVoltage = new DecimalData("Batt:");        
        display.registerData(disp_batteryVoltage, 2);
        display.startDisplay();
        disp_batteryVoltage.setData(battVoltage);
        */    
    
    private static DriverStation ds = DriverStation.getInstance();
    private static InsightLT display = new InsightLT(InsightLT.FOUR_ZONES);
    private static DecimalData disp_batteryVoltage = new DecimalData("Batt:"); 
    //private static BooleanData disp_low_limit = new BooleanData("Low: ");
    
    public PrintDisabledInfo() {
        display.registerData(disp_batteryVoltage, 2);
        display.startDisplay();
    }

    // Called just before this Command runs the first time
    protected void initialize() {       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double battVoltage = ds.getBatteryVoltage();       
        disp_batteryVoltage.setData(battVoltage);
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
