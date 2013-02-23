/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamupnext.helperPackage;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author Team Up Next
 */
public class XboxController {
    
    private Joystick stick;
    
    public XboxController(int port) {
        stick = new Joystick(port);
    }
    
    public void assignButton(Button button, ButtonAction action) {
        JoystickButton b = new JoystickButton(stick, button.number);
        
        
        
    }
    
    public static class Button {
        
        private int number;
        
        private Button(int n) {
            number = n;
        }
        
        public static final Button A_BUTTON = new Button(1);
        public static final Button B_BUTTON = new Button(2);
        public static final Button X_BUTTON = new Button(3);
        public static final Button Y_BUTTON = new Button(4);
        public static final Button LEFT_BUMPER = new Button(5);
        public static final Button RIGHT_BUMPER = new Button(6);
        public static final Button BACK_BUTTON = new Button(7);
        public static final Button START_BUTTON = new Button(8); 
    }
    
    public abstract class ButtonAction {
        
        private Command command;
        
        private ButtonAction(Command command) {
            this.command = command;
        }
        
        //public static final ButtonAction WhenActive = new ButtonAction(1);
        //public static final ButtonAction WhenInactive = new ButtonAction(2);
        //public static final ButtonAction WhenPressed = new ButtonAction(3);
        //public static final ButtonAction WhenReleased = new ButtonAction(4);
        //public static final ButtonAction WhileActive = new ButtonAction(5);
        //public static final ButtonAction WhileHeld = new ButtonAction(6);
        
        ///private static void assignAction(JoystickButton button, Command command) {
            
        }
    }
