package com.demontower;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;

/**
 * Bonus Health Reward class
 * - Extends Reward class
 * 
 * @author Harmeet
 */
public class MedKit extends Reward {
    private int health;

    /**
     * Constructor for the Bonus Reward class
     * 
     * @param square
     * @return Bonus Reward
     */
    public MedKit(Square square) {
        super(square);
        health = 1;
        image = new ImageIcon("demontower/src/main/resources/images/full-heart.png").getImage();
    }

    /**
     * Get health
     * 
     * @return int
     */
    public int getHealth() {
        return health;
    }

    /**
     * Set health
     * 
     * @param health
     * @return void
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Add health
     * 
     * @param health
     * @return void
     */
    public void addHealth(int health) {
        this.health += health;
    }
}
