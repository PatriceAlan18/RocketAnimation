package main;


import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import java.io.BufferedInputStream;

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

	    try (
	            InputStream audioSrc = Main.class.getResourceAsStream("/music/Travelers.wav");
	            BufferedInputStream bufferedIn = new BufferedInputStream(audioSrc)
	        ) {
	            if (audioSrc == null) {
	                System.err.println("No se encontró el archivo de música.");
	                return;
	            }

	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
	            backgroundMusic.open(audioStream);
	            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
	            backgroundMusic.start();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	
}
