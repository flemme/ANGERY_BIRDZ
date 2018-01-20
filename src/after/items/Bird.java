package after.items;

import java.awt.Color;
import java.awt.Graphics;

import after.utils.Point;

public class Bird {
	private Point birdPos, birdVelocity; // informations relatives à l'oiseau
	private boolean stopped;

	public Bird() {
		birdPos = new Point();
		birdVelocity = new Point();
	}

	/**
	 * @return the birdPos
	 */
	public Point getBirdPos() {
		return birdPos;
	}

	/**
	 * @param birdPos
	 *            the birdPos to set
	 */
	public void setBirdPos(Point birdPos) {
		this.birdPos = birdPos;
	}

	/**
	 * @return the birdVelocity
	 */
	public Point getBirdVelocity() {
		return birdVelocity;
	}

	/**
	 * @param birdVelocity
	 *            the birdVelocity to set
	 */
	public void setBirdVelocity(Point birdVelocity) {
		this.birdVelocity = birdVelocity;
	}

	/**
	 * @return the hasStopped
	 */
	public boolean isStopped() {
		return stopped;
	}

	/**
	 * @param hasStopped the hasStopped to set
	 */
	public void setStopped(boolean stopped) {
		this.stopped = stopped;
	}

	public void setBirdPosX(double px) {
		birdPos.setPx(px);
	}

	public void setBirdPosY(double py) {
		birdPos.setPx(py);
	}

	public void setBirdVelocityX(double px) {
		birdVelocity.setPx(px);
	}

	public void setBirdVelocityY(double py) {
		birdVelocity.setPy(py);
	}
	
	public boolean hasStopped() {
		return this.getBirdPos().getPx() < 20 || this.getBirdPos().getPx() > 780 || 
			   this.getBirdPos().getPy() < 0  || this.getBirdPos().getPy() > 480;
	}
	
	public boolean hitSomething(Point pos) {
		return Point.distance(this.getBirdPos().getPx(), this.getBirdPos().getPy(), 
        		pos.getPx(), pos.getPy()) < 35;
		
	}

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int) this.getBirdPos().getPx() - 20, (int) this.getBirdPos().getPy() - 20, 40, 40);
	}
}
