/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.subsystems;

import com.teamupnext.robot.RobotMap;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.ColorImage;

/**
 *
 * @author TeamUpNextControls
 */
public class Targeter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private AxisCamera camera;
    
    public Targeter() {
        this(RobotMap.TARGETING_CAMERA_ADDRESS);
    }
    
    public Targeter(String address) {
        camera = AxisCamera.getInstance(address);
        camera.writeResolution(AxisCamera.ResolutionT.k320x240);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public ColorImage getImage() {
        try {
            return camera.getImage();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

}
