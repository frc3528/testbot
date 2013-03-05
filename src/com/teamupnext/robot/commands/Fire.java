/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author jousley
 */
public class Fire extends CommandGroup {
    
    public Fire() {
        addSequential(new WaitTillShooterOnTarget());
        addSequential(new Feed());
        //addSequential(new LittleHopShooter());
    }
}
