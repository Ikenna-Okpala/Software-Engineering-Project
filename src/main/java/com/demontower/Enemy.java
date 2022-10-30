/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demontower;

import java.awt.image.*;

/**
 * This class handles the functionality of the enemy entity
 * This extends Entity and implements MovableEntity
 * @author Jesse
 */

public interface Enemy
{

    public void move();

    public void EnemyAnimation();

    public void loadImage();

    public boolean isActive();



}
