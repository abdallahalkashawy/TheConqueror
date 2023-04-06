package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import buildings.ArcheryRange;
import buildings.Barracks;
import buildings.Stable;
import engine.Player;
import exceptions.BuildingInCoolDownException;
import exceptions.MaxRecruitedException;
import exceptions.NotEnoughGoldException;
import units.Archer;

public class GameFlow implements ActionListener {
	JFrame Game;
	JTextField Unit;
	JTextField City;
	JButton button;
	JButton button2;
	JButton button3;
	JButton button4;
	String player;
	engine.Game game;
	String citySelected;
	GameFlow( String p,String c , engine.Game g)
	{
		player= p;
		citySelected=c;
		game=g;
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
		panel3.setLayout(new GridLayout(3,3,4,4));
		panel3.setBackground(new Color(0x56473));
		panel.setLayout(new BorderLayout());
		JTextArea Info =new JTextArea();
		Info.setText(game.getPlayer().getName()+" \n"+"Current Turn : "+ game.getCurrentTurnCount()+ "\n"  +"\nGOLD:   \n"  + game.getPlayer().getTreasury() +"\n"+ "\n"+ "FOOD :   \n "+game.getPlayer().getFood());
		Info.setEditable(false);
		Info.setFont(new Font(null,Font.BOLD,20));
		panel.add(Info);
		button3 =new JButton();
		button3.setText("InitiateArmy");
		button3.addActionListener(this);
		Unit=new JTextField();
		Unit.setPreferredSize(new Dimension(200,30));
		City=new JTextField();
		City.setPreferredSize(new Dimension(200,30));
		JPanel panelin = new JPanel();
		panelin.setBackground(Color.blue);
		panelin.setPreferredSize(new Dimension(10,10));
		panelin.add(Unit);
		panelin.add(City);
		panelin.add(button3);
		button4 =new JButton();
		button4.setText("Relocate Unit");
		button4.addActionListener(this);
		panel3.add(panelin);
		JPanel panelon = new JPanel();
		Unit=new JTextField();
		Unit.setPreferredSize(new Dimension(200,30));
		City=new JTextField();
		City.setPreferredSize(new Dimension(200,30));
		panelon.setBackground(Color.CYAN);
		panelon.setPreferredSize(new Dimension(10,10));
		panelon.add(Unit);
		panelon.add(City);
		panelon.add(button4);
		panel3.add(panelon);

		
		
		
		Game.add(panel,BorderLayout.EAST);
		Game.add(panel2,BorderLayout.WEST);
		Game.add(panel3,BorderLayout.CENTER);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button3)
		{
		for(int i=0;i<game.getPlayer().getControlledCities().size();i++)	
			{
					if(City.getText()==game.getPlayer().getControlledCities().get(i).getName())
					{
						for(int j =0 ;j<game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++)
						{
						if(Unit.getText()=="Archer"  && game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof ArcheryRange)
						{
							try {
								
								game.getPlayer().initiateArmy(game.getPlayer().getControlledCities().get(i), game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).recruit());
							} catch (BuildingInCoolDownException | MaxRecruitedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						if(Unit.getText()=="Cavalry"  && game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Stable)
						{
							try {
								game.getPlayer().initiateArmy(game.getPlayer().getControlledCities().get(i), game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).recruit());
							} catch (BuildingInCoolDownException | MaxRecruitedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						if(Unit.getText()=="Infantry"  && game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Barracks)
						{
							try {
								game.getPlayer().initiateArmy(game.getPlayer().getControlledCities().get(i), game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).recruit());
							} catch (BuildingInCoolDownException | MaxRecruitedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						}
					}
			}
		}
		
		if(e.getSource()==button4)
		{
			
			for(int i=0;i<game.getPlayer().getControlledCities().size();i++)
			{	
			if(City.getText()==game.getPlayer().getControlledCities().get(i).getName())
				try {
					game.getPlayer().recruitUnit(Unit.getText(),game.getPlayer().getControlledCities().get(i).getName());
				} catch (BuildingInCoolDownException | MaxRecruitedException | NotEnoughGoldException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

		
		
	}
	
	
	
	

}
