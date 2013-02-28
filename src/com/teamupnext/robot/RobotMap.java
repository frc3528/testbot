package com.teamupnext.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    //General Constants
    public static final double DEFAULT_MOTOR_SAFETY_EXPIRATION = .5;
    public static double DEFAULT_PNEUMATIC_TIMEOUT = .5;
    //End General Constants
    
    //Joystick Constants
    public static final int DRIVING_JOYSTICK_PORT = 1;
    public static final int CONTROLS_JOYSTICK_PORT = 2;
    public static final int TESTING_JOYSTICK_PORT = 4;
    public static final int A_BUTTON = 1;
    public static final int B_BUTTON = 2;
    public static final int X_BUTTON = 3;
    public static final int Y_BUTTON = 4;
    public static final int LEFT_BUMPER = 5;
    public static final int RIGHT_BUMPER = 6;
    public static final int BACK_BUTTON = 7;
    public static final int START_BUTTON = 8;
    public static final int LEFT_X_AXIS_INDEX = 1;
    public static final int LEFT_Y_AXIS_INDEX = 2;
    public static final int TRIGGERS = 3; //Triggers (Each trigger = 0 to 1, axis value = right - left)
    public static final int RIGHT_X_AXIS_INDEX = 4;
    public static final int RIGHT_Y_AXIS_INDEX = 5;
    public static final int DPAD = 6; //DPad Left/Right
    //End Joystick Constants
    
    //Drive Train Constants
    public static final int DRIVE_LEFT_PWM = 3;
    public static final int DRIVE_RIGHT_PWM = 2;
    public static final int SHIFT_DOWN_SOLENOID_CHANNEL = 7;
    public static final int SHIFT_UP_SOLENOID_CHANNEL = 8;
    public static final double SHIFT_TIMEOUT_TIME = .25;
    public static final int DEFAULT_JOYSTICK_SENSITIVITY = 8;
    //End Drive Train Constants
    
    //Camera Constants
    public static final int CAMERA_BRIGHTNESS = 50;
    public static final String TARGETING_CAMERA_ADDRESS = "10.35.28.11";
    public static final String DISC_CAMERA_ADDRESS = "10.35.28.12";
    public static final int TARGETING_CAMERA_BRIGHTNESS = 0;
    public static final int TARGETING_CAMERA_COMPRESSION = 50;
    public static final int TARGETING_CAMERA_COLOR_LEVEL = 100;
    public static final int DISC_CAMERA_COMPRESSION = 50;
    public static final int DISC_CAMERA_COLOR_LEVEL = 0;
    public static final int DISC_CAMERA_BRIGHTNESS = 50;
    //End Camera Constants
    
    //Feeder Constants
    public static final int FEEDER_PUSH_SOLENOID_CHANNEL = 5;
    public static final int FEEDER_PULL_SOLENOID_CHANNEL = 6;
    public static final int HOLDER_PUSH_SOLENOID_CHANNEL = 3;
    public static final int HOLDER_PULL_SOLENOID_CHANNEL = 4;
    public static final double FEEDER_PUSH_TIMEOUT = .01;
    public static final double FEEDER_PULL_TIMEOUT = .01;
    public static final double HOLDER_PUSH_TIMEOUT = .05;
    public static final double HOLDER_PULL_TIMEOUT = .125;
    //End Feeder Constants
    
    
    //Shooter Constants
    public static final int SHOOTER_PWM_CHANNEL = 1;
    public static final double SHOOTING_POWER_DEFAULT = .75;
    
    public static final double SHOOTER_HOP_SPEED = 1;
    
    //--Little Hop
    public static final double SHOOTER_LITTLE_HOP_TIMEOUT = .5;
    //--End Little Hop
    
    //--Big Hop
    public static final double SHOOTER_PREHOP_TIMEOUT = .25;
    public static final double SHOOTER_PREHOP_SPEED = .5;
    public static final double SHOOTER_FROM_STOP_TIMEOUT = 1.6;
    //--End Big Hop
    
    //End Shooter Constants
    
    //Compressor Constants
    public static final int COMPRESSOR_RELAY_CHANNEL = 1;
    public static final int PRESSURE_SWITCH_DIO_CHANNEL = 1;
    //End Compressor Constants

}
