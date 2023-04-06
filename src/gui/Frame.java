package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame {
	JFrame Game;
	public Frame()
	{
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
	}

}
