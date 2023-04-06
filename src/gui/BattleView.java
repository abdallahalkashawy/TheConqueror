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

import engine.Player;

public class BattleView implements ActionListener {
	String player;
	engine.Game game;
	JFrame Game;
	JButton button;
	JButton button2;
	String citySelected;
	
	
	BattleView(String p , String c,engine.Game g)
	{
		player = p ;
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
		
		for(int i=0;i<9;i++)
		{
			JPanel v = new JPanel();
			v.setBackground(Color.RED);
			
			
			panel3.add(v);
		}

		Game.add(panel,BorderLayout.EAST);
		Game.add(panel2,BorderLayout.WEST);
		Game.add(panel3,BorderLayout.CENTER);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button)
		{
			new GameFlow(player,citySelected,game);
		}
		if(e.getSource()==button2)
		{
			new CityView(player,citySelected,game);
		}
	}

}
