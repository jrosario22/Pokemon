

	
	
	import java.io.*;
	import javax.sound.sampled.*;
	/**
	 The SimpleSoundPlayer encapsulates a sound that can be opened
	 from the file system and later played.
	*/
	public class SimpleSoundPlayer implements Runnable {
	 public static void main(String[] args) {
	 // load a sound
	 SimpleSoundPlayer battlesound = new SimpleSoundPlayer("audio/Battle!.wav");
	 SimpleSoundPlayer titlesound = new SimpleSoundPlayer("audio/TitleScreen.wav");
	 SimpleSoundPlayer idlesound = new SimpleSoundPlayer("audio/idletheme.wav");
	 // create the stream to play
	 InputStream stream =new ByteArrayInputStream(idlesound.getSamples());
	 // play the sound
	 
	 
	 //idlesound.play(stream);
	 System.out.println("hello");
	 
	 // exit
	 System.exit(0);
	 
	 }
	 private AudioFormat format;
	 private byte[] samples;
	 
 
	 public SimpleSoundPlayer(String filename) {
		 try {
		 // open the audio input stream
		 AudioInputStream stream =
		 AudioSystem.getAudioInputStream(
		 new File(filename));
	 
		 format = stream.getFormat();
		 // get the audio samples
		 samples = getSamples(stream);
		 }
		 catch (UnsupportedAudioFileException ex) {
		 ex.printStackTrace();
		 }
		 catch (IOException ex) {
		 ex.printStackTrace();

		 }
	 }
	 
	 public byte[] getSamples() {
		 return samples;
		 }
	 
	 private byte[] getSamples(AudioInputStream audioStream) {
		 // get the number of bytes to read
		 int length = (int)(audioStream.getFrameLength() *
		 format.getFrameSize());
		 // read the entire stream
		 byte[] samples = new byte[length];
		 DataInputStream is = new DataInputStream(audioStream);
		 try {
		 is.readFully(samples);
		 }
		 catch (IOException ex) {
		 ex.printStackTrace();
		 }
		 // return the samples
		 return samples;
		 }

	 
	 public void play(InputStream source) {
		 // use a short, 100ms (1/10th sec) buffer for real-time
		 // change to the sound stream
		 int bufferSize = format.getFrameSize() *
		 Math.round(format.getSampleRate() / 10);
		 byte[] buffer = new byte[bufferSize];
		 // create a line to play to
		 SourceDataLine line;
		 
		 try {
			 DataLine.Info info =
			 new DataLine.Info(SourceDataLine.class, format);
			 line = (SourceDataLine)AudioSystem.getLine(info);
			 line.open(format, bufferSize);
			 }
			 catch (LineUnavailableException ex) {
			 ex.printStackTrace();
			 return;
			 }
			 // start the line
			 line.start();
			 // copy data to the line
			 try {
			 int numBytesRead = 0;
			 while (numBytesRead != -1) {
			 numBytesRead =
			 source.read(buffer, 0, buffer.length);
			 if (numBytesRead != -1) {
			 line.write(buffer, 0, numBytesRead);
			 }
			 }
			 }
			 catch (IOException ex) {
			 ex.printStackTrace();
			 }

			line.drain();
			
			
			line.close();

}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			//musicplay();
			//play(this);
			
		}catch(Exception e){
			
			
		}
		
	}
	}
	
