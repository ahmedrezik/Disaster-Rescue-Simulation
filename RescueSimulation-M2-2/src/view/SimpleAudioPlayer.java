package view;
import java.io.File;

import jaco.mp3.player.MP3Player;

public class SimpleAudioPlayer {

	  public static void main(String[] args) {
		  MP3Player play = 	    new MP3Player();
		  play.setRepeat(true);
		  play.addToPlayList(new File("Allweknow.mp3"));
		  play.play();
		  
	  }

	}


