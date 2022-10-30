/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demontower;


import java.awt.*;

public class Entity {

    private int xIndex;
    private int yIndex;
    protected Image image;

    Entity()
    {
        
    }



    private Square square;

    private Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    // create a new entity
    public Entity(Square square) {
        this.square = square;
    }

    // set direction
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    // get direction

    // get square
    public Square getSquare() {
        return square;
    }

    // set square
    public void setSquare(Square square) {
        this.square = square;
    }

    public void setXIndex(int xIndex)
    {
        this.xIndex = xIndex;
    }

    public void setYIndex(int yIndex)
    {
        this.yIndex = yIndex;
    }

    public int getXIndex()
    {
        return xIndex;
    }

    public int getYIndex()
    {
        return yIndex;
    }


}
