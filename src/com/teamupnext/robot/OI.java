
package com.teamupnext.robot;

import com.teamupnext.robot.commands.DecreaseShooterPower;
import com.teamupnext.robot.commands.Fire;
import com.teamupnext.robot.commands.IncreaseShooterPower;
import com.teamupnext.robot.commands.RapidFire;
import com.teamupnext.robot.commands.TogglePIDShooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
        
    Joystick drivingStick;
    
    public OI() {
        drivingStick = new Joystick(RobotMap.DRIVING_JOYSTICK_PORT);
    
        //JoystickButton toggleSpike = new JoystickButton(drivingStick, RobotMap.A_BUTTON);
        //toggleSpike.whenPressed(new ToggleTestSpike());
        
        //Spin up Shooter
        JoystickButton spinUpShooter = new JoystickButton(drivingStick, RobotMap.B_BUTTON);
        spinUpShooter.whenPressed(new TogglePIDShooter());
        
        //Change shooter speed
        JoystickButton shooterIncrease = new JoystickButton(drivingStick, RobotMap.START_BUTTON);
        shooterIncrease.whenPressed(new IncreaseShooterPower());
        JoystickButton shooterDecrease = new JoystickButton(drivingStick, RobotMap.BACK_BUTTON);
        shooterDecrease.whenPressed(new DecreaseShooterPower());
        
        //Fire
        JoystickButton fireShooter = new JoystickButton(drivingStick, RobotMap.X_BUTTON);
        fireShooter.whenPressed(new Fire());
        
        //RapidFire
        JoystickButton rapidFire = new JoystickButton(drivingStick, RobotMap.Y_BUTTON);
        rapidFire.whenPressed(new RapidFire());
        
    }
    
    public Joystick getDrivingJoystick() {
        return drivingStick;
    }
}

