/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Image;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
/**
 *
 * @author britn
 */
public class SnakeBoard extends JPanel implements ActionListener{
    //width and height of the board
    private final int B_WIDTH = 300;
    private final int B_HEIGHT = 300;
    //the size of the apple and the dots on the snake
    private final int DOT_SIZE = 10;
    //defines the maximum number of dots on the board - 900 = 300*300)/(10*10
    private final int ALL_DOTS = 900;
    //used to calculate a random position for the apple
    private final int RAND_POS = 29;
    //speed of the game
    private final int DELAY = 140;
    
    //stores the coordinates of all of the joints of the snake
    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    
    private int dots;
    private int apple_x;
    private int apple_y;
    
    //chooses which direction the snake will start moving in
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true;
    
    private Timer timer;
    private Image ball;
    private Image apple;
    private Image head;
    
    public SnakeBoard(){
        initBoard();
    }
    
    private void initBoard(){
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
        
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }
    
    private void loadImages(){
        ImageIcon iidot = new ImageIcon("src/pictures/dot.png");
        ball = iidot.getImage();
        
        ImageIcon iiapple = new ImageIcon("src/pictures/apple.png");
        apple = iiapple.getImage();
        
        ImageIcon iihead = new ImageIcon("src/pictures/head.png");
        head = iihead.getImage();
    }
    
    //at the beginning of the game we create the snake
    //randomly locate the apple and
    //start the timer
    private void initGame(){
        dots = 3;
        //create the snake with 3 dots placed at 500,50/490,50/480/50
        for(int z = 0; z < dots; z++){
            x[z] = 50 - z * 10;
            y[z] =  50;
        }
        
        locateApple();
        
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override 
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        doDrawing(g);
    }
    
    private void doDrawing(Graphics g){
        if(inGame){
            g.drawImage(apple, apple_x, apple_y, this);
            
            for(int z = 0; z < dots; z++){
                if(z == 0){
                    g.drawImage(head, x[z], y[z], this);
                }
                else{
                    g.drawImage(ball, x[z], y[z],this);
                }
            }
            
            Toolkit.getDefaultToolkit().sync();
        }
        else{
            gameOver(g);
        }
    }
    
    private void gameOver(Graphics g){
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT /2);
    }
    
    private void checkApple(){
        //checks if the apple collides with the head of the snake
        //if true then it add a dot to the snake
        //and finds a new random position for the apple
        if((x[0] == apple_x) && (y[0] == apple_y)){
            dots++;
            locateApple();
        }
    }
    
    private void move(){
        //the cursor keys only control the head of the snake
        //so this for loop moves the rest of the snake by
        //moving each dot one position up from the last
        for(int z = dots; z > 0; z--){
            x[z] = x[(z-1)];
            y[z] = y[(z-1)];
        }
        
        //moves the head in the intended direction
        if(leftDirection) x[0] -= DOT_SIZE;
        if(rightDirection) x[0] += DOT_SIZE;
        if(upDirection) y[0] -= DOT_SIZE;
        if(downDirection) y[0] += DOT_SIZE;
    }
    
    private void checkCollision(){
        //checks if the snake has hit itself or one of its dots
        for(int z = dots; z > 0; z--){
            if((z > 4) && (x[0] == x[z]) && (y[0] == y[z])){
                inGame = false;
            }
        }
        if(y[0] >= B_HEIGHT){
            inGame = false;
        }
        if(y[0] < 0){
            inGame = false;
        }
        if(x[0] >= B_WIDTH){
            inGame = false;
        }
        if(x[0] < 0){
            inGame = false;
        }
        if(!inGame){
            timer.stop();
        }
    }
    
    private void locateApple(){
        int r = (int) (Math.random() * RAND_POS);
        apple_x  = r * DOT_SIZE;
        
        r = (int) (Math.random() * RAND_POS);
        apple_y = r * DOT_SIZE;
    }
    
    @Override 
    public void actionPerformed(ActionEvent e){
        if(inGame){
            checkApple();
            checkCollision();
            move();
        }
        repaint();
    }
    
    private class TAdapter extends KeyAdapter{
        @Override 
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();
            
            if((key == KeyEvent.VK_LEFT) && (!rightDirection)){
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if((key == KeyEvent.VK_RIGHT) && (!leftDirection)){
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }
            if((key == KeyEvent.VK_UP) && (!downDirection)){
                upDirection = true;
                rightDirection = false;
                leftDirection = false;

            }
            if((key == KeyEvent.VK_DOWN) && (!upDirection)){
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
            
        }
    }
    
}

