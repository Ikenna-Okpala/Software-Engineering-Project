/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demontower;

import javax.swing.*;
import java.awt.*;

/**
 * @author Huntley
 */

// Implementing Trap with action and Image
public class LavaPit extends Entity
{
    public LavaPit(Square square) {
        super(square);
        image=new ImageIcon("demontower/src/main/resources/images/lava.png").getImage();
    }
    
}
