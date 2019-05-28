import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class MusicPlayer implements Runnable {

	
	private ArrayList<AudioFile> musicFiles;
	private int currentSongIndex;
	private boolean running;
	

	//AudioFile song = musicFiles.get(currentSongIndex);
	//AudioFile song1 = musicFiles.get(1);
	
	
	public MusicPlayer(String... files) {
		musicFiles = new ArrayList<AudioFile>();
		for(String file: files)
			musicFiles.add(new AudioFile(file + ".wav"));
		
	}
	
	private void playSound(String fileName){
		/*try {
			File soundFile = new File(fileName);
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip)AudioSystem.getLine(info);
			clip.open(ais);
			clip.start();
			
			
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	//AudioFile song = musicFiles.get(currentSongIndex);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		while(true) {
//		System.out.println("music is playing");
//		playSound(musicFiles.get(currentSongIndex));
//		
//		}
		running = true;
		AudioFile song = musicFiles.get(0);
		AudioFile song1 = musicFiles.get(1);
		
		song.play();
		while(running) {
			//!song.isPlaying()
			if(!GameState.isBattle()) {
				song = musicFiles.get(0);
				song.play();
			}else {
				song.stop();
			}
			
			if(GameState.isBattle()) {
				//song.stop();
				song1 = musicFiles.get(1);
				song1.play();
			}else {
				song1.stop();
			}
			/*
			if(GameState.isBag()) {
				song1 = musicFiles.get(1);
				song1.play();
			}else {
				song.stop();
			}*/
			/*
			if(GameState.isBattle()) {
				song = musicFiles.get(1);
				song.play();
			}*/
			
			
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
