package com.demontower;

 // wall (non-walkable square)

import javax.swing.*;

public class Wall extends Square{


    public Wall(int x, int y) {
        super(x, y);
        image=new ImageIcon("demontower/src/main/resources/images/wall.png").getImage();
        this.setWalkable(false);
    }
    
}
