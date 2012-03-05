package edu.clark.ctec.cse224.hw7.b_longbons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI extends JPanel implements ActionListener{

	private JPanel mainPanel;
	private JPanel rightPanel;
	protected static JButton b1, b2;
	private static final long serialVersionUID = 1L;
	public GUI(){
		mainPanel = new JPanel();
		mainPanel.setLayout(new RiverLayout());
		mainPanel.setBackground(Color.black);
		mainPanel.add("left", new DrawEco());

		rightPanel = new JPanel();
		rightPanel.setLayout(new RiverLayout());
		rightPanel.setPreferredSize(new Dimension(180, 600));
		rightPanel.setBackground(Color.white);
		rightPanel.add("left", new DrawClock());

		b1 = new JButton("Rabbit");
		b1.setMnemonic(KeyEvent.VK_D);
		b1.setActionCommand("button1");
		b1.addActionListener(this);

		b2 = new JButton("Fox");
		b2.setMnemonic(KeyEvent.VK_M);
		b2.setActionCommand("button2");
		b2.addActionListener(this);

		add(mainPanel);
		add(rightPanel);
		add(b1);
		add(b2);



	}

	private class DrawClock extends JLabel {
		private static final long serialVersionUID = 1L;
	}

	private class DrawEco extends JPanel{
		private static final long serialVersionUID = 2L;
		public static final int xSize = 600;
		public static final int ySize = 600;

		public DrawEco(){
			this.setPreferredSize(new Dimension(600,600));
			this.setSize(xSize, ySize);
		}

		@Override
		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			Color bgColor = new Color(0,0,0);
			Color ovalColor = new Color(0,255,0);
			g2.setBackground(bgColor);
			g2.setColor(ovalColor);
			g2.fillOval(0, 0, 600, 600);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("button1".equals(e.getActionCommand())){
			System.out.println("You Pressed Button 1");
		} else {
			System.out.println("You Pressed Button 2");
		}

	}

	public static void createAndShowGui(){
		JFrame frame = new JFrame("EcoSystem");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GUI newContentPane = new GUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

}
