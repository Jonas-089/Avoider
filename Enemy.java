package MoveTest;

//this class represents one enemy with a given position, size and speed. the class also counts the score of the user
//(score = corner hits of the first enemy thats initialized in the main method
public class Enemy {

	private int enemyX;
	private int enemyY;
	private int size;
	
	private int speed;
	private int dirX = 1;
	private int dirY = 1;
	
	private int score = 0;
	private int wallHits = 0;
	
	public int getPosX() {
		return enemyX;
	}
	
	public int getPosY() {
		return enemyY;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int enemySize) {
		this.size = enemySize;
	}

	public int getScore() {
		return score;
	}
	
	public void setScore(int n) {
		this.score = score + n;
	}

	public Enemy(int x, int y, int size, int speed) {
		
		enemyX = x;
		enemyY = y;
		this.size = size;
		this.speed = speed;
	}
	
	public void update() {
		
		enemyX += dirX * speed;
		enemyY += dirY * speed;
		
		//20 ist magic number, die von der Größe des Gegnerballs abhängt
		if(enemyX > Main.boardWidth - 20 || enemyX < 0) {
			dirX = -dirX;
			score++;
			wallHits++;
		}
		
		//45 ist magic number, die von der Größe des Gegnerballs abhängt
		if(enemyY > Main.boardHeight - 45 || enemyY < 0) {
			dirY = -dirY;
			score++;
			wallHits++;
		}	
		
		//Schwierigkeit
		if(score <= 40) {
			
			if(wallHits > 20) {
				
				speed += 1;
				wallHits = 0;
			}
		}
	}
	
}
