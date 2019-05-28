import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioFile implements LineListener {
	
	private File 				soundFile;
	private AudioInputStream 	ais;
	private AudioFormat 		format;
	private DataLine.Info 		info;
	private Clip 				clip;
	private boolean 			playing;
	
	
	public AudioFile(String fileName) {
		soundFile = new File(fileName);
		try {
			ais = AudioSystem.getAudioInputStream(soundFile);
			format = ais.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.addLineListener(this);
			clip.open(ais);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		} 
		
		
	}
	
	public void play() {
		clip.start();
		playing = true;
	}
	
	public void stop() {
		clip.stop();
		clip.flush();
		clip.setFramePosition(0);
	}
	
	public boolean isPlaying() {
		return playing;
	}

	@Override
	public void update(LineEvent e) {
		// TODO Auto-generated method stub
		if(e.getType() ==  LineEvent.Type.START)
			playing = true;
		else if(e.getType() == LineEvent.Type.STOP) {
			clip.stop();
			clip.flush();
			clip.setFramePosition(0);
			playing = false;
		}
		
	}
	
	

}
