package after.background;

import java.awt.Color;
import java.awt.Graphics;

import after.utils.Point;

public class Sling {

	Point slingPos;

	public void drawSlingshot(Graphics g) {
        g.setColor(Color.BLACK); 
        g.drawLine(100, 500, 100, 400);
	}

	public void drawRubber(Graphics g, Point birdPos, Point mousePos) {
		g.setColor(Color.BLUE);
		g.drawLine((int) birdPos.getPx(), (int) birdPos.getPy(),
				(int) mousePos.getPx(), (int) mousePos.getPy()); // montre l'angle et la vitesse
	}
}
