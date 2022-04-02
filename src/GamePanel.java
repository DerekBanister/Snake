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
	char direction = 'D';
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
		//turn board into grid
		for(int i =0; i<SCREEN_HEIGHT/UNIT_SIZE;i++) {
			g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
			//	
		}
		g.setColor(Color.green);
		g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
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
		case 'W':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'S':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'A':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'D':
			x[0] = x[0] - UNIT_SIZE;
			break;
		}
	}
	public void checkApple() {
		
	}
	public void checkCollision() {
		
	}
	public void gameOver(Graphics g) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
		}
	}

}
