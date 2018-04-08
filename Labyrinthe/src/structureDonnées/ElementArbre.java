/**
 * 
 */
package structureDonnées;

/**
 * @author yassl
 *
 */
public class ElementArbre<T extends Comparable<T>> implements Comparable<ElementArbre<T>>{
	private ListeChainee<ElementArbre<T>> nextElem;
	private ElementArbre<T> prevElem;
	private T value;
	/**
	 * @param value
	 */
	public ElementArbre(T value) {
		super();
		this.value = value;
	}
	/**
	 * @return the nextElem
	 */
	public ListeChainee<ElementArbre<T>> getNextElem() {
		return nextElem;
	}
	/**
	 * @param nextElem the nextElem to set
	 */
	public void setNextElem(ListeChainee<ElementArbre<T>> nextElem) {
		this.nextElem = nextElem;
	}
	/**
	 * @return the prevElem
	 */
	public ElementArbre<T> getPrevElem() {
		return prevElem;
	}
	/**
	 * @param prevElem the prevElem to set
	 */
	public void setPrevElem(ElementArbre<T> prevElem) {
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
	@Override
	public int compareTo(ElementArbre<T> o) {
		return value.compareTo(o.getValue());
	}
}
