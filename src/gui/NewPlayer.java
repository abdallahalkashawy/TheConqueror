package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Player;

public class NewPlayer implements ActionListener {
	JComboBox  Cities;
	engine.Game game;
	String Name;
	Player player;
	JLabel world;
	JLabel Info;
	JFrame Game;
	JButton button;
	String name;
	String citySelected;
	NewPlayer(String s)
	{
		name=s;
		Game= new JFrame();
		Info = new JLabel();
		ImageIcon Image= new ImageIcon("Images/download.jfif");
		ImageIcon Image2= new ImageIcon("Images/world-map.gif");
		button= new JButton();
		button.setSize(new Dimension(200,30));
		button.setPreferredSize(new Dimension(200,30));
		button.setText("NEXT");
		button.setFocusable(false);
		button.setBackground(Color.ORANGE);
		button.setFont(new Font(Font.DIALOG,Font.PLAIN,50));
		button.setVisible(true);
		button.addActionListener(this);
		Game.setDefaultCloseOperation(Game.EXIT_ON_CLOSE);
		Game.setVisible(true);
		Game.setSize(2000, 600);
		Game.setLayout(new FlowLayout());
		Game.setIconImage(Image.getImage());
		Game.setTitle("Warrior");
		Game.getContentPane().setBackground(new Color(0x123456));
		Game.setResizable(true);
		Game.validate();
		Info.setIcon(Image2);
		Info.setHorizontalAlignment(JLabel.CENTER);
		Info.setVerticalAlignment(JLabel.CENTER);
		Game.add(button);
		String[] City = {"Cairo","Rome","Sparta"};
		Cities = new JComboBox(City);
		Cities.setSize(200, 30);
		Cities.addActionListener(this);
		Cities.setSize(new Dimension(200,30));
		
	
		
		Game.add(Cities);
		Game.add(Info);
		
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Game.setLocation(dim.width/2-Game.getSize().width/2, dim.height/2-Game.getSize().height/2);
		Game.validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Cities)
		{
			citySelected= (String) Cities.getSelectedItem();
		}
		
		
		if(e.getSource()==button)
		{
			if(citySelected==null)
			{
				new JOptionPane().showMessageDialog(null, "Select City");
				new NewPlayer(name);
				Game.dispose();
			}
			else
			{
			
			
				try {
					new World_Map(name,citySelected);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Game.dispose();
			
		}
		}
			
	}
			
		
	
}

