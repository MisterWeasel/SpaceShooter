package SpaceShooter.shooter;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import SpaceShooter.asteroids.Movable;

public class Bullet extends Movable {

	private Rectangle2D.Double shape;
	private int xSize, ySize;
	public Bullet(int x, int y, double direction, double speed, int xSize, int ySize) {
		super(x, y, direction, speed);
		this.xSize = xSize;
		this.ySize = ySize;
		shape = new Rectangle2D.Double(x, y, xSize, ySize);
	}
	
	public void moveBullet() {
		move();
		shape.x += getX()-xSize/2;
		shape.y += getY()-ySize/2;
	}
	
	public void drawBullet(Graphics2D g) {
		//drawMovable(shape, g);
	}
	

}
