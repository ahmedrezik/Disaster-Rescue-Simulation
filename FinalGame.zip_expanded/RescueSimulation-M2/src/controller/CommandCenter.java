package controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.print.attribute.standard.MediaSize.Engineering;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import exceptions.UnitException;
import model.events.SOSListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.people.CitizenState;
import model.units.Unit;
import model.units.UnitState;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulator;
import view.GameDisplay;
import view.GameOver;
import view.theview;
public class CommandCenter implements SOSListener,ActionListener{

	private Simulator engine;
	private ArrayList<ResidentialBuilding> visibleBuildings;
	private ArrayList<Citizen> visibleCitizens;
    private theview gameDisplay;
    private int cycle;
	@SuppressWarnings("unused")
	private ArrayList<Unit> emergencyUnits;
	private ArrayList<JButton> emergencies;
	private boolean flag=false;
	private int r;
	private ArrayList<JButton> occupants;
	private int x;
	private int y;
	private int z;

	public CommandCenter() throws Exception {
		engine = new Simulator(this);
		visibleBuildings = new ArrayList<ResidentialBuilding>();
		visibleCitizens = new ArrayList<Citizen>();
		emergencyUnits = engine.getEmergencyUnits();
		gameDisplay=new theview();
		 for(int i=0;i<gameDisplay.getButtons().size();i++) {
	        	gameDisplay.getButtons().get(i).addActionListener(this);
	        }
		 emergencies=new ArrayList<JButton>();
	        gameDisplay.getNextCycle().addActionListener(this);
	        gameDisplay.getLabel().setText("Number of Casualties:" + engine.calculateCasualties());
	        
	        for(int j=0;j<this.emergencyUnits.size();j++) {
	        	JButton a=new JButton(j+"");
	        	this.emergencies.add(a);
	        	a.addActionListener(this);
	        //	a.setIcon(new ImageIcon("ambulance.png"));
	        	this.gameDisplay.getIDLE().setLayout((new GridLayout(((int)Math.ceil(Math.sqrt(this.emergencyUnits.size()))),((int)Math.ceil(Math.sqrt(this.emergencyUnits.size()))))));
	        	this.gameDisplay.getResponding().setLayout((new GridLayout(((int)Math.ceil(Math.sqrt(this.emergencyUnits.size()))),((int)Math.ceil(Math.sqrt(this.emergencyUnits.size()))))));
	        	if(this.emergencyUnits.get(j).getState()==UnitState.IDLE)
	        		this.gameDisplay.getIDLE().add(a,new FlowLayout());
	        	//this.gameDisplay.getUnit().add(a, new FlowLayout());
	        	else this.gameDisplay.getResponding().add(a, new FlowLayout());
	        }
	        this.gameDisplay.getRespond().addActionListener(this);
	        occupants=new ArrayList<JButton>();
	        for(int i = 0 ; i < this.gameDisplay.getButtons().size(); i++) {
	        	int x = Integer.parseInt(this.gameDisplay.getButtons().get(i).getText().charAt(1)+ "");
	        	int y = Integer.parseInt(this.gameDisplay.getButtons().get(i).getText().charAt(4)+ "");
	        	
	        	if(engine.getBuildingByLocation2(new Address(x,y)) != null) {
                  this.gameDisplay.getButtons().get(i).setIcon(new ImageIcon("building.png"));
	        	}

	        	
	        }
	}
	
	
public void Addpics() {
	for(int i =0; i < this.visibleBuildings.size(); i++) {
		
	}
}

	@Override
	public void receiveSOSCall(Rescuable r) {
		
		if (r instanceof ResidentialBuilding) {
			
			if (!visibleBuildings.contains(r))
				visibleBuildings.add((ResidentialBuilding) r);
			
		} else {
			
			if (!visibleCitizens.contains(r))
				visibleCitizens.add((Citizen) r);
		}

	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(flag && (!(this.gameDisplay.getButtons().contains(e.getSource())) && !this.occupants.contains(e.getSource()))) {
			flag=false;
			JOptionPane pop = new JOptionPane();
			pop.showMessageDialog(null, "error", "alert", JOptionPane.ERROR_MESSAGE);
		}
//		if(e.getSource()==this.gameDisplay.getNextCycle()) {
//			JOptionPane pop = new JOptionPane();
//			pop.showMessageDialog(null, "error", "alert", JOptionPane.ERROR_MESSAGE);
			//pop.show(true);
//			
//		}
		if(e.getSource()== gameDisplay.getNextCycle()) {
			String y="";
			String x="";
			String z="";
			cycle++;
			//lazem n-handle da
			try {
				engine.nextCycle();
			} catch (Exception e1) {
				JOptionPane pop = new JOptionPane();
				pop.showMessageDialog(null, "Please try again later", "alert", JOptionPane.ERROR_MESSAGE);
			}
			finally{
				this.gameDisplay.validate();
				this.gameDisplay.repaint();
			}
		//System.out.println(engine.checkGameOver());
			 
			//visiblebuildings fadya bs buildings feha 3 elements
			 gameDisplay.getLabel().setText("Number of Casualties" + engine.calculateCasualties());
			 for(int i=0;i<this.visibleBuildings.size();i++){
				 if(this.visibleBuildings.get(i).getDisaster().getStartCycle()==cycle) {
					for(int t  =0 ; t < this.gameDisplay.getButtons().size(); t++) {
						int xcor = Integer.parseInt(this.gameDisplay.getButtons().get(t).getText().charAt(1)+ "");
			        	int ycor = Integer.parseInt(this.gameDisplay.getButtons().get(t).getText().charAt(4)+ "");
			        	if(engine.getBuildingByLocation2(new Address(xcor,ycor))!=null) {
			        	if(engine.getBuildingByLocation2(new Address(xcor,ycor)).equals(this.visibleBuildings.get(i))) {
			        		this.gameDisplay.getButtons().get(t).setIcon(new ImageIcon("cityscape.png"));}
			        	}
			        	
					}
					y+="Disaster "+ this.visibleBuildings.get(i).getDisaster().toString()+"\n";
				 }
				 if(this.visibleBuildings.get(i).getStructuralIntegrity()==0) {
					 x+="The Building located in ("+this.visibleBuildings.get(i).getLocation().getX()+","+this.visibleBuildings.get(i).getLocation().getY()+") is destroyed ,and all the occupants are dead"+"\n";
				 }
				 if(this.visibleBuildings.get(i).getGasLevel()==100) {
					 x+="Gas Level in Building located in ("+this.visibleBuildings.get(i).getLocation().getX()+","+this.visibleBuildings.get(i).getLocation().getY()+") reached 100 ,and all the occupants are Dead";
				 }
			 }
			 for(int i=0;i<this.visibleCitizens.size();i++) {
				 if(this.visibleCitizens.get(i).getState()==CitizenState.DECEASED) {
					 z+="The Citizen with id "+this.visibleCitizens.get(i).getNationalID()+" Located in ("+this.visibleCitizens.get(i).getLocation().getX()+","+this.visibleCitizens.get(i).getLocation().getY()+") is Dead"+"\n";
				 }
			 }
			 gameDisplay.getSideInfo().setText( gameDisplay.getSideInfo().getText()+"cycle"+cycle+"\n"+y+"\n"+x+"\n"+z);
	         gameDisplay.getLabel().setText("number of casualities:"+this.engine.calculateCasualties());	
	        // System.out.println(engine.checkGameOver());
	         //this.gameDisplay.getUnit().removeAll();
	         this.gameDisplay.getIDLE().removeAll();
	         this.gameDisplay.getResponding().removeAll();
	         while(!emergencies.isEmpty())
	         this.emergencies.remove(0);
	         for(int j=0;j<this.emergencyUnits.size();j++) {
		        	JButton a=new JButton(j+"");
		        	this.emergencies.add(a);
		        	a.addActionListener(this);
		        	this.gameDisplay.getIDLE().setLayout((new GridLayout(((int)Math.ceil(Math.sqrt(this.emergencyUnits.size()))),((int)Math.ceil(Math.sqrt(this.emergencyUnits.size()))))));
		        	this.gameDisplay.getResponding().setLayout((new GridLayout(((int)Math.ceil(Math.sqrt(this.emergencyUnits.size()))),((int)Math.ceil(Math.sqrt(this.emergencyUnits.size()))))));
		        	if(this.emergencyUnits.get(j).getState()==UnitState.IDLE)
		        		this.gameDisplay.getIDLE().add(a,new FlowLayout());
		        	//this.gameDisplay.getUnit().add(a, new FlowLayout());
		        	else this.gameDisplay.getResponding().add(a, new FlowLayout());
		        }
	         this.gameDisplay.getSide().removeAll();
				this.gameDisplay.getSide().add(this.gameDisplay.getUnits());
			    this.gameDisplay.getUnits().setBounds(150,10,140, 30);
			    this.gameDisplay.getSide().add(this.gameDisplay.getInfo());
			    this.gameDisplay.getInfo().setBounds(5,10,140,30);
				this.gameDisplay.getSide().add(this.gameDisplay.getScroll());	
				this.gameDisplay.getScroll().setBounds(5,50, 285, ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-230);
	         //System.out.println(engine.checkGameOver());
	         if(engine.checkGameOver()) {
				 //msh 3arfa n3ml eh
				        	 JOptionPane pop = new JOptionPane();
				 			pop.showMessageDialog(null, "Game Over, Your score is " + engine.calculateCasualties() + "", "alert", JOptionPane.ERROR_MESSAGE);
				 			GameOver end = new GameOver();
			 }
		}
		if(this.gameDisplay.getButtons().contains(e.getSource())) {
			//this.gameDisplay.getSide().removeAll();
//System.out.println(this.gameDisplay.getButtons().get(this.gameDisplay.getButtons().indexOf(e.getSource())).getText().charAt(4));
			int x=	Integer.parseInt(this.gameDisplay.getButtons().get(this.gameDisplay.getButtons().indexOf(e.getSource())).getText().charAt(1)+"");
		int y=	Integer.parseInt(this.gameDisplay.getButtons().get(this.gameDisplay.getButtons().indexOf(e.getSource())).getText().charAt(4)+"");
		if(flag==false) {
		if(engine.getBuildingByLocation2(new Address(x,y))!=null) {
			this.gameDisplay.getInformation().setText(engine.getBuildingByLocation2(new Address(x,y)).toString());
			for(int i=0;i<engine.getBuildingByLocation2(new Address(x,y)).getOccupants().size();i++) {
				this.gameDisplay.getInformation().setText(this.gameDisplay.getInformation().getText()+"\n"+"Occupant:"+(i+1)+"\n"+engine.getBuildingByLocation2(new Address(x,y)).getOccupants().get(i).toString()+"\n");
			}
		}else if(engine.getCitizenByLocation(new Address(x,y)).size()!=0) {	
			for(int i=0;i<engine.getCitizenByLocation(new Address(x,y)).size();i++) {
				this.gameDisplay.getInformation().setText(engine.getCitizenByLocation(new Address(x,y)).get(i).toString()+"\n");
			}
		}
		else this.gameDisplay.getInformation().setText("no information available");
		//this.gameDisplay.getSidePane().removeAll();
		//this.gameDisplay.getSidePane().setLayout(new BorderLayout());
		//this.gameDisplay.getSidePane().add(this.gameDisplay.getBack(),BorderLayout.NORTH);
		this.gameDisplay.getSide().removeAll();
		this.gameDisplay.getSide().add(this.gameDisplay.getUnits());
	    this.gameDisplay.getUnits().setBounds(150,10,140, 30);
	    this.gameDisplay.getSide().add(this.gameDisplay.getInfo());
	    this.gameDisplay.getInfo().setBounds(5,10,140,30);
		this.gameDisplay.getSide().add(this.gameDisplay.getInfoScroll());
		this.gameDisplay.getInfoScroll().setBounds(5,50, 285, ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-230);
		
		}
		else {
			if(engine.getBuildingByLocation2(new Address(x,y))!=null) {
				if(engine.getBuildingByLocation2(new Address(x,y)).getOccupants().size()==0) {	
						try {
							this.emergencyUnits.get(r).respond(engine.getBuildingByLocation2(new Address(x,y)));
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							//System.out.println(e1.getMessage());
							JOptionPane pop = new JOptionPane();
							pop.showMessageDialog(null, e1.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);
						}finally {
							this.gameDisplay.getInfo().addActionListener(this.gameDisplay);
							this.gameDisplay.validate();
							this.gameDisplay.repaint();
						}
						flag=false;
				}
				else {
					this.x=Integer.parseInt(this.gameDisplay.getButtons().get(this.gameDisplay.getButtons().indexOf(e.getSource())).getText().charAt(1)+"");
					this.y=Integer.parseInt(this.gameDisplay.getButtons().get(this.gameDisplay.getButtons().indexOf(e.getSource())).getText().charAt(4)+"");
					JButton d=new JButton("the Building");
					occupants.add(d);
					d.addActionListener(this);
					this.gameDisplay.getRespondPanel().add(d);
					for(int i=0;i<engine.getBuildingByLocation2(new Address(x,y)).getOccupants().size();i++){
						JButton z=new JButton("occupant:"+(i+1));
						z.addActionListener(this);
						occupants.add(z);
						this.gameDisplay.getSide().removeAll();
						this.gameDisplay.getSide().add(this.gameDisplay.getUnits());
					    this.gameDisplay.getUnits().setBounds(150,10,140, 30);
					    this.gameDisplay.getSide().add(this.gameDisplay.getInfo());
					    this.gameDisplay.getInfo().setBounds(5,10,140,30);
					    this.gameDisplay.getRespondPanel().add(z);
						this.gameDisplay.getSide().add(this.gameDisplay.getRespondPanel());
						this.gameDisplay.getRespondPanel().setBounds(5,50, 285, ((int)Toolkit.getDefaultToolkit().getScreenSize().getHeight())-230);
					}
				}
			}else if(engine.getCitizenByLocation(new Address(x,y)).size()!=0) {
				for(int i=0;i<engine.getCitizenByLocation(new Address(x,y)).size();i++){
					JButton z=new JButton("Citizen:"+(i+1));
					z.addActionListener(this);
					z.setIcon(new ImageIcon("family.png"));
					occupants.add(z);
					this.gameDisplay.getSide().add(z);
				}
			}else {
				 JOptionPane pop = new JOptionPane();
		 			pop.showMessageDialog(null, "no target is in here", "alert", JOptionPane.ERROR_MESSAGE);
		 			//this.gameDisplay.add(this.gameDisplay.getSideInfo());
			//this.gameDisplay.getTxt2().setText("no target is in here");
		 			
			}
			
			//this.gameDisplay.getSidePane().add(this.gameDisplay.getTxt2());
			
		}
		}
		if(emergencies.contains(e.getSource())) {
			//this.gameDisplay.getTxt3().add(this.gameDisplay.getRespond(),new FlowLayout());
			 System.out.println(this.emergencies.indexOf(e.getSource())); 
			this.gameDisplay.getUnitInfo().setText(this.emergencyUnits.get(this.emergencies.indexOf(e.getSource())).toString());
		   
		    r=this.emergencies.indexOf(e.getSource());
		    this.gameDisplay.getUnitInfo().add(this.gameDisplay.getRespond());
		    
		}
		if(e.getSource()==this.gameDisplay.getRespond()) {
			flag=true;
		}
		if(this.occupants.contains(e.getSource())) {
			if(occupants.get(this.occupants.indexOf(e.getSource())).getText().equals("the Building")) {
				try {
					emergencyUnits.get(r).respond(this.engine.getBuildingByLocation2(new Address(x,y)));
				} catch (Exception e1) {
					//System.out.println(emergencyUnits.get(r).canTreat(this.engine.getBuildingByLocation2(new Address(x,y))));
					//System.out.println("EKHRASSSSSS!");
					JOptionPane pop = new JOptionPane();
					pop.showMessageDialog(null, e1.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);
					this.gameDisplay.getInfo().addActionListener(this.gameDisplay);
				}	
				finally {
					this.gameDisplay.getRespondPanel().removeAll();
					while(!this.occupants.isEmpty())
						this.occupants.remove(0);
					this.gameDisplay.validate();
					this.gameDisplay.repaint();
				}
			}else {
				this.engine.getBuildingByLocation2(new Address(x,y)).getOccupants().get(occupants.indexOf(e.getSource())-1);
				try {
		            this.gameDisplay.getInfo().addActionListener(this.gameDisplay);
					emergencyUnits.get(r).respond(this.engine.getBuildingByLocation2(new Address(x,y)).getOccupants().get(occupants.indexOf(e.getSource())-1));
					
				} catch (Exception e1) {
					//System.out.println("blablabla");
					this.gameDisplay.getInfo().addActionListener(this.gameDisplay);
					JOptionPane pop = new JOptionPane();
					pop.showMessageDialog(null, e1.getMessage(), "alert", JOptionPane.ERROR_MESSAGE);
				}
				finally {
					this.gameDisplay.getRespondPanel().removeAll();
					while(!this.occupants.isEmpty())
						this.occupants.remove(0);
					this.gameDisplay.validate();
					this.gameDisplay.repaint();
				}
				
			}
			this.gameDisplay.getRespondPanel().removeAll();
			flag=false;
		}
	//	this.gameDisplay.getInfo().addActionListener(this.gameDisplay);
//		this.gameDisplay.getUnits().addActionListener(this.gameDisplay);
		this.gameDisplay.validate();
		this.gameDisplay.repaint();
	
	}
	public static void main(String [] args) throws Exception {
				CommandCenter c=new CommandCenter();
				//c.gameDisplay.setVisible(true);
	}

}


