package com.teamupnext.robot;

import edu.wpi.first.wpilibj.DriverStationLCD;
import java.util.Vector;

/**
 *
 * @author Up Next!
 */
public class Utils {

    private static final String CLEAR = "                      ";
    
    //A method used for smooth driving
    public static double rampSpeed(double input) {
        //auto set sensitivity to .5
        return rampSpeed(input, .5);
    }
    
    public static double rampSpeed(double input, double sensitivity) {

        //if (IsInDeadband(input)) {
        //    return 0;
        //}

        //formula for ramping: f(x) = ax^3 + (1-a)x where a is the sensitivity and x is the input
        return (sensitivity * input * input * input + (1 - sensitivity) * input);
    }
    
    private static boolean IsInDeadband(double input) {
        return input > -.1 && input < .1;
    }

    //Filters the input using a low pass filter
    public static double lowPassFilter(double input, double prev) {
        //needs to be between 0 and 1 where 1 is no filter and 0 is previous value
        double alpha = .85;

        return prev + (alpha * (input - prev));
    }

    public static double roundstrip(double myNum) {    
        int precision = 10; //keep 1 digit
        myNum = Math.floor(myNum * precision + .5) / precision;
        return myNum;        
    }
    
    public static void printToDriverStation(String in) {
        v.addElement(in);

        if (v.size() > lcdsize) {
            v.removeElementAt(0);
        } else {
            int add = lcdsize - v.size();

            for (int i = 0; i < add; i++) {
                v.addElement("");
            }
        }   

        dslcd.println(DriverStationLCD.Line.kUser1, 1, (String) v.elementAt(5) + CLEAR);
        dslcd.println(DriverStationLCD.Line.kUser2, 1, (String) v.elementAt(4) + CLEAR);
        dslcd.println(DriverStationLCD.Line.kUser3, 1, (String) v.elementAt(3) + CLEAR);
        dslcd.println(DriverStationLCD.Line.kUser4, 1, (String) v.elementAt(2) + CLEAR);
        dslcd.println(DriverStationLCD.Line.kUser5, 1, (String) v.elementAt(1) + CLEAR);
        dslcd.println(DriverStationLCD.Line.kUser6, 1, (String) v.elementAt(0) + CLEAR);

        dslcd.updateLCD();
    }
    
    public static void printToDriverStation(String in, DriverStationLCD.Line ln)
    {
        dslcd.println(ln, 1, in + CLEAR);
        
        dslcd.updateLCD();
    }
    
    public static void clearDriverStation() {
        printToDriverStation("");
        printToDriverStation("");
        printToDriverStation("");
        printToDriverStation("");
        printToDriverStation("");
        printToDriverStation("");
    }
    private static DriverStationLCD dslcd = DriverStationLCD.getInstance();
    private static Vector v = new Vector();
    private static int lcdsize = 6;
}