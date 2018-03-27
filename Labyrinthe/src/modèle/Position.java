/**
 * 
 */
package modèle;

/**
 * @author yassl
 *
 */
public class Position implements Comparable<Position>, IPositionnable{
	private int x;
	private int y;
	
	/**
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
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
	public int compareTo(Position o) {
		int diffX = this.x - o.getX();
		int diffY = this.y - o.getY();
		if(diffX > 0 ) return 1;
		else if(diffX < 0 ) return -1;
		else{
			if(diffY > 0 ) return 1;
			else if(diffY < 0) return -1;
			else return 0;
		}
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
		Position other = (Position) obj;
		if (x != other.getX())
			return false;
		if (y != other.getY())
			return false;
		return true;
	}
}
