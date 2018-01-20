package after.utils;

public class Point {

	private double px;
	private double py;
	
	
	public Point() {}

	public Point(double px, double py) {
		this.px = px;
		this.py = py;
	}
	
	/**
	 * @return the px
	 */
	public double getPx() {
		return px;
	}


	/**
	 * @param px the px to set
	 */
	public void setPx(double px) {
		this.px = px;
	}


	/**
	 * @return the py
	 */
	public double getPy() {
		return py;
	}


	/**
	 * @param py the py to set
	 */
	public void setPy(double py) {
		this.py = py;
	}
	
    // calcule la distance entre deux points
    static public double distance(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
    }
    
}
