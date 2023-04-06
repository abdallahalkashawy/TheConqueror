package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import engine.Player;

public class View implements ActionListener {

	  JFrame Game;
	  JButton button;
	  JTextField Name;
	  engine.Game game;
 View()
	  {		
		ImageIcon Image= new ImageIcon("Images/download.jfif");
		Game = new JFrame();
		button = new JButton();
		button.setSize(200,200);
		button.setBounds(585,450, 200, 30);
		button.setText("START");
		button.setFocusable(false);
		button.setBackground(Color.ORANGE);
		button.setFont(new Font(Font.DIALOG,Font.PLAIN,50));
		button.addActionListener(this);
		Game.setDefaultCloseOperation(Game.EXIT_ON_CLOSE);
		Game.setVisible(true);
		Game.setSize(2000, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Game.setLocation(dim.width/2-Game.getSize().width/2, dim.height/2-Game.getSize().height/2);
		Game.setIconImage(Image.getImage());
		Game.setTitle("Warrior");
		Game.getContentPane().setBackground(new Color(0x123456));
		JLabel Start = new JLabel();
		Start.setText("Enter Name");
		Start.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		Start.setHorizontalAlignment(JLabel.CENTER);
		Start.setVerticalAlignment(JLabel.CENTER);
		Name = new JTextField();
		Name.setBounds(585,350, 200, 30);
		Start.setFont(new Font(Font.SANS_SERIF,Font.BOLD,35));
		Start.setForeground(Color.WHITE);
		Game.add(button);
		Game.add(Name);
		Game.add(Start);
		
		Game.validate();
}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button)
		{
			if(Name.getText().equals(""))
			{
				new JOptionPane().showMessageDialog(null,"Please Enter Name");
				new View();
				Game.dispose();
			}
			else
			{
		     Game.dispose();
		     new NewPlayer(Name.getText());
			}
		}
		
	}
}
