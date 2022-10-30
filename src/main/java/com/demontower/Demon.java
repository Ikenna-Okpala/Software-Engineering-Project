/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demontower;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

/**
 * This class is responsible for handling the logic to harm player
 * Demon is a movable enemy
 * @author Huntley
 */

//Demon extends Entity implements Enemy
public class Demon extends Entity implements Enemy
{
    public boolean isActive=true;

    public Demon(Square square) {
        super(square);
        loadImage();
        image=new ImageIcon("demontower/src/main/resources/images/enemy/enemy-down-1.png").getImage();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    //How fast Demon walking on the board
    private int speed = 1;

    Image upImages;
    Image downImages;
    Image leftImages;
    Image rightImages;

    Image currentAnim = null;

    private double calcDist(int playerY,int playerX, int enemyY, int enemyX)
    {
        final int BOUND_X = 15;
        final int BOUND_Y = 15;

        if(enemyY > BOUND_X || enemyY < 0)
        {
            return Double.POSITIVE_INFINITY;
        }

        if(enemyX > BOUND_Y || enemyX < 0)
        {
            return Double.POSITIVE_INFINITY;
        }

        return Math.sqrt(Math.pow(enemyX - playerY, 2) + Math.pow(enemyY - playerX, 2));
    }

    private Square getPositionClosestToPlayer()
    {
        Square squares[][] = GameController.objectify().getBoard();

        Player player = Player.objectify();
        int playerX = player.getXIndex();
        int playerY = player.getYIndex();

        int enemyY = getYIndex();
        int enemyX = getXIndex();

        Square closestSquare=getSquare();
//        double smallDist = Double.MAX_VALUE;
        double smallDist = calcDist(playerX, playerY, enemyY, enemyX);;


        if(valid(squares,enemyY,enemyX-1)){
            double topDist = calcDist(playerX, playerY, enemyY, enemyX-1);
            if(topDist < smallDist){
                setXIndex(enemyX-1);
                setYIndex(enemyY);
                closestSquare= squares[enemyY][enemyX-1];
                smallDist=topDist;
                setDirection(Direction.WEST);
            }
        }
        if(valid(squares,enemyY-1,enemyX)){
            double leftDist = calcDist(playerY,playerX, enemyY - 1, enemyX);

            if (leftDist < smallDist) {
                setYIndex(enemyY - 1);
                setXIndex(enemyX);
                closestSquare = squares[enemyY - 1][enemyX];
                smallDist = leftDist;
                setDirection(Direction.NORTH);
            }
        }

        if(valid(squares,enemyY+1,enemyX)){
            double rightDist = calcDist( playerY, playerX,enemyY + 1, enemyX);
            if (rightDist < smallDist) {
                setYIndex(enemyY + 1);
                setXIndex(enemyX);

                closestSquare = squares[enemyY + 1][enemyX];
                smallDist = rightDist;
                setDirection(Direction.SOUTH);
            }
        }

        if(valid(squares,enemyY,enemyX+1)){
            double bottomDist = calcDist( playerY,playerX, enemyY, enemyX + 1);

            if (bottomDist < smallDist) {
                setYIndex(enemyY);
                setXIndex(enemyX + 1);

                closestSquare = squares[enemyY][enemyX + 1];
                setDirection(Direction.EAST);
            }
        }

        return closestSquare;

    }

    private boolean valid(Square[][] squares,int y,int x) {
        if(x<=0||x>=15||y<=0||y>=15){
            return false;
        }
        Square tmp=squares[y][x];
        if(tmp!=null&&tmp.isWalkable()&&!tmp.isOccupied()&&!tmp.isStair()){
            return true;
        }
        return false;
    }

    @Override
    public void move() 
    {
        this.getSquare().setEntity(null);
        Square square = getPositionClosestToPlayer();
        square.setEntity(this);
        setSquare(square);
        Player player=GameController.player;
        if(player.getYIndex()==square.getY()&&player.getXIndex()==square.getX()){
            GameController.collision.collide(player,this);

        }
    }

    @Override
    public void EnemyAnimation() {

    }

    public void loadImage() {

        upImages = new ImageIcon("demontower/src/main/resources/images/enemy/enemy-up-1.png").getImage();
        downImages = new ImageIcon("demontower/src/main/resources/images/enemy/enemy-down-1.png").getImage();
        leftImages = new ImageIcon("demontower/src/main/resources/images/enemy/enemy-left-1.png").getImage();
        rightImages = new ImageIcon("demontower/src/main/resources/images/enemy/enemy-right-1.png").getImage();

    }

    //Enemy will Randomly move on board
    // protected Direction randomMove() {
    //     Square square = getSquare();
    //     List<Direction> directions = new ArrayList<>();
    //     for (Direction direction : Direction.values()) {
    //         if (square.isWalkable()) {
    //             directions.add(direction);
    //         }
    //     }
    //     if (directions.isEmpty()) {
    //         return null;
    //     }
    //     int i = new Random().nextInt(directions.size());
    //     return directions.get(i);
    // }

    public void setAnimation(Image anim) {

        currentAnim = anim;
        image=anim;

    }

    // set animation to up, down, left, right images respectively
    public void setDirection(Direction direction) {
        switch (direction) {
            case NORTH:
                setAnimation(upImages);
                break;
            case SOUTH:
                setAnimation(downImages);
                break;
            case EAST:
                setAnimation(rightImages);
                break;
            case WEST:
                setAnimation(leftImages);
                break;
        }
    }


}
