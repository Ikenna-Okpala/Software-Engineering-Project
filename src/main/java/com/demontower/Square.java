package com.demontower;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

public class Square {

    // changed from an arraylist of entities to a singuar entity
    private Entity entity;
    private final Map<Direction, Square> neighbours;
    private final int x;
    private final int y;
    private boolean walkable;
    private boolean isStair = false;

    // list of entities
    private List<Entity> entities = new ArrayList<>();

    protected Image image;

    public Image getImage() {

        if(entity!=null&&(!(entity instanceof Reward)||((Reward)entity).isActive())){//display an entity, or a active reward
            return entity.getImage();
        }else{
            return image;
        }

    }

    public void setImage(Image image) {
        this.image = image;
    }

    private ArrayList<Entity> tempEntities = new ArrayList<>();

    // create a new square

    
    public Square(int x, int y) {
        // removed arraylist initialization
        neighbours = new EnumMap<Direction, Square>(Direction.class);
        this.x = x;
        this.y = y;
        // defaulty inititalized to true (changed)
        this.walkable = true;
        this.entities = new ArrayList<>();
    }
    

    // get the x coordinate of the square
    public int getX() {
        return x;
    }

    // get the y coordinate of the square
    public int getY() {
        return y;
    }

    // return the square adjacent to this square in the given direction
    public Square getNeighbour(Direction direction) {
        return neighbours.get(direction);
    }

    // get list of entities
    public List<Entity> getEntities() {
        return entities;
    }

    // add entity to list of entities
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    // get entities occupying this square
    public Entity getEntity() {
        return entity;
    }

    //removed getEntity at index function

    // changed to set entity
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    //remobed the temove entity function

    // set the neighbour in the given direction
    public void setNeighbour(Direction direction, Square neighbour) {
        neighbours.put(direction, neighbour);
    }

    // entity is allowed to move to this square
    public boolean isWalkable() {
        return walkable;
    }

    // set whether this square is walkable
    public void setWalkable(boolean walkable) {
        this.walkable = walkable;
    }

    // check if this square is occupied by an entity
    public boolean isOccupied() {
        // changed 
        return entity != null;
    }

    // check if this square is occupied by a player
    // changed
    public boolean isPlayer() 
    {
       return entity instanceof Player;
    }

    // check if this square has a key in it
    // changed
    public boolean hasKey() 
    {
       return entity instanceof Key;
    }

    // check if this square has a bonus in it
    //changed
    public boolean hasBonus() {
        return entity instanceof Treasure;
    }

    // check if this square has a health in it
    // changed
    public boolean hasHealth() {
       return entity instanceof MedKit;
    }

    public boolean isStair()
    {
        return this.isStair;
    }

    public void setStair()
    {
        isStair = true;
    }

}
