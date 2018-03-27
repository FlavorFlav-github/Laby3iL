package structureDonnées;

/**
 * 
 * @author Yanicet
 *
 * @param <T>
 */
public class Element<T>{
	private Element<T> nextElem;
	private Element<T> prevElem;
	private T value;
	/**
	 * @param value
	 */
	public Element(T value) {
		super();
		this.value = value;
	}
	/**
	 * @return the nextElem
	 */
	public Element<T> getNextElem() {
		return nextElem;
	}
	/**
	 * @param nextElem the nextElem to set
	 */
	public void setNextElem(Element<T> nextElem) {
		this.nextElem = nextElem;
	}
	/**
	 * @return the prevElem
	 */
	public Element<T> getPrevElem() {
		return prevElem;
	}
	/**
	 * @param prevElem the prevElem to set
	 */
	public void setPrevElem(Element<T> prevElem) {
		this.prevElem = prevElem;
	}
	/**
	 * @return the value
	 */
	public T getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	
}
