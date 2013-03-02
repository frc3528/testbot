/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.helperPackage;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.PIDSource;

/**
 *
 * @author TeamUpNextControls
 */
public class HomemadeEncoder extends Counter implements PIDSource {
        
    private static final int MICRO_CONV_NUM = 1000000;
    
    private Counter counter;
    //private Encoder encoder;
    private int magnetNum;
    
    public HomemadeEncoder(int channel) {
        this(channel, 1);
    }
    
    public HomemadeEncoder(int channel, int magnetNum) {
        counter = new Counter(channel);
        counter.setMaxPeriod(.2);
        this.magnetNum = magnetNum;
        
        //encoder = new Encoder(channel, channel - 1);
    }
    
    public double pidGet() {
        return getRPS();
    }
    
    public void start() {
        counter.start();
        counter.reset();
    }
    
    public void reset() {
        counter.reset();
    }
    
    public int getCount() {
        return counter.get();
    }
    
    public double getRPS() {
        
        return 1 / (counter.getPeriod() * magnetNum);
        
        /*double secondsElapsed = timer.get() * MICRO_CONV_NUM;
        double rps = counter.get() / (secondsElapsed * magnetNum);
        
        reset();
        //return counter.get();
        return rps;*/
    }
    
    public double getRPM() {
        return getRPS() * 60;
    }
    
}
