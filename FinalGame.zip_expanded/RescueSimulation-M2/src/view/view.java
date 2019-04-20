package view;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
public class view extends JFrame implements ActionListener{
	private JPanel frame;
	private JPanel side;
	private JButton Info;
	private JButton Units;
	private JScrollPane scroll;
	private JTextArea info;
	private JPanel IDLE;
	private JPanel Responding;
	private JPanel Treating;
	private ArrayList<JButton> Buttons;
	private JPanel map;
	
	public void AddButtons() {
		this.map.setLayout(new GridLayout(10,10));
		for(int i =0; i < 10; i++) {
			for(int j=0; j< 10; j++) {
				JButton button = new JButton();
				button.setText("("+j+ " ," + i +")");
				Buttons.add(button);				//button.setIcon(btimg);
		//		button.setLayout(new GridLayout());
				//button.setSize(100, 100);


		// add it in the center of the JFrame
this.map.add(button, new FlowLayout());
				
				
			}
		}
	}
	public view() {
		map=new JPanel();
		Buttons=new ArrayList<JButton>();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.frame=new JPanel();
		this.getContentPane().add(this.frame);
		this.frame.setBounds(0, 0, 2000, 1000);
		this.frame.setBackground(Color.WHITE);
		this.side=new JPanel();
		this.Info=new JButton("Info");
		this.Info.addActionListener(this);
		this.Units=new JButton("Units");
		this.Units.addActionListener(this);
		this.side.setLayout(null);
		this.side.add(this.Info);
		this.Info.setBounds(10,10,97,30);
		this.side.add(this.Units);
		this.Units.setBounds(112,10,97,30);
		this.frame.setLayout(null);
		this.frame.add(this.side);
		this.side.setBounds(1700, 0, 300, 1000);
		this.side.setBackground(Color.ORANGE);
		this.info=new JTextArea();
		this.scroll=new JScrollPane(this.info);
		this.scroll.setLayout(new ScrollPaneLayout());
		this.side.add(this.scroll);
		this.scroll.setBounds(10, 50, 200, 950);
		this.IDLE=new JPanel();
		this.Responding=new JPanel();
		//msh 3arfa nhotaha wla eh
		this.Treating=new JPanel();
		this.frame.add(this.map);
		this.map.setBounds(10, 10, ((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth())-350, ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-150);
		this.AddButtons();
		this.repaint();
		this.validate();
		// TODO Auto-generated constructor stub
	}
    public static void main(String[] args) {
    	view x=new view();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.Info) {
			this.info.setFont(new Font(Font.SERIF,Font.PLAIN,18));
			this.info.setText("OHHHHHH YEAHHHH!");
		}
		if(e.getSource()==this.Units) {
			this.side.remove(this.scroll);
			this.repaint();
			this.validate();
			
		}
	}
}
