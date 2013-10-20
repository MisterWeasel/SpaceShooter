package SpaceShooter.asteroids;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Asteroid extends Movable {
	
	private int size;
	private Ellipse2D.Double shape;
	public Asteroid(int x, int y, double direction, double speed, int size) {
		super(x, y, direction, speed);
		shape = new Ellipse2D.Double(x-size/2, y-size/2, size, size);
		this.size = size;
		
	}
	
	/**
	 * Splits the Asteroid into two smaller asteroids
	 * @return An array of the two Asteroids
	 */
	public Asteroid[] split() {
		Asteroid childOne = new Asteroid(getX(), getY(), getDirection()+Math.PI/2, getSpeed(), size);
		Asteroid childTwo = new Asteroid(getX(), getY(), getDirection()-Math.PI/2, getSpeed(), size);
		Asteroid[] out = {childOne, childTwo};
		
		return out;
	}
	
	public void drawAsteroid(Graphics2D g) {
		drawMovable(shape, g);
	}
	
	public String toString() {
		return "X: " + getX() +
				"\nY: " + getY() +
				"\nSize: " + size;
	}
	
	public void moveAsteroid() {
		move();
		shape.x = getX()-size/2;
		shape.y = getY()-size/2;
	}
	

}
