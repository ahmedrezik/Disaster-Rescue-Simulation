package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import simulation.Simulator;
import javax.swing.*;
import javax.swing.border.Border;


public class GameDisplay extends JFrame implements ActionListener {
	private JPanel map;
	private JPanel info;
	//private JPanel units;
	private JLabel label;
	private JPanel sidePane; 
	private JTextArea activity;
	private JTextArea information;
	private JButton b;
	private JButton c;
	private JButton d;
	private JButton back;
	private ArrayList<JButton> Buttons;
	private JButton NextCycle;
	private JTextArea txt2;
	private JPanel unit;
	private JPanel responding;
	private JTextArea txt3;
	private JScrollPane scroll;
	private JButton respond;
	private JPanel elzorar;
	
//ImageIcon btimg = new ImageIcon("Resources/Unknown.jpeg");
	
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
public GameDisplay() {
	this.setVisible(true);
	//this.setResizable(false);
	this.Buttons=new ArrayList<JButton>();
this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
//Exit operation
this.setDefaultCloseOperation(EXIT_ON_CLOSE);

this.map = new JPanel();
//this.map.setPreferredSize(new Dimension(this.WIDTH-600, this.HEIGHT-800));
this.getContentPane().add(this.map,BorderLayout.CENTER);

//this.map.setSize(d);

//this.map.setBounds(0, 0, this.getWidth(), this.getHeight() -250);
this.map.setBackground(Color.BLACK);

this.info = new JPanel();
this.add(this.info,BorderLayout.SOUTH);
this.info.setBounds(0, this.getHeight()-this.map.getHeight(), this.getWidth(), this.getHeight() );
AddButtons();
this.info.setBackground(Color.RED);
 NextCycle = new JButton();

this.label = new JLabel();
// TODO: fadel elnumber
this.info.setLayout(new FlowLayout());
this.label.setText("Number Of Casualties:");
//this.label.setVisible(true);
this.info.setLayout(new BorderLayout());
this.info.add(this.label,BorderLayout.WEST);
this.info.add(NextCycle,BorderLayout.CENTER);
NextCycle.setText("NextCycle");
this.sidePane = new JPanel();
	//this.sidePane.setSize(new Dimension(900,200));
this.txt2=new JTextArea();
this.unit=new JPanel();
this.txt3=new JTextArea();
this.responding=new JPanel();

	this.sidePane.setBackground(Color.orange);
	this.getContentPane().add(this.sidePane, BorderLayout.EAST);
	this.sidePane.setLayout(new GridLayout(3,1));
	b = new JButton("info");
	b.addActionListener(this);
	this.sidePane.add(b);
    c=new JButton("activity log");
	this.sidePane.add(c);
	c.addActionListener(this);
    d=new JButton("units");
	this.sidePane.add(d);
	d.addActionListener(this);
	this.sidePane.setSize(80,90);
	//this.sidePane.setBounds(0, 0, 90, this.HEIGHT);
	back=new JButton("Back");
	back.setSize(new Dimension(10,10));
	back.addActionListener(this);
	this.activity = new JTextArea();
	this.activity.setFont(new Font(Font.SERIF, Font.PLAIN,  18));
	this.activity.setEditable(false);
	//this.activity.setVisible(false);
	//this.activity.setText("okay");
	//this.activity.setName();
	this.activity.setLocation(this.getWidth(), 0 );
	this.scroll=new JScrollPane(this.activity);
	this.scroll.setLayout(new ScrollPaneLayout());
	this.scroll.createVerticalScrollBar();
	this.respond=new JButton("Respond");
	this.elzorar=new JPanel();
	this.elzorar.add(this.txt3);
	this.elzorar.add(respond);

	//this.units.setLayout(new GridLayout(3,1));
	
	//this.getactivity().setAutoscrolls(true);
	//this.activity.setText("hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n"+"hhhhhhhhhhh"+"\n");
	//Timer timer = new Timer(500, Actione )
	//this.back.setPreferredSize(new Dimension(1,1));	
	//this.back.setMaximumSize(new Dimension(100,100));
}
	public static void main(String [] args) {
	GameDisplay game = new GameDisplay();
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b) {
			this.sidePane.setLayout(new BorderLayout());
			this.sidePane.remove(b);
			this.sidePane.remove(c);
			this.sidePane.remove(d);
			this.sidePane.add(back,BorderLayout.NORTH);
            this.sidePane.add(this.scroll);
            this.validate();
            this.repaint();
		//this.activity.setVisible(true);
		}
		
		if(e.getSource() == d) {
			this.sidePane.remove(b);
			this.sidePane.remove(c);
			this.sidePane.remove(d);
			this.sidePane.add(back,BorderLayout.NORTH);
            this.sidePane.add(this.unit);
            this.sidePane.add(this.responding);
            this.validate();
            this.repaint();
            //this.sidePane.add();
            }
		if(e.getSource() == c) {
			this.sidePane.setLayout(new BorderLayout());
			this.sidePane.remove(b);
			this.sidePane.remove(c);
			this.sidePane.remove(d);
			this.sidePane.add(back,BorderLayout.NORTH);
            this.sidePane.add(this.scroll);
		this.activity.setVisible(true);
		this.repaint();
		this.validate();
            }
		if(e.getSource()==back) {
			this.sidePane.setLayout(new GridLayout(3,1));
			//this.sidePane.remove(this.activity);
			this.sidePane.removeAll();
			this.sidePane.add(b);
			this.sidePane.add(c);
			this.sidePane.add(d);
			this.validate();
			this.repaint();
			//this.sidePane.remove(back);
		}
	}
	public JPanel getMap() {
		return map;
	}
	public void setMap(JPanel map) {
		this.map = map;
	}
	public JPanel getInfo() {
		return info;
	}
	public void setInfo(JPanel info) {
		this.info = info;
	}
//	public JPanel getUnits() {
//		return units;
//	}
//	public void setUnits(JPanel units) {
//		this.units = units;
//	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	public JPanel getSidePane() {
		return sidePane;
	}
	public void setSidePane(JPanel sidePane) {
		this.sidePane = sidePane;
	}
	public JTextArea getactivity() {
		return activity;
	}
	public void setactivity(JTextArea activity) {
		this.activity = activity;
	}
	public JButton getB() {
		return b;
	}
	public void setB(JButton b) {
		this.b = b;
	}
	public JButton getC() {
		return c;
	}
	public void setC(JButton c) {
		this.c = c;
	}
	public JButton getD() {
		return d;
	}
	public void setD(JButton d) {
		this.d = d;
	}
	public JButton getBack() {
		return back;
	}
	public void setBack(JButton back) {
		this.back = back;
	}
	public ArrayList<JButton> getButtons() {
	   return Buttons;
	}
	public void setButtons(ArrayList<JButton> buttons) {
		Buttons = buttons;
	}
	public JButton getNextCycle() {
		return NextCycle;
	}
	public void setNextCycle(JButton nextCycle) {
		NextCycle = nextCycle;
	}
	public JTextArea getTxt2() {
		return txt2;
	}
	public void setTxt2(JTextArea txt2) {
		this.txt2 = txt2;
	}
	public JPanel getUnit() {
		return unit;
	}
	public void setUnit(JPanel unit) {
		this.unit = unit;
	}
	public JPanel getResponding() {
		return responding;
	}
	public void setResponding(JPanel responding) {
		this.responding = responding;
	}
	public JTextArea getTxt3() {
		return txt3;
	}
	public void setTxt3(JTextArea txt3) {
		this.txt3 = txt3;
	}
	public JButton getRespond() {
		return respond;
	}
	public void setRespond(JButton respond) {
		this.respond = respond;
	}
	public JPanel getElzorar() {
		return elzorar;
	}
	public void setElzorar(JPanel elzorar) {
		this.elzorar = elzorar;
	}
	
}
