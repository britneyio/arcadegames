/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package breakout;

/**
 *
 * @author britn
 */
public interface Commons {
    //dimensions of the board
    int WIDTH = 300;
    int HEIGHT = 400;
    //when the balls passes the bottom edge the game is over
    int BOTTOM_EDGE = 390;
    //number of bricks
    int N_OF_BRICKS = 30;
    //initial coordinates of the paddle
    int INIT_PADDLE_X = 200;
    int INIT_PADDLE_Y = 360;
    //initial coordinates of the ball
    int INIT_BALL_X = 230;
    int INIT_BALL_Y = 355;
    //the initial delay in milliseconds before the task is executed
    int DELAY = 10;
    //the time in milliseconds between successive task executions that 
    //form cycles
    int PERIOD = 1; 
  
}

