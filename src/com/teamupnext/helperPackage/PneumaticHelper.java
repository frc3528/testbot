/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.helperPackage;

import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Team Up Next
 */
public class PneumaticHelper {
    
    private Solenoid push;
    private Solenoid pull;
    private int defaultSolenoidChannel;
    private final int pushSolenoidChannel;
    private final int pullSolenoidChannel;    
    private Boolean isPushed;
    
    public PneumaticHelper(int pushSolenoidChannel, int pullSolenoidChannel, int defaultSolenoidChannel) {
        push = new Solenoid(pushSolenoidChannel);
        pull = new Solenoid(pullSolenoidChannel);
        
        this.defaultSolenoidChannel = defaultSolenoidChannel;
        this.pushSolenoidChannel = pushSolenoidChannel;
        this.pullSolenoidChannel = pullSolenoidChannel;
    }
        
    public void setToDefault() {
        isPushed = null;
        
        if(defaultSolenoidChannel == pushSolenoidChannel) {
            push();
        } else {
            pull();
        }
    }
    
    public void push() {
        if(isPushed != null) {
            if(isPushed.booleanValue()) {
                return;
            }
        }
        
        pull.set(false);
        push.set(true);
        isPushed = Boolean.TRUE;
    }
    
    public void pull() {        
        if(isPushed != null) {
            if(isPushed == Boolean.FALSE) {
                return;
            }
        }
        
        push.set(false);
        pull.set(true);
        isPushed = Boolean.FALSE;
    }
    
    public void reset() {
        push.set(false);
        pull.set(false);
    }
    
    public Boolean isPushed() {
        return isPushed;
    }
}
