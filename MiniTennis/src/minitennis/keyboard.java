/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author britn
 */

public class keyboard extends JPanel {
    public  keyboard(){
        //making anonymous class instead of implementation
       KeyListener listen = new KeyListener(){
       @Override
        public void keyTyped(KeyEvent e){
            
        }
        
        @Override
        public void keyPressed(KeyEvent e){
            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        }
        
        @Override
        public void keyReleased(KeyEvent e){
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    };
        addKeyListener(listen);
        setFocusable(true);
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Mini Tennis");
        keyboard key = new keyboard();
        frame.add(key);
        frame.setSize(200,200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    
}
