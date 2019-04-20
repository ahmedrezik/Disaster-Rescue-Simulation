package view;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class Example6 {

  public static void main(String[] args) throws Exception {

    MP3Player player = new MP3Player();

    player.addToPlayList(new File("Allweknow.mp3"));


    player.setRepeat(true);
    player.setShuffle(true);

    player.play();
  }

}
