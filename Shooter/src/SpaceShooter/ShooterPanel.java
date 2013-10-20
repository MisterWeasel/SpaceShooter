package SpaceShooter;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import SpaceShooter.asteroids.AsteroidManager;


public class ShooterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4873501085323547379L;
	private AsteroidManager asteroids;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Shooter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ShooterPanel panel = new ShooterPanel();
		panel.setBackground(Color.BLACK);
		
		panel.setOpaque(true);
		frame.setContentPane(panel);
		frame.setSize(800, 700);
		frame.setVisible(true);
		
		for(int i = 0; i < 100; i++) {
			panel.createAsteroid();
		}
		
		

	}
	
	public ShooterPanel(){
		
		this.asteroids = new AsteroidManager();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g.setColor(Color.WHITE);
		asteroids.drawAsteroids(g2);
		
		try {
			Thread.currentThread();
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}
	
	public void createAsteroid() {
		asteroids.createAsteroid(0, 0, 800, 700);
	}

}
