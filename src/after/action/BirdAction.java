package after.action;

import after.items.Bird;
import after.utils.Point;

public class BirdAction {

	private double gravity;
	
	public BirdAction(double gravity) {
		this.gravity = gravity;
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
	
	public void birdMoving(Bird bird) {
		bird.setBirdPos(new Point(
    			bird.getBirdPos().getPx() + bird.getBirdVelocity().getPx(), 
    			bird.getBirdPos().getPy() + bird.getBirdVelocity().getPy()
    		)
    	);
    	
    	bird.setBirdVelocityY(bird.getBirdVelocity().getPy() + gravity);
	}
	
	


	
	
}
