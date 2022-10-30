package com.demontower;

public enum Direction {

    NORTH(0, -1),
    SOUTH(0, 1),
    WEST(-1, 0),
    EAST(1, 0);

    private final int x;
    private final int y;

    // create a new direction
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // get x component of direction
    public int getX() {
        return x;
    }

    // get y component of direction
    public int getY() {
        return y;
    }

}
