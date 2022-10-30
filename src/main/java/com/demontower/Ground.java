package com.demontower;

// ground (empty square)

import javax.swing.*;
import java.awt.*;

public class Ground extends Square{

    public Ground(int x, int y) {
        super(x, y);
        image = new ImageIcon("demontower/src/main/resources/images/ground.png").getImage();
    }
}
