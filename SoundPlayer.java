package tests;

import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundPlayer {
	String path;
	AudioStream audioStream;
	public SoundPlayer(String s){
		path=s;
	}
	

	public void playSound(String file) 
	{
	  try
	  {
	    // get the sound file as a resource out of my jar file;
	    // the sound file must be in the same directory as this class file.
	    // the input stream portion of this recipe comes from a javaworld.com article.
		  //ref:	http://alvinalexander.com/java/java-audio-example-java-au-play-sound
		 
	    if(audioStream!=null){
	    	AudioPlayer.player.stop(audioStream);
	    }
	    ClassLoader CLDR = this.getClass().getClassLoader();
	    InputStream inputStream = CLDR.getResourceAsStream("music/"+file+".wav");
	    audioStream = new AudioStream(inputStream);
	    AudioPlayer.player.start(audioStream);
	    
	  }
	  catch (Exception e)
	  {
	  
	  }
	  
	  
	}
	public void StopSound(){
		  try{
			  if(audioStream!=null){
			    	AudioPlayer.player.stop(audioStream);
			    }
		  }
		  catch(Exception e){
			  
		  }
	  }
}
