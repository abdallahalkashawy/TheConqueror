package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import engine.City;
import engine.Player;
import units.Archer;
import units.Cavalry;
import units.Infantry;
import units.Status;


public class World_Map implements ActionListener{
	JButton button;
	JButton button2;
	JFrame Game;
	String player;
	String citySelected;
	engine.Game game;
	String CityName;
	String[] Control;
	String[] IDLEArmy;
	String[] MarchingArmy;
	String[] BeiseigArmy;
	JComboBox lpanel;
	JComboBox mpanel;
	JComboBox bpanel;
	World_Map(String s,String g) throws IOException
	{
		player=s;
		citySelected=g;
		game = new engine.Game(s,g);
		ImageIcon Image= new ImageIcon("Images/download.jfif");
		Game = new JFrame();
		Game.setDefaultCloseOperation(Game.EXIT_ON_CLOSE);
		Game.setVisible(true);
		Game.setSize(2000, 600);
		Game.setIconImage(Image.getImage());
		Game.setTitle("Warrior");
		Game.getContentPane().setBackground(new Color(0x123456));	
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Game.setLocation(dim.width/2-Game.getSize().width/2, dim.height/2-Game.getSize().height/2);
		Game.validate();
		button = new JButton();
		button.setPreferredSize(new Dimension(200,300));
//		button.setBounds(585,450, 200, 30);
		button.setText("NEXT");
		button.setFocusable(false);
		button.setBackground(Color.ORANGE);
		button.setFont(new Font(Font.DIALOG,Font.PLAIN,50));
		button.setVisible(true);
		button.addActionListener(this);
		button2 = new JButton();
		button2.setPreferredSize(new Dimension(200,300));
		button2.setText("BACK");
		button2.setFocusable(false);
		button2.setBackground(Color.ORANGE);
		button2.setFont(new Font(Font.DIALOG,Font.PLAIN,50));
		button2.setVisible(true);
		button2.addActionListener(this);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200,200));
		panel.setBackground(Color.white);
		JPanel panel2 = new JPanel();
		panel.setPreferredSize(new Dimension(300,300));
		panel.setBackground(Color.white);
		panel2.setLayout(new BorderLayout());
		panel2.add(button,BorderLayout.NORTH);
		panel2.add(button2,BorderLayout.SOUTH);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(8,8));
		panel3.setBackground(Color.black);
		
		for(int i=0 ; i<game.getPlayer().getControlledCities().size();i++)
		{
			Control = new String[game.getPlayer().getControlledCities().size()];
			Control[i]=game.getPlayer().getControlledCities().get(i).getName();
		}
		JComboBox spanel=new JComboBox(Control);
		panel3.add(spanel);
		
		if(game.getPlayer().getControlledArmies().size()==0)
		{
			JLabel Empty  = new JLabel();
			Empty.setText("NuLL");
			panel3.add(Empty);
		}
		else
		{
			for(int i = 0 ;i<game.getPlayer().getControlledArmies().size();i++)
			{
				if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus()==Status.IDLE)
				{
					for(int j = 0 ; j<game.getPlayer().getControlledArmies().get(i).getUnits().size();j++)
					{
						 IDLEArmy= new String[game.getPlayer().getControlledArmies().get(i).getUnits().size()];
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Archer)
						{
							IDLEArmy[j]="Archer ";
						}
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Cavalry)
						{
							IDLEArmy[j]="Cavalry";
						}
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Infantry)
						{
							IDLEArmy[j]="Infantry";
						}
					}
				}
				if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus()==Status.MARCHING)
				{
					for(int j = 0 ; j<game.getPlayer().getControlledArmies().get(i).getUnits().size();j++)
					{
						 MarchingArmy= new String[game.getPlayer().getControlledArmies().get(i).getUnits().size()];
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Archer)
						{
							MarchingArmy[j]="Archer  "+"CuurentSoldierCount " +game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+" Level "
									+game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()+" MaximumSoldierCount "+
									game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount()+" target City "+
									game.getPlayer().getControlledArmies().get(i).getTarget()+" LeftTurns "+
									game.getPlayer().getControlledArmies().get(i).getDistancetoTarget();
							
						}
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Cavalry)
						{
							MarchingArmy[j]="Cavalry  "+"CuurentSoldierCount " +game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+" Level "
									+game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()+" MaximumSoldierCount "+
									game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount()+" target City "+
									game.getPlayer().getControlledArmies().get(i).getTarget()+" LeftTurns "+
									game.getPlayer().getControlledArmies().get(i).getDistancetoTarget();
						}
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Infantry)
						{
							MarchingArmy[j]="Infantry  "+"CuurentSoldierCount " +game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+" Level "
									+game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()+" MaximumSoldierCount "+
									game.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount()+" target City "+
									game.getPlayer().getControlledArmies().get(i).getTarget()+" LeftTurns "+
									game.getPlayer().getControlledArmies().get(i).getDistancetoTarget();
						}
					}
				}
				if(game.getPlayer().getControlledArmies().get(i).getCurrentStatus()==Status.BESIEGING)
				{
					for(int j = 0 ; j<game.getPlayer().getControlledArmies().get(i).getUnits().size();j++)
					{
						BeiseigArmy= new String[game.getPlayer().getControlledArmies().get(i).getUnits().size()];
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Archer)
						{
							BeiseigArmy[j]="Archer " +" City "+game.getPlayer().getControlledArmies().get(i).getCurrentLocation() + " Turns " + game.getPlayer().getControlledArmies().get(i).getMaxToHold() ;
						}
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Cavalry)
						{
							BeiseigArmy[j]="Cavalry " +" City "+game.getPlayer().getControlledArmies().get(i).getCurrentLocation() + " Turns " + game.getPlayer().getControlledArmies().get(i).getMaxToHold() ;
						}
						if(game.getPlayer().getControlledArmies().get(i).getUnits().get(j) instanceof Infantry)
						{
							BeiseigArmy[j]="Infantry " +" City "+game.getPlayer().getControlledArmies().get(i).getCurrentLocation() + " Turns " + game.getPlayer().getControlledArmies().get(i).getMaxToHold() ;
						}
					}
				}
			
			}
			 lpanel=new JComboBox(IDLEArmy);
				panel3.add(lpanel);
				
				 mpanel=new JComboBox(MarchingArmy);
				panel3.add(mpanel);

				bpanel=new JComboBox(BeiseigArmy);
				panel3.add(bpanel);
		}
		
		
		


			
		
		
		
//		for(int i =0 ; i<game.getAvailableCities().size();i++ )
//		{
//			 spanel = new JLabel();
//			spanel.setFont(new Font(null,Font.BOLD,30));
//			spanel.setForeground(Color.WHITE);
//			spanel.setText(game.getAvailableCities().get(i).getName());
//			spanel.setBackground(Color.white);
//			panel3.add(spanel);
//		}
		
//		spanel.setPreferredSize(new Dimension(40,40));
//		spanel.setText("IDLE Armies");
//		spanel.setFont(new Font(null,Font.BOLD,30));
//		spanel.setForeground(Color.GREEN);
//		panel3.add(spanel);
		
//		spanel=new JLabel();
//		spanel.setPreferredSize(new Dimension(40,40));
//		spanel.setText("Null");
//		spanel.setFont(new Font(null,Font.BOLD,30));
//		spanel.setForeground(Color.WHITE);
//		panel3.add(spanel);
//		
//		spanel=new JLabel();
//		spanel.setPreferredSize(new Dimension(40,40));
//		spanel.setText("MARCHING OR BESISEIGING Armies");
//		spanel.setFont(new Font(null,Font.BOLD,20));
//		spanel.setForeground(Color.GREEN);
//		panel3.add(spanel);
		
//		spanel=new JLabel();
//		spanel.setPreferredSize(new Dimension(40,40));
//		spanel.setText("Null");
//		spanel.setFont(new Font(null,Font.BOLD,30));
//		spanel.setForeground(Color.WHITE);
//		panel3.add(spanel);
		panel.setLayout(new BorderLayout());
		JTextArea Info =new JTextArea();
		Info.setText(game.getPlayer().getName()+" \n"+"Current Turn : "+ game.getCurrentTurnCount()+ "\n"  +"\nGOLD:   \n"  + game.getPlayer().getTreasury() +"\n"+ "\n"+ "FOOD :   \n "+game.getPlayer().getFood());
		Info.setEditable(false);
		Info.setFont(new Font(null,Font.BOLD,20));
		
		
		panel.add(Info);
//		panel.add(Info2);
		
		Game.add(panel,BorderLayout.EAST);
		Game.add(panel2,BorderLayout.WEST);
		Game.add(panel3,BorderLayout.CENTER);
	
		
	}
	




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{	Game.dispose();	
			new CityView(player,citySelected,game);
	}
		if(e.getSource()==button2)
		{	Game.dispose();
			new NewPlayer(player);
		}
			
	}

	}

