import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	//vars
	//screen dimensions
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 600;
	//Determines size of program
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
	static final int DELAY = 75;
	final int x[] = new int[GAME_UNITS];
	final int y[] = new int[GAME_UNITS];
	int bodyParts = 6;
	int applesAte;
	//x coord of apple
	int appleX;
	// y coord
	int appleY;
	//r for right
	char direction = 'R';
	boolean running = false;
	Timer timer;
	Random random;

	//constructor
	GamePanel(){
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}
	public void startGame() {
		newApple();
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {

			if(running) {
			g.setColor(Color.green);
			g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
			
			for(int i=0; i< bodyParts; i++) {
				if (i == 0) {
					g.setColor(Color.red);
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				} else {
					g.setColor(Color.blue);
					g.setColor( new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
					g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
				}
			}
			g.setColor(Color.cyan);
			g.setFont(new Font("Ink Free", Font.BOLD, 40));
			FontMetrics metrics = getFontMetrics(g.getFont());
			//center the game over div
			g.drawString("Score: "+applesAte, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesAte))/2, g.getFont().getSize());
		} else {
			gameOver(g);
		}
		
	}
		
	public void newApple() {
		appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
		appleX = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
	}
	public void moveSnake() {
		for (int i = bodyParts; i>0; i--) {
			//shifting coords in array by 1
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
		switch(direction) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
	}
	public void checkApple() {
		if((x[0] == appleX) && (y[0] == appleY)) {
			bodyParts++;
			applesAte++;
			newApple();
		}
	}
	public void checkCollision() {
		//end game if apple is hit (head collide w/ body)
		for(int i = bodyParts; i>0; i-- ) {
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
			}
		}
		//check if head touches left border
		if(x[0] < 0) {
			running = false;
		}
		//check if head touches right border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		//check top border
		if(y[0] < 0) {
			running = false;
		}
		//check bottom border
		if(x[0] > SCREEN_WIDTH) {
			running = false;
		}
		if (!running) {
			timer.stop();
		}
	}
	
	public void gameOver(Graphics g) {
		//display score on endscreen
		g.setColor(Color.cyan);
		g.setFont(new Font("Ink Free", Font.BOLD, 40));
		FontMetrics metrics = getFontMetrics(g.getFont());
		//center the game over div
		g.drawString("Score: "+applesAte, (SCREEN_WIDTH - metrics.stringWidth("Score: "+applesAte))/2, g.getFont().getSize());
		//Game Over Text
		g.setColor(Color.cyan);
		g.setFont(new Font("Ink Free", Font.BOLD, 80));
		FontMetrics metrics2 = getFontMetrics(g.getFont());
		//center the game over div
		g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/2, SCREEN_HEIGHT/2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (running) {
			moveSnake();
			checkApple();
			checkCollision();
			
		}
		repaint();
		
	}
	//snake control
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(direction != 'R') {
						direction = 'L';
					}
					break;
				case KeyEvent.VK_RIGHT:
					if(direction != 'L') {
						direction = 'R';
					}
					break;
				case KeyEvent.VK_UP:
					if(direction != 'D') {
						direction = 'U';
					}
					break;
				case KeyEvent.VK_DOWN:
					if(direction != 'U') {
						direction = 'D';
					}
					break;
			}
		}
	}

}
