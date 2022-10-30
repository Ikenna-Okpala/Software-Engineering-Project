/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demontower;

import javax.swing.*;
import java.awt.*;

/**
 * This class handles the player logic
 * The logic are the movement, health, and score.
 *
 * @author Jesse
 */

public class Player extends Entity {
    private int health;
    private int score;
    private static Player uniqueInstance = null;
    private Square position;
    private int keyCount;
    public final static int PLAYER_HEALTH_MAX = 3;
    public final static Image UP_IMAGE=new ImageIcon("demontower/src/main/resources/images/player/player-up-1.png").getImage();
    public final static Image DOWN_IMAGE=new ImageIcon("demontower/src/main/resources/images/player/player-down-1.png").getImage();
    public final static Image LEFT_IMAGE=new ImageIcon("demontower/src/main/resources/images/player/player-left-1.png").getImage();
    public final static Image RIGHT_IMAGE=new ImageIcon("demontower/src/main/resources/images/player/player-right-1.png").getImage();

    /**
     * This method creates a new player
     *
     * @param
     */
    public Player() {
        health = PLAYER_HEALTH_MAX;
        score = 0;
        keyCount = 0;
        image=DOWN_IMAGE;
    }

    /**
     * get key count
     *
     * @return keyCount
     */
    public int getKeyCount() {
        return keyCount;
    }

    public static Player objectify() {
        if (uniqueInstance == null) {
            uniqueInstance = new Player();
        }

        return uniqueInstance;
    }

    public static Player getNewPlayer()
    {
        uniqueInstance = new Player();
        return uniqueInstance;
    }

    /**
     * add key count
     *
     * @param keyCount
     */
    public void addKeyCount(int keyCount) {
        this.keyCount += keyCount;
    }

    /**
     * get health
     *
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * set health
     *
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * add health
     *
     * @param health
     */
    public void addHealth(int health) {
        this.health += health;
    }

    /**
     * remove health
     *
     * @param health
     */
    public void removeHealth(int health) {
        this.health -= health;
    }

    /**
     * is player alive
     *
     * @return true if player is alive
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * set alive status
     *
     * @param alive
     */
    public void setAlive(boolean alive) {
        if (alive) {
            health = 3;
        } else {
            health = 0;
        }
    }

    /**
     * get score
     *
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * set score
     *
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * add score
     *
     * @param score
     */
    public void addScore(int score) {
        this.score += score;
    }

    public Square getPosition() {
        return position;
    }

    public void setPosition(Square square) {
        this.position = square;
    }

    public boolean areAllKeysCollected()
    {
        final int NUM_OF_KEYS = 6;
        return getKeyCount() == NUM_OF_KEYS;
    }

    public boolean isPositionEqual(int xIndex, int yIndex)
    {
        return getXIndex() == xIndex && getYIndex() == yIndex;
    }

    public String [] getTips()
    {
        // pre-conditiom - game has to pause -> get tips -> resume
        
        final int NUM_OF_TIPS = 3;
        String [] tips = new String[NUM_OF_TIPS];

        tips[0] = "1.\tSurvive by avoiding enemies and collecting keys to unlock the next level";
        tips[1] = "2.\tCollect medkit to restore health";
        tips[2] = "3.\tAvoid the flaming lava pits";

        return tips;
    }
}
