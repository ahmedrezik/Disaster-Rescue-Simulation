package view;

import jaco.mp3.player.MP3Player;

import java.io.File;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class Example7 {

  public static void main(String[] args) throws Exception {

    // MP3Player.setDefaultUI(MP3PlayerUICompact.class);

    //

    MP3Player player = new MP3Player();

    player.setRepeat(true);

    player.addToPlayList(new File("Allweknow.mp3"));
  

    //

    player.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

    JFrame frame = new JFrame("MP3 Player");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(player);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

}
