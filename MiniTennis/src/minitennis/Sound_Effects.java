/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minitennis;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
/**
 *
 * @author britn
 */
public class Sound_Effects {
   
        public static final AudioClip HIT = Applet.newAudioClip(Sound_Effects.class.getResource("pong_hit.wav"));
        public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound_Effects.class.getResource("pong_gameover.wav"));
        public static final AudioClip PLAY = Applet.newAudioClip(Sound_Effects.class.getResource("pong_play2.wav"));
    }
         // public static void main(String[] args) throws Exception{
 // a way to use online soundtracks
//              System.out.println("1");
//		URL url = new URL("http://www.edu4java.com/sound/back.wav");
//		System.out.println("2");
//		AudioClip clip = Applet.newAudioClip(url);
//		System.out.println("3");
//		clip.play();
//		System.out.println("4");
//		Thread.sleep(1000);

//		URL url = new URL(
//			"file:/C:/Users/Eli/workspace/minitennis/src/com/edu4java/minitennis7/back.wav");
  

 //     EXAMPLE
 //URL url = Sound_Effects.class.getResource("pong_play2.wav");
 //       AudioClip clip = Applet.newAudioClip(url);
 //       AudioClip clip2 = Applet.newAudioClip(url);
  //      clip.play();
 //       Thread.sleep(10000);
  //      clip2.loop();
  //      Thread.sleep(20000);
    //    clip2.stop();
  //      
   //     System.out.println("end");
        

    

