import javax.swing.JFrame;

public class Game extends JFrame {
	Game() {
//		GamePanel panel = new GamePanel();
//		this.add(panel);
		this.add(new GamePanel());
		this.setTitle("Snake");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		//make panel appear in middle of computer
		this.setLocationRelativeTo(null);
	}
}
