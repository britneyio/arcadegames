/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author britn
 */
public class Breakout extends JFrame{
    
    public Breakout(){
        initUI();
    }
    private void initUI(){
        
        add(new Board());
        setTitle("Breakout");
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
        Breakout ex = new Breakout();
        ex.setVisible(true);
    });
    }
    
}
