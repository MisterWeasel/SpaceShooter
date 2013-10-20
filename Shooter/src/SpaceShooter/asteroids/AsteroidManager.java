package SpaceShooter.asteroids;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class AsteroidManager extends Thread{
	private static long threadSleep = 50;
	private static double minspeed = 7, maxspeed = 10;
	private static int minsize = 10, maxsize = 50;
	private ArrayList<Asteroid> asteroids;
	
	public AsteroidManager() {
		asteroids = new ArrayList<Asteroid>();
		start();
	}
	
	public void drawAsteroids(Graphics2D g) {
		for(Asteroid a : asteroids) {
			a.drawAsteroid(g);
		}
	}
	
	public void split(Asteroid dying) {
		Asteroid[] children = dying.split();
		
		asteroids.remove(dying);
		asteroids.add(children[0]);
		asteroids.add(children[1]);
		
		System.out.println(children[0].toString());
	}
	
	/**
	 * Creates an asteroid at a random spot in the given area.
	 * @param x Left-most side of area
	 * @param y Upper-most side of area
	 * @param width Distance from x to right side of area.
	 * @param height Distance from y to lower side of area.
	 */
	public void createAsteroid(int x, int y, int width, int height) {
		double direction = Math.random()*2*Math.PI;
		int xcoord = (int) ((Math.random()*width + x)*Math.cos(direction));
		int ycoord = (int) ((Math.random()*height + y)*Math.sin(direction));
		ycoord = (int)(ycoord*0.5);
		
		double speed = Math.random()*(maxspeed-minspeed) + minspeed;
		int size = (int) (Math.random()*(maxsize-minsize) + minsize);
		
		Asteroid newAsteroid = new Asteroid(xcoord, 0, Math.PI/6, speed, size);
		asteroids.add(newAsteroid);
		
	}
	
	public double determineDirection(int x, int y, int width, int height) {
		if(x < 0){
			return Math.random()*Math.PI - Math.PI/2;
		} else if(x > width) {
			return Math.random()*Math.PI + Math.PI/2;
		}
		
		if(y < 0) {
			return Math.random()*Math.PI;
		} else if(y > height) {
			return Math.random()*-Math.PI;
		}
		return 0;
	}
	
	@Override
	public void run() {
		while(true) {
			for(Asteroid a : asteroids) {
				a.moveAsteroid();
			}
			
			try {
				sleep(threadSleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
