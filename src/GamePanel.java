import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{
	//vars
	static final int SCREEN_WIDTH = 650;
	static final int SCREEN_HEIGHT = 650;
	static final int UNIT_SIZE = 30;
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
		
	}
	public void newApple() {
		
	}
	public void moveSnake() {
		
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
