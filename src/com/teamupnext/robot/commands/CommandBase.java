package com.teamupnext.robot.commands;

import com.teamupnext.robot.OI;
import com.teamupnext.robot.RobotMap;
import com.teamupnext.robot.subsystems.DriveTrain;
import com.teamupnext.robot.subsystems.Feeder;
import com.teamupnext.robot.subsystems.PIDShooter;
import com.teamupnext.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static Feeder feeder = new Feeder();
    public static PIDShooter shooter;
    public static DriveTrain driveTrain;

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        
        try {
            shooter  = new PIDShooter();
            driveTrain = new DriveTrain();
        } catch (CANTimeoutException ex) {
            System.out.println(ex.getMessage());
        }

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(feeder);
        
        // create and start the compressor
        Compressor compressor = new Compressor(RobotMap.PRESSURE_SWITCH_DIO_CHANNEL, RobotMap.COMPRESSOR_RELAY_CHANNEL);
        compressor.start();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
