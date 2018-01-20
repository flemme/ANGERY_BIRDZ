package after.background;

import java.awt.Color;
import java.awt.Graphics;

import after.items.*;
import after.utils.Point;

public class Stage {

	private Bird bird;
	private Pig pig;
	private Sling slingshot;
	
	private Point messagePos;
	private Point scorePos;
	
	private double gravity;
	private int score;                                  // nombre de fois où le joueur a gagné
	private String message;
	
	public Stage() {
        bird = new Bird();
        bird.setBirdPos(new Point(100,400));
        bird.setBirdVelocity(new Point());
        
        pig = new Pig();
        pig.setPigPos(new Point(Math.random() * 500 + 200, 480));
        
        slingshot = new Sling();
        
        messagePos = new Point(300,100);
        scorePos = new Point(20,20);
        
		this.gravity = 0.1;
		this.score = 0;
	}
	
	public void init(int score) {
		bird.setBirdPos(new Point(100,400));
        bird.setBirdVelocity(new Point());
        
        pig.setPigPos(new Point(Math.random() * 500 + 200, 480));
        
		this.score = score;
	}
	
	public void paint(Graphics g, int width, int height) {
        drawBackground(g, width, height);
        slingshot.drawSlingshot(g);
        drawMessage(g, messagePos);
        drawScore(g, scorePos);
	}
	
	public void drawBackground(Graphics g, int width, int height) {
        // fond
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // décor
        g.setColor(Color.BLACK); 
        g.drawLine(0, 500, 800, 500);
//        g.drawLine(100, 500, 100, 400);
	}

	public void drawMessage(Graphics g, Point messagePos) {
		// messages
        g.setColor(Color.BLACK);
        g.drawString(message, 300, 100);
	}
	
	public void drawScore(Graphics g, Point scorePos) {
		g.setColor(Color.BLACK);
		g.drawString("score: " + score, 20, 20);

	}
	
	/**
	 * @return the bird
	 */
	public Bird getBird() {
		return bird;
	}

	/**
	 * @param bird the bird to set
	 */
	public void setBird(Bird bird) {
		this.bird = bird;
	}

	/**
	 * @return the pig
	 */
	public Pig getPig() {
		return pig;
	}

	/**
	 * @param pig the pig to set
	 */
	public void setPig(Pig pig) {
		this.pig = pig;
	}

	/**
	 * @return the gravity
	 */
	public double getGravity() {
		return gravity;
	}

	/**
	 * @param gravity the gravity to set
	 */
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the slingshot
	 */
	public Sling getSlingshot() {
		return slingshot;
	}

	/**
	 * @param slingshot the slingshot to set
	 */
	public void setSlingshot(Sling slingshot) {
		this.slingshot = slingshot;
	}

	/**
	 * @return the messagePos
	 */
	public Point getMessagePos() {
		return messagePos;
	}

	/**
	 * @param messagePos the messagePos to set
	 */
	public void setMessagePos(Point messagePos) {
		this.messagePos = messagePos;
	}

	/**
	 * @return the scorePos
	 */
	public Point getScorePos() {
		return scorePos;
	}

	/**
	 * @param scorePos the scorePos to set
	 */
	public void setScorePos(Point scorePos) {
		this.scorePos = scorePos;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
