/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;
import javax.swing.ImageIcon;
/**
 *
 * @author britn
 */
public class Ball extends Sprite {
    private int xdir;
    private int ydir;
    
    public Ball(){
        initBall();
    }
    
    private void initBall(){
        xdir = 1;
        ydir = -1;
        
        loadImage();
        getImageDimensions();
        resetState();
    }
    
    private void loadImage(){
        ImageIcon ii = new ImageIcon("src/pictures/ball.png");
        image = ii.getImage();
    }
    
    void move(){
        x += xdir;
        y += ydir;
        
        if(x == 0){
            setXDir(1);
        }
        if(x == Commons.WIDTH - imageWidth){
            System.out.println(imageWidth);
            setXDir(-1);
        }
        if(y == 0){
            setYDir(1);
        }
       
    }
    
    private void resetState(){
        x = Commons.INIT_BALL_X;
        y = Commons.INIT_BALL_Y;
    }
    
    void setXDir(int x){
        xdir = x;
    }
    
    void setYDir(int y){
        ydir = y;
    }
    
    int getXDir(){
        return xdir;
    }
    
    int getYDir(){
        return ydir;
    }
}
