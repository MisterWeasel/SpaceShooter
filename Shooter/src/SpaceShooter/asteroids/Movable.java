package SpaceShooter.asteroids;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Movable {
	private int x, y;
	private double direction;
	private double speed;
	private AffineTransform transformer;
	
	public Movable(int x, int y, double direction, double speed) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.speed = speed;
		this.transformer = new AffineTransform();
		
	}
	
	/**
	 * Moves the object.
	 */
	public void move() {
		x += speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setDirection(double direction) {
		this.direction = direction;
		transformer.setToRotation(direction);
	}
	
	/**
	 * Draws the shape onto the given Graphics2D object.
	 * @param s The shape to draw.
	 * @param g The Graphics2D object to draw on.
	 */
	public void drawMovable(Ellipse2D.Double s, Graphics2D g) {
		transformer.setToTranslation(x, y);
		transformer.setToRotation(direction);
		
		g.fill(transformer.createTransformedShape(s));
	}
	
	/**
	 * Bounces away from other object at collision.
	 * @param Movable The object with which to collide
	 */
	public void bounce(Movable other) {
		
	}
	
	/**
	 * @return x-coordinate of object
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return y-coordinate of object
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @return speed of object.
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * @return direction of the object (in radians).
	 */
	public double getDirection() {
		return direction;
	}
	
	
}
