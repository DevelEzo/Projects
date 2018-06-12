package Loaders;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class musicloader {

	// source
		public  File sound;
		Clip clip;
		
	// settings
		public  float value;
	
	public musicloader() {
		value = -20f;
	}
	
	public void load(String path) {
		sound = new File(path);
	}
	
	public void play() {
		try {
			
			
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(sound));
			
			// settings
				FloatControl soundcontrol = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				soundcontrol.setValue(value);
			
			clip.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
