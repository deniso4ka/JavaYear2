import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JFrame;





/**
 * @author den
 *
 */
public class PlayMYSoundApplication extends JFrame{


public void run(){

	AudioClip sound;
	try {
		sound = Applet.newAudioClip(new URL("file:C:/Users/den/Desktop/Year2Programing/Lab4Part1/bottle-open.wav"));
		sound.play();
		System.out.println(new URL("file://c:/Users/den/Desktop/Year2Programing/Lab4Part1"));
		sound.toString();
	} catch (MalformedURLException e) {
		
		e.printStackTrace();
	}
	
	   
       
        
    } 
	
	public static void main(String[] args) {
	
		PlayMYSoundApplication playMusic = new PlayMYSoundApplication();
		playMusic.run();
	
		
		

	}

}
