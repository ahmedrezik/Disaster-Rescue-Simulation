package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class display extends JFrame implements ActionListener{
      private JPanel map;
      private JPanel side;
      private JPanel info;
      private JTextArea txt1;
      private JTextArea txt2;
      private JTextArea txt3;
      private JTextArea SOSmessage;
      private JLabel label;
      private JButton information;
   	  private JButton units;
  	  private JButton log;
  	  private JButton back;
  	  private ArrayList<JButton> Buttons;
  	  private JButton NextCycle;
  	
  	  public void AddButtons() {
		this.map.setLayout(new GridLayout(10,10));
		for(int i =0; i < 10; i++) {
			for(int j=0; j< 10; j++) {
				JButton button = new JButton();
				button.setText("("+i+ " ," + j +")");
				Buttons.add(button);				//button.setIcon(btimg);
		//		button.setLayout(new GridLayout());
				//button.setSize(100, 100);


		// add it in the center of the JFrame
       this.map.add(button, new FlowLayout());
				
				
			}
		}
	}
	public display() {
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setSize(2000, 1000);
		this.setLayout(null);
		map=new JPanel();
		Buttons=new ArrayList<JButton>();
		this.AddButtons();
		map.setLayout(new GridLayout(10,10));
		map.setBounds(0, 0, 1700, 900);
		this.getContentPane().add(map);
		info=new JPanel();
		label=new JLabel();
		label.setText("number of casualties:");
		this.info.setLayout(null);
		info.setBounds(0,900,1700,100);
		this.label.setBounds(5,0,300,70);
		this.info.add(label);
		//this.info.setLayout(new FlowLayout());
		this.info.setBackground(Color.ORANGE);
		this.getContentPane().add(info);
		this.NextCycle=new JButton("nextCyle");
		this.NextCycle.setBounds(5, 70, 170, 30);
		this.info.add(this.NextCycle);
		this.SOSmessage=new JTextArea();
		this.SOSmessage.setText("help!");
		this.info.add(this.SOSmessage);
		this.SOSmessage.setBounds(500, 10,990 ,70);
		this.side= new JPanel();
		this.side.setLayout(null);
		this.side.setBounds(1700, 0, 300, 1000);
		this.getContentPane().add(side);
		this.side.setBackground(Color.LIGHT_GRAY);
		this.information=new JButton("Info");
		this.information.setBounds(5, 10,190,320);
		this.side.add(this.information);
		this.units=new JButton("Units");
		this.units.setBounds(5, 340,190,320);
		this.side.add(this.units);
		this.log=new JButton("activiy");
		this.log.setBounds(5, 670,190,320);
		this.side.add(this.log);
		this.information.addActionListener(this);
		this.units.addActionListener(this);
		this.log.addActionListener(this);
		this.txt1=new JTextArea();
		this.txt1.setEditable(false);
		this.txt1.setFont(new Font(Font.SERIF, Font.PLAIN,50));
		this.txt2=new JTextArea();
		this.txt2.setEditable(false);
		this.txt2.setFont(new Font(Font.SERIF, Font.PLAIN,50));
		this.txt3=new JTextArea();
		this.txt3.setEditable(false);
		this.txt3.setFont(new Font(Font.SERIF, Font.PLAIN,50));
		this.back=new JButton("Back");
		this.back.addActionListener(this);
		//lma bnhot setsize fo2 msh byshtaghal
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
	}
    public static void main(String[] args){
    	display x=new display();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.information) {
			this.side.remove(this.information);
			this.side.remove(this.units);
			this.side.remove(this.log);
			this.side.add(this.back);
            this.back.setBounds(15,10 ,190, 50);
            this.side.add(txt1);
            this.txt1.setBounds(15, 60, 200, 920);
		}
		if(e.getSource()==this.units) {
			this.side.removeAll();
			this.side.add(this.back);
            this.back.setBounds(15,10 ,190, 50);
            this.side.add(txt2);
            this.txt2.setBounds(15, 60, 200, 920);
		}
		if(e.getSource()==this.log) {
			this.side.remove(this.information);
			this.side.remove(this.units);
			this.side.remove(this.log);
			this.side.add(this.back);
            this.back.setBounds(15,10 ,190, 50);
            this.side.add(txt3);
            this.txt3.setBounds(15, 60, 200, 920);
		}
		if(e.getSource()==this.back) {
			this.side.removeAll();
			this.side.add(this.information);
			this.information.setBounds(5, 10,190,320);
			this.side.add(this.units);
			this.units.setBounds(5, 340,190,320);
			this.side.add(this.log);
			this.log.setBounds(5, 670,190,320);
		}
		
	}
}
