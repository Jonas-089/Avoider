package MoveTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame extends JFrame {
	
	Player player;
	Enemy[] enemy;
	
	private Screen screen;
	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;
	
	public Frame(Player player, Enemy[] enemy) {
		
		super("GAME");
		screen = new Screen();
		screen.setBounds(0, 0, 800, 600);
		add(screen);
		addKeyListener(new KeyHandler());
		this.player = player;
		this.enemy = enemy;
		
	}
	
	public boolean getUp() {
		return up;
	}
	
	public boolean getDown() {
		return down;
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public void repaintScreen() {
		
		screen.repaint();
		
	}

	private class Screen extends JLabel {
		
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			g.setColor(Color.BLACK);
			g.fillRect(player.getBounding().x, player.getBounding().y, player.getBounding().width, player.getBounding().height);
			
//			g.setColor(Color.RED);
//			g.fillRect(enemy.getPosX(), enemy.getPosY(), enemy.getSize(), enemy.getSize());
			
			for(int i = 0; i < enemy.length; i++) {
				
				if (enemy[i] != null) {
					g.setColor(Color.RED);
					g.fillRect(enemy[i].getPosX(), enemy[i].getPosY(), enemy[i].getSize(), enemy[i].getSize());
				}
				
			}
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("sansserif", Font.BOLD, 25));
			g.drawString("score: " + enemy[0].getScore(), 10, 25);
			g.drawString("hp: " + Main.health, 200, 25);
			
		}
		
	}
	
	private class KeyHandler implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_UP) up = true;
			if(e.getKeyCode() == KeyEvent.VK_DOWN) down = true;
			if(e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_UP) up = false;
			if(e.getKeyCode() == KeyEvent.VK_DOWN) down = false;
			if(e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
			if(e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
			
		}
		
	}
	
}
