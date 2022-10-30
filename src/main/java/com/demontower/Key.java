/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demontower;

import javax.swing.*;

/**
 * This class serves as a normal reward for the player
 * @author Jesse
 */
public class Key extends Reward {
    private int score;

    // create a new key
    public Key(Square square) {
        super(square);
        image = new ImageIcon("demontower/src/main/resources/images/key.png").getImage();
        score = 1;
    }

    // get score
    public int getScore() {
        return score;
    }

    // set score
    public void setScore(int score) {
        this.score = score;
    }

    // add score
    public void addScore(int score) {
        this.score += score;
    }
}
