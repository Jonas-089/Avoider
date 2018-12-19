package MoveTest;

import java.awt.Rectangle;

public class Player {

	//currently not used
	private Rectangle bounding;
	
	private int posX;
	private int posY;
	private int size;
	
	//creates a new player with the coordinates x and y and the size size (bounding is currently not used)
	public Player(int posX, int posY, int size) {
		
		bounding = new Rectangle(posX, posY, size, size);
		
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		
	}
	
	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}
	
	public int getSize() {
		return this.size;
	}

	//this method updates the players position 
	public void update(boolean up, boolean down, boolean left, boolean right) {
		
		if(up) {	
			if(posY <= 0) {
				//if you want the player to be teleported to the other side: posY = Main.boardHeight;
				posY = 0;
			} else {
				posY -= 10;
			}
		}
		
		if(down) {
			if(posY >= Main.boardHeight - size - 15) {
				//if you want the player to be teleported to the other side: posY = 0;
				posY = Main.boardHeight - size - 15;
			} else {
				posY += 10;
			}
		}
		
		if(left) {
			if(posX <= 0) {
				//if you want the player to be teleported to the other side: posX = Main.boardWidth;
				posX = 0;
			} else {
				posX -= 10;
			}
		}
		
		if(right) {
			if(posX >= Main.boardWidth - size) {
				//if you want the player to be teleported to the other side: posX = 0;
				posX = Main.boardWidth - size;
			} else {
				posX += 10;
			}
		}
		
		bounding.x = posX;
		bounding.y = posY;
		
	}
	
	public Rectangle getBounding() {
		
		return bounding;
		
	}
	
}
