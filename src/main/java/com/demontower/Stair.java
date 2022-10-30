package com.demontower;

import javax.swing.*;

public class Stair extends Square {

    public Stair(int x, int y) {
        super(x, y);
        setStair();
        image = new ImageIcon("demontower/src/main/resources/images/stair.png").getImage();
    }

}
