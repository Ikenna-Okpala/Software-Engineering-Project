package com.demontower;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.ArrayList;

/* Player Movement class
    * - Handles the player's animation
*/
public class PlayerMovement {

    private final int AnimationDelay = 10;
    private int animPos = 0; //Animation Looper

    ArrayList<Image> upImages;
    ArrayList<Image> downImages;
    ArrayList<Image> leftImages;
    ArrayList<Image> rightImages;

    ArrayList<Image> currentAnim = null;
    ArrayList<Image> lastAnim = null;

    private int currentAnimTimer = 0;

    public void loadImages() {
        upImages = new ArrayList<Image>();
        upImages.add(new ImageIcon("demontower/src/images/player/player-up-1.png").getImage());
        upImages.add(new ImageIcon("demontower/src/images/player/player-up-2.png").getImage());
        upImages.add(new ImageIcon("demontower/src/images/player/player-up-3.png").getImage());

        downImages = new ArrayList<Image>();
        downImages.add(new ImageIcon("demontower/src/images/player/player-down-1.png").getImage());
        downImages.add(new ImageIcon("demontower/src/images/player/player-down-2.png").getImage());
        downImages.add(new ImageIcon("demontower/src/images/player/player-down-3.png").getImage());

        leftImages = new ArrayList<Image>();
        leftImages.add(new ImageIcon("demontower/src/images/player/player-left-1.png").getImage());
        leftImages.add(new ImageIcon("demontower/src/images/player/player-left-2.png").getImage());
        leftImages.add(new ImageIcon("demontower/src/images/player/player-left-3.png").getImage());

        rightImages = new ArrayList<Image>();
        rightImages.add(new ImageIcon("demontower/src/images/player/player-right-1.png").getImage());
        rightImages.add(new ImageIcon("demontower/src/images/player/player-right-2.png").getImage());
        rightImages.add(new ImageIcon("demontower/src/images/player/player-right-3.png").getImage());
    }

    // get current animation image
    public Image getImage() {
        if (currentAnim == null) {
            return null;
        }
        if (currentAnimTimer == AnimationDelay) {
            currentAnimTimer = 0;
            if (animPos == currentAnim.size() - 1) {
                animPos = 0;
            } else {
                animPos++;
            }
        } else {
            currentAnimTimer++;
        }
        return currentAnim.get(animPos);
    }

    // set animation
    public void setAnimation(ArrayList<Image> anim) {
        lastAnim = currentAnim;
        currentAnim = anim;
    }

    // get last animation
    public void resetAnimation() {
        currentAnim = lastAnim;
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
                setAnimation(leftImages);
                break;
            case WEST:
                setAnimation(rightImages);
                break;
        }
    }

    public void reset() {
        currentAnim = null;
        lastAnim = null;
        animPos = 0;
        currentAnimTimer = 0;
    }
}
