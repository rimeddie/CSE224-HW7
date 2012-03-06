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


public class GUI extends JPanel {

	private JPanel mainPanel;
	private JButton b1, b2;
	private JLabel clock;
	private static final long serialVersionUID = 1L;
	public GUI(){
		mainPanel = new DrawEco();
		clock = new JLabel("January 01");

		b1 = new JButton("Next");
		b1.setMnemonic(KeyEvent.VK_D);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Days when = Main.queue.next_event_tick();
				if (when == null)
					System.exit(0);
				Main.queue.dispatch_through(when);
				clock.setText(when.toString());
				GUI.this.repaint();
			}
		});

		b2 = new JButton("TODO implement stop/pause");
		b2.setMnemonic(KeyEvent.VK_M);
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});

		add(mainPanel);
		add(clock);
		add(b1);
		add(b2);
	}

	private static class DrawEco extends JPanel{
		private static final long serialVersionUID = 2L;
		private static final int xSize = 600, ySize = 600;
		private static final Color bgColor = Color.black;
		private static final Color ovalColor = new Color(0x8b, 0x45, 0x13);

		public DrawEco(){
			this.setPreferredSize(new Dimension(xSize, ySize));
			this.setSize(xSize, ySize);
		}

		@Override
		public void paintComponent(Graphics g){
			Graphics2D g2 = (Graphics2D) g;
			g2.setBackground(bgColor);
			g2.setColor(ovalColor);
			g2.fillOval(0, 0, xSize, ySize);
			
			for (MapObject obj: Main.map) {
				Point where = obj.location;
				int x = where.x * xSize / 32000 + xSize/2;
				int y = where.y * ySize / 32000 + ySize/2;
				final int r = 16;
				g2.setColor(obj.get_color());
				g2.fillOval(x - r/2, y - r/2, r, r);
			}
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
