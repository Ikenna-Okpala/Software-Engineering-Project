/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demontower;

/**
 * This class handles the logic for normal rewards and bonus rewards in the game
 * 
 * @author Jesse
 */

public class Reward extends Entity {
    private boolean isActive;

    /**
     * Constructor
     * 
     * @param square
     * @return Reward
     */
    public Reward(Square square) {
        super(square);
        isActive = true;
    }

    /**
     * Is active
     * 
     * @return boolean
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Set active status
     * 
     * @param active
     * @return void
     */
    public void setActive(boolean active) {
        isActive = active;
    }
}
