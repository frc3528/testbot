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
public class Feed extends CommandGroup {
    
    public Feed() {
        addSequential(new PushFeeder());
        addSequential(new PullFeeder());
    }
}
