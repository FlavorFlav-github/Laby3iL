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
		return "(x : " + x + ", y : " + y + ",  Distance Départ : " + distanceDepuisDepart + ", Distance Arriver : " + distanceEstimeePourArrivee + ")";
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
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(distanceDepuisDepart);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(distanceEstimeePourArrivee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Etape)) {
			return false;
		}
		Etape other = (Etape) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
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
