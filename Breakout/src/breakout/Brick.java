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
public class Brick extends Sprite {
    private boolean destroyed;
    
    public Brick(int x, int y){
        initBrick(x, y);
    }
    
    private void initBrick(int x, int y){
        this.x = x;
        this.y = y;
        
        destroyed = false;
        
        loadImage();
        getImageDimensions();
    }
    
    private void loadImage(){
        ImageIcon ii = new ImageIcon("src/pictures/brickie.png");
        image = ii.getImage();
    }
    
    boolean isDestroyed(){
        return destroyed;
    }
    
    void setDestroyed(boolean val){
        destroyed = val;
    }
}
