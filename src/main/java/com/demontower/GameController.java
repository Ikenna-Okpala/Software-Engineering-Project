/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demontower;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.font.TextAttribute;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class is the controller of the application. It interacts with the whole system to control the game
 * For instance, the board class is responsible for pausing, restarting, pausing, starting, and ending game
 *
 * @author Jesse
 */

public class GameController extends JPanel {
    private Square[][] squares;
    private Timer timer=new Timer();
    final int PERIOD = 500;
    public static Player player;
    public static Collision collision=new PlayerCollision();
    private Level level;
    private boolean isEnd = false;
    private boolean isPause = false;

    private static GameController uniqueInstance = null;
    private Image statusImg=new ImageIcon("demontower/src/main/resources/images/panel.png").getImage();
    private Image playerImg=new ImageIcon("demontower/src/main/resources/images/playerPanel.png").getImage();
    private Image fullHeart=new ImageIcon("demontower/src/main/resources/images/full-heart.png").getImage();
    private Image emptyHeart=new ImageIcon("demontower/src/main/resources/images/empty-heart.png").getImage();

    // create a new board of squares with the given dimensions and link the squares together
    private GameController() {

        squares = new Square[16][16];
        setLayout(null);
        setPreferredSize(new Dimension(720, 540));
        for(int i=0;i<16;i++){
            for(int j=0;j<16;j++){
                squares[i][j]=new Ground(i,j);
            }
        }
        addKeyListener(k);
        setFocusable(true);
        setFont(new Font(Font.MONOSPACED,Font.BOLD, 15));
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
            }
        },0,PERIOD);
        startGame();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0;i<24;i++){
            for(int j=0;j<18;j++){
                g.drawImage(new Ground(0,0).getImage(), i*30, j*30 , 30,30,null);
            }
        }
        drawMap(g);
        g.drawImage(statusImg,520,30,180,360,null);
        g.drawImage(playerImg,530,90,40,40,null);


        g.drawString("Demon Tower",550,80);
        g.drawString("STATUS",570,120);
        g.drawString("Health:",535,170);
        g.drawString("Score:"+player.getScore(),535,220);
        g.drawString("Keys Collected:"+player.getKeyCount(),535,270);
        g.drawString("Time",535,320);
        g.drawString("Level",535,370);
        for(int i=0;i<player.getHealth();i++){
            g.drawImage(fullHeart,600+i*30,150,20,20,null);
        }
        g.setColor(Color.white);
        g.drawString("Exit", 520, 420);
        g.drawString("Restart", 580, 420);
        g.drawString("Tips", 660, 420);
        g.setColor(Color.black);
    }

    public void drawMap(Graphics g) {
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares[0].length; j++) {
                Square square = squares[i][j];
                Image eleImg = square.getImage();
                g.drawImage(eleImg, j*30,  (i+1)*30, 30,30,null);
            }
        }
        g.drawImage(player.getImage(),player.getYIndex()*30,(player.getXIndex()+1)*30,30,30,null);
    }


    public void setGrid(Square[][] grid) {
        this.squares = grid;
    }

    public static GameController objectify() {
        if (uniqueInstance == null) {
            uniqueInstance = new GameController();
        }

        return uniqueInstance;
    }

    // link the given square to the board
    public void link(Square square) {
        int x = square.getX();
        int y = square.getY();
        if (x > 0) {
            square.setNeighbour(Direction.WEST, squares[x - 1][y]);
        }
        if (x < squares.length - 1) {
            square.setNeighbour(Direction.EAST, squares[x + 1][y]);
        }
        if (y > 0) {
            square.setNeighbour(Direction.NORTH, squares[x][y - 1]);
        }
        if (y < squares[0].length - 1) {
            square.setNeighbour(Direction.SOUTH, squares[x][y + 1]);
        }
    }

    // link all squares to the board
    public void linkAll() {
        for (int x = 0; x < squares.length; x++) {
            for (int y = 0; y < squares[0].length; y++) {
                link(squares[x][y]);
            }
        }
    }

//    // get width of board
//    public int getWidth() {
//        return squares.length;
//    }
//
//    // get height of board
//    public int getHeight() {
//        return squares[0].length;
//    }

    // get the square at the given coordinates
    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

    // create ground (empty square)
    public Square createGround(int x, int y) {
        return new Ground(x, y);
    }

    // create wall (non-walkable square)
    public Square createWall(int x, int y) {
        return new Wall(x, y);
    }

    // check if the given square is walkable
    public boolean isWalkable(Square square) {
        return square.isWalkable();
    }


    // return x and y coordinates of square
    public int getX(Square square) {
        return square.getX();
    }

    // return x and y coordinates of square
    public int getY(Square square) {
        return square.getY();
    }

    // loads level

    public void setUpLevel(Level level)
    {
        try
        {

            level.generateWalls();
            level.generateEnemies();

            level.generateLavaPits();
            level.generateKeys();

            level.paceGame();

            level.generateTreasures();
            level.generateHealth();
            level.generateStair();
            player = level.generatePlayer();

            level.countDown();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex);
            displayFileError();
        }
    }

    public void nextLevel() throws FileNotFoundException {
        if (level == null) {
            level = new Level1(squares);
        } else if (level instanceof Level1) {
            level = new Level2(squares);
        } else {
            level = new Level3(squares);
        }

        setUpLevel(level);
        
    }

    public void displayFileError()
    {
        JOptionPane.showMessageDialog(this,"File was not found");
    }

    // starts game
    public void startGame(){
        isEnd = false;
        try 
        {
            nextLevel();
        } 
        catch (FileNotFoundException e) 
        {
            displayFileError();
        }
    }

    // pauses the game

    public boolean isPause()
    {
        return isPause;
    }

    public void pauseGame() 
    {
        isPause = true;
        level.pause();
    }

    public void resumeGame()
    {
        isPause = false;
        level.resume();
    }

    public boolean isResume()
    {
        return isPause;
    }

    public void resetGame()
    {
        level.endLevel();

        if(level instanceof Level1)
        {
            level = new Level1(squares);
        }

        else if(level instanceof Level2)
        {
            level = new Level2(squares);
        }

        else
        {
            level = new Level3(squares);
        }

        setUpLevel(level);
    }

    public void exitGame()
    {
        endGame();
    }

    public void endGame() 
    {
        level.endLevel();
        isEnd = true;

        // do some UI tricks
    }

    public String getTime()
    {
        return level.getCurrentTime();
    }

    public boolean isEnd()
    {
        return isEnd;
    }

    public int getScore()
    {
        return Player.objectify().getScore();
    }

    public Square[][] getBoard() {
        return squares;
    }

    KeyAdapter k = new KeyAdapter() {
        public void keyPressed(KeyEvent e) {
            if(!isEnd && !isPause)
            {
                Square ele = null;
                int x1 = 0;
                int y1 = 0;
                int dere = 0;
                int preX = player.getXIndex();
                int preY = player.getYIndex();
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    dere = 1;
                    x1 = player.getXIndex()-1;
                    y1 = player.getYIndex();
                    if(!isWalkable(squares[x1][y1]))
                    if (!allowed(x1, y1)) {
                        return;
                    }
                    player.setImage(Player.UP_IMAGE);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    dere = 2;
                    x1 = player.getXIndex();
                    y1 = player.getYIndex()-1;
                    if (!allowed(x1, y1)) {
                        return;
                    }
                    player.setImage(Player.LEFT_IMAGE);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    dere = 3;
                    x1 = player.getXIndex()+1;
                    y1 = player.getYIndex();
                    if (!allowed(x1, y1)) {
                        return;
                    }
                    player.setImage(Player.DOWN_IMAGE);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    dere = 4;
                    x1 = player.getXIndex();
                    y1 = player.getYIndex()+1;
                    if (!allowed(x1, y1)) {
                        return;
                    }
                    player.setImage(Player.RIGHT_IMAGE);
                }else{
                    GameController gc=(GameController)(e.getSource());
                    gc.repaint();
                    return;
                }
                player.setXIndex(x1);
                player.setYIndex(y1);
                if(squares[x1][y1].isOccupied()){
                    Entity entity=squares[x1][y1].getEntity();
                    collision.collide(player,entity);
                }
                if(!player.isAlive()){
                    endGame();
                }
                GameController gc=(GameController)(e.getSource());
                gc.repaint();
            }
        }


    };

    private boolean allowed(int x1, int y1) {
        if(x1>=0&&x1<16&&y1>=0&&y1<16&&isWalkable(squares[x1][y1])){
            return true;
        }else{
            return false;
        }
    }

}
