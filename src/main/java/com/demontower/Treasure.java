package com.demontower;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Graphics2D;

/**
 * Bonus Reward class
 * - Handles the bonus reward position and score
 * @author Harmeet
 */
public class Treasure extends Reward {
    private int score;

    /**
     * Constructor for the Bonus Reward class
     * @param square
     * @return Bonus Reward
     */
    public Treasure(Square square) {
        super(square);
        score = 1;
        image = new ImageIcon("demontower/src/main/resources/images/chest.png").getImage();
    }

    /**
     * Get score
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * Set score
     * @param score
     * @return void
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Add score
     * @param score
     * @return void
     */
    public void addScore(int score) {
        this.score += score;
    }
}
