package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.CommandCenter;

public class GameOver extends JFrame implements ActionListener {
private JButton EndGame;
private JButton RestartGame;
	public GameOver() {
		this.setSize(500, 500);
		EndGame = new JButton("End Game");
		RestartGame = new JButton("Restart Game");
		EndGame.addActionListener(this);
		RestartGame.addActionListener(this);
		this.add(EndGame,BorderLayout.NORTH);
		this.add(RestartGame, BorderLayout.SOUTH);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == EndGame) {
		System.exit(ABORT);
	}
	if(e.getSource() == RestartGame) {
		try {
			CommandCenter game = new CommandCenter();
		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
		
	}
	public static void main(String [] args) {
		GameOver o = new GameOver();
	}
}
