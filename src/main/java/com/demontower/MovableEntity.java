/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.demontower;

/**
 *  This an interface that defines the functionality of movable entities in the game board
 * @author Jesse
 */

public interface MovableEntity
{
    /**
    * Moves a player after receiving events from keyboard
    * @author Jesse
    */
    
    public void move();
    
    /**
    * Reverses player or enemy movement when they encounter a barrier
    * @author Jesse
    */
    
    public void reverse();
    
    /**
    * An enemy or a player responds to collisions differently by implementing this method
    * @author Jesse
    */
    
    public void respondToCollision(); 
}
