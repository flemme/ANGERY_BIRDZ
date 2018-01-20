package after.items;

import java.awt.Color;
import java.awt.Graphics;

import after.utils.Point;

public class Pig {

	private Point pigPos;

	/**
	 * @return the pigPos
	 */
	public Point getPigPos() {
		return pigPos;
	}

	/**
	 * @param pigPos the pigPos to set
	 */
	public void setPigPos(Point pigPos) {
		this.pigPos = pigPos;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.GREEN);
        g.fillOval((int) this.getPigPos().getPx() - 20, (int) this.getPigPos().getPy() - 20, 40, 40);
	}
}
