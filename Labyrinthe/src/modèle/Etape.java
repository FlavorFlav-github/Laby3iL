/**
 * 
 */
package modèle;

/**
 * @author yassl
 *
 */
public class Etape implements Comparable<Etape>, IPositionnable{
	private int x;
	private int y;
	private double distanceDepuisDepart;
	private double distanceEstimeePourArrivee;
	
	/**
	 * @param x
	 * @param y
	 */
	public Etape(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return the x
	 */
	@Override
	public int getX() {
		return x;
	}
	
	/**
	 * @return the y
	 */
	@Override
	public int getY() {
		return y;
	}

	@Override
	public String toString(){
		return "(x : " + x + ", y : " + y + ")";
	}
	@Override
	public int compareTo(Etape o) {
		if	((distanceDepuisDepart + distanceEstimeePourArrivee) > 
			(o.getDistanceDepuisDepart() + o.getDistanceEstimeePourArrivee()))return 1;
		else if((distanceDepuisDepart + distanceEstimeePourArrivee) < 
				(o.getDistanceDepuisDepart() + o.getDistanceEstimeePourArrivee()))return -1;
		else return 0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final double prime = 31;
		double result = 1;
		result = prime * result + distanceDepuisDepart;
		result = prime * result + distanceEstimeePourArrivee;
		result = prime * result + x;
		result = prime * result + y;
		return (int)result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etape other = (Etape) obj;
		if (distanceDepuisDepart != other.distanceDepuisDepart)
			return false;
		if (distanceEstimeePourArrivee != other.distanceEstimeePourArrivee)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	/**
	 * @return the distanceDepuisDepart
	 */
	public double getDistanceDepuisDepart() {
		return distanceDepuisDepart;
	}

	/**
	 * @param distanceDepuisDepart the distanceDepuisDepart to set
	 */
	public void setDistanceDepuisDepart(double distanceDepuisDepart) {
		this.distanceDepuisDepart = distanceDepuisDepart;
	}

	/**
	 * @return the distanceEstimeePourArrivee
	 */
	public double getDistanceEstimeePourArrivee() {
		return distanceEstimeePourArrivee;
	}

	/**
	 * @param distanceEstimeePourArrivee the distanceEstimeePourArrivee to set
	 */
	public void setDistanceEstimeePourArrivee(double distanceEstimeePourArrivee) {
		this.distanceEstimeePourArrivee = distanceEstimeePourArrivee;
	}
}
