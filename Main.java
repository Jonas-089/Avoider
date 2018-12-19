package MoveTest;

import java.util.Random;

import javax.swing.JFrame;

public class Main {
	
	public static final int boardWidth = 800;
	public static final int boardHeight = 800;
	
	public static int numEnemies = 1;
	public static int health = 20;

	public static void main(String[] args) {
		
		
//		Player player = new Player(300, 300, 100);
//		Enemy enemy = new Enemy(750, 300, 25, 9);
		
		Player player = new Player(300, 300, 75);
		
		int[] startFormation = startPosition(player);
		
		Enemy firstEnemy = new Enemy(700, 500, 25, 4);
		Enemy[] enemyArr = {firstEnemy, null, null, null, null, null, null, null, null};
		
		Frame f = new Frame(player, enemyArr);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(boardWidth, boardHeight);
		f.setTitle("GAME");
		f.setVisible(true);
		f.setResizable(false);
		
		outer: while(true) {
			
			//checks collision with player for every enemy
			for(int i = 0; i< enemyArr.length; i++) {
				if(enemyArr[i] != null) {
					if(collided(player, enemyArr[i])) {
						health--;
					}
					
					if(health < 0) {
						
						break outer;
						
					}
				}
			}
			
			//if the score has certain values, a new enemy is spawned
			if(((firstEnemy.getScore() == 7 || firstEnemy.getScore() == 15 || firstEnemy.getScore() == 21
					|| firstEnemy.getScore() == 30) || firstEnemy.getScore() == 50 || firstEnemy.getScore() == 75)
					|| firstEnemy.getScore() == 100 || firstEnemy.getScore() == 125) {
				
				startFormation = startPosition(player);
				
				Enemy newEnemy = new Enemy(startFormation[0], startFormation[1], 25, 4);
				
				enemyArr[numEnemies] = newEnemy;
				numEnemies++;
				enemyArr[0].setScore(1);
				
			}
			
			player.update(f.getUp(), f.getDown(), f.getLeft(), f.getRight());
			
			for(int i = 0; i < enemyArr.length; i++) {
				
				if(enemyArr[i] != null) {
					enemyArr[i].update();
				}
			}
			
			f.repaintScreen();
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	//this method detects a collision between an enemy and the player (code copied from google)
	public static boolean collided(Player player, Enemy enemy) {
		
		if(player.getPosX() < enemy.getPosX() + enemy.getSize()
		&& player.getPosX() + player.getSize() > enemy.getPosX()
		&& player.getPosY() < enemy.getPosY() + enemy.getSize()
		&& player.getSize() + player.getPosY() > enemy.getPosY()) {
			
			return true;
			
		} else {
			return false;
		}
		
	}
	
	//this method determines the random starting position of new enemies by detecting if they would directly
	//hit the player upon spawn (if so, new positions are generated)
	public static int[] startPosition(Player player) {
		
		Random rand = new Random();

		while(true) {
			
			int enemyX = rand.nextInt(700);
			int enemyY = rand.nextInt(500);
			

			if(!(player.getPosX() < enemyX + 200 && player.getPosX() + 200 > enemyX && player.getPosY() < enemyY + 200 
					&& 200 + player.getPosY() > enemyY)) {
				
				int[] correctValues = {enemyX, enemyY};
				return correctValues;
				
			}		
			
		}
		
	}
	
}
