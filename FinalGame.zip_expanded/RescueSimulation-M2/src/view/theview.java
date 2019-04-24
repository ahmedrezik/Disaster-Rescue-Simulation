package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class theview extends JFrame implements ActionListener{
          private JPanel frame;
          private JPanel map;
          private JPanel side;
          private JPanel bottom;
          private JPanel IDLE;
          private JPanel Responding;
          private JButton Info;
          private JButton Units;
          private JButton nextCycle;
          private JLabel label;
          private JScrollPane scroll;
          private JTextArea SOS;
          private JTextArea sideInfo;
          private ArrayList<JButton> Buttons;
          private JButton  Respond;
          private JPanel respondPanel;
          private JTextArea UnitInfo; 
          private JScrollPane Unitscroll;
          private JTextArea Information;
          private JScrollPane InfoScroll;
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
          
          
       
	public theview() {
		this.setVisible(true);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		frame =new JPanel();
		Buttons=new ArrayList<JButton>();
		this.add(frame);
		this.frame.setBounds(0, 0,((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()) ,((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));
		this.frame.setBackground(Color.white);
		map=new JPanel();
		//this.AddButtons();
		this.frame.setLayout(null);
		this.frame.add(this.map);
		this.map.setBounds(10, 10, ((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth())-350, ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-170);
		this.AddButtons();
		this.side=new JPanel();
		this.side.setLayout(null);
	    this.Info=new JButton("Info");
	    this.Units=new JButton("Units");
	    this.side.add(this.Units);
	    this.Units.setBounds(150,10,140, 30);
	    this.sideInfo=new JTextArea();
	    this.sideInfo.setFont(new Font(Font.SERIF,Font.PLAIN,18));
	    this.sideInfo.setEditable(false);
	    this.scroll=new JScrollPane(this.sideInfo);
	    //this.sideInfo.setText("dnjjhdc");
	    this.scroll.setLayout(new ScrollPaneLayout());
	   // this.side.add(this.scroll);
	    this.scroll.setBounds(5,50, 285, ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-230);
	    this.side.add(this.Info);
	    this.Info.setBounds(5,10,140,30);
	    this.frame.add(this.side);
	    this.side.setBounds(((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth())-330,10,300,((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-170);
	   // this.side.add(this.scroll);
	    this.bottom = new JPanel();
	    bottom.setLayout(null);
	    this.frame.add(this.bottom);
	    bottom.setBounds(10, 920,((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth())-70, 130);
	    bottom.setBackground(Color.ORANGE);
	    this.nextCycle = new JButton();
	    this.nextCycle.setBounds(300,5, 100, 35);
	    this.nextCycle.setText("Next Cycle");
	    this.bottom.add(nextCycle);
	    label=new JLabel();
	    this.label.setText("numnber of casualties:0");
	    this.bottom.add(this.label);
	    this.label.setBounds(10, 1, 300,40);
	    this.Info.addActionListener(this);
	    this.Units.addActionListener(this);
	    this.Responding=new JPanel();
	    this.IDLE=new JPanel();
	    this.Respond=new JButton("Respond");
	    this.respondPanel=new JPanel();
	    this.UnitInfo=new JTextArea();
	    this.UnitInfo.setEditable(false);
	    this.UnitInfo.setFont(new Font(Font.SERIF,Font.PLAIN,18));
	    this.Unitscroll=new JScrollPane(this.UnitInfo);
	    this.Unitscroll.setLayout(new ScrollPaneLayout());
        this.Information=new JTextArea();
        this.Information.setEditable(false);
        this.Information.setFont(new Font(Font.SERIF,Font.PLAIN,18));
	    this.InfoScroll=new JScrollPane(this.Information);
	    this.InfoScroll.setLayout(new ScrollPaneLayout());
	    this.validate();
		this.repaint();
		this.Responding.setBackground(Color.WHITE);
		this.IDLE.setBackground(Color.WHITE);
		// TODO Auto-generated constructor stub
	}
    public static void main(String[] args) {
    	theview view=new theview();
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.Info) {
			//this.side.remove(this.Unitscroll);
			//this.side.remove(this.Responding);
			//this.side.remove(this.IDLE);
			//this.side.remove(this.scroll);
			this.side.removeAll();
			this.side.add(this.Units);
		    this.Units.setBounds(150,10,140, 30);
		    this.side.add(this.Info);
		    this.Info.setBounds(5,10,140,30);
			this.side.add(this.scroll);	
			this.scroll.setBounds(5,50, 285, ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-230);
		}
		if(e.getSource()==this.Units) {
			//this.side.remove(this.scroll);
			this.side.removeAll();
			this.side.add(this.Units);
		    this.Units.setBounds(150,10,140, 30);
		    this.side.add(this.Info);
		    this.Info.setBounds(5,10,140,30);
			this.side.add(this.IDLE);
			this.IDLE.setBounds(5, 50,285,((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-790);
			this.IDLE.setBackground(Color.MAGENTA);
			this.side.add(this.Responding);
			this.Responding.setBounds(5,350 ,285,((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-790);
			this.Responding.setBackground(Color.RED);
			//this.scroll.add(Respond);
		
			this.Respond.setBounds(180,210,100,35);
			this.side.add(this.Unitscroll);
			this.Unitscroll.setBounds(5,650 , 285, 250);
		}
		// TODO Auto-generated method stub
		this.validate();
		this.repaint();
	}
	public JPanel getFrame() {
		return frame;
	}
	public void setFrame(JPanel frame) {
		this.frame = frame;
	}
	public JPanel getMap() {
		return map;
	}
	public void setMap(JPanel map) {
		this.map = map;
	}
	public JPanel getSide() {
		return side;
	}
	public void setSide(JPanel side) {
		this.side = side;
	}
	public JPanel getBottom() {
		return bottom;
	}
	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}
	public JPanel getIDLE() {
		return IDLE;
	}
	public void setIDLE(JPanel iDLE) {
		IDLE = iDLE;
	}
	public JPanel getResponding() {
		return Responding;
	}
	public void setResponding(JPanel responding) {
		Responding = responding;
	}
	public JButton getInfo() {
		return Info;
	}
	public void setInfo(JButton info) {
		Info = info;
	}
	public JButton getUnits() {
		return Units;
	}
	public void setUnits(JButton units) {
		Units = units;
	}
	public JButton getNextCycle() {
		return nextCycle;
	}
	public void setNextCycle(JButton nextCycle) {
		this.nextCycle = nextCycle;
	}
	public JLabel getLabel() {
		return label;
	}
	public void setLabel(JLabel label) {
		this.label = label;
	}
	public JScrollPane getScroll() {
		return scroll;
	}
	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	public JTextArea getSOS() {
		return SOS;
	}
	public void setSOS(JTextArea sOS) {
		SOS = sOS;
	}
	public JTextArea getSideInfo() {
		return sideInfo;
	}
	public void setSideInfo(JTextArea sideInfo) {
		this.sideInfo = sideInfo;
	}
	public ArrayList<JButton> getButtons() {
		return Buttons;
	}
	public void setButtons(ArrayList<JButton> buttons) {
		Buttons = buttons;
	}
	public JButton getRespond() {
		return Respond;
	}
	public void setRespond(JButton respond) {
		Respond = respond;
	}
	public JPanel getRespondPanel() {
		return respondPanel;
	}
	public void setRespondPanel(JPanel respondPanel) {
		this.respondPanel = respondPanel;
	}
	public JTextArea getUnitInfo() {
		return UnitInfo;
	}
	public void setUnitInfo(JTextArea unitInfo) {
		UnitInfo = unitInfo;
	}
	public JScrollPane getUnitscroll() {
		return Unitscroll;
	}
	public void setUnitscroll(JScrollPane unitscroll) {
		Unitscroll = unitscroll;
	}
	public JTextArea getInformation() {
		return Information;
	}
	public void setInformation(JTextArea information) {
		Information = information;
	}
	public JScrollPane getInfoScroll() {
		return InfoScroll;
	}
	public void setInfoScroll(JScrollPane infoScroll) {
		InfoScroll = infoScroll;
	}
}
