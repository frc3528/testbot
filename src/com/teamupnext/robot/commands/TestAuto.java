/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author TeamUpNextControls
 */
public class TestAuto extends CommandGroup {
    
    public TestAuto() {
        addSequential(new SetShooterSetpoint(55));
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
        addSequential(new Fire());
    }
}
