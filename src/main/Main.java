package main;


import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class Main{
	
	private static Clip backgroundMusic;
	
	private static AnimationManager aManager;
	
	public static void main(String[] args) {
		Window window = new Window();
		window.draw();
		
		aManager = new AnimationManager(window);
		aManager.startTask();
		playBackgroundMusic();
	}


	private static void playBackgroundMusic(){
	    try {
			backgroundMusic = AudioSystem.getClip();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	    try (InputStream inputStream = Main.class.getResourceAsStream("/music/Travelers.wav")) {
	        if (inputStream == null)  throw new IllegalArgumentException("Can't find the music file.");
	        
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
	        backgroundMusic.open(audioInputStream);
	        backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
	        
	        backgroundMusic.start();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
}
