package com.teamupnext.robot.commands;

/**
 *
 * @author TeamUpNextControls
 */
public class TogglePIDShooter extends CommandBase {
    
    private static final int Setpoints[] = new int[] {0, 56, 58, 66, 68};
    private static int counter = 0;
    
    public TogglePIDShooter() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.setSpeed(Setpoints[counter++ % Setpoints.length]);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
