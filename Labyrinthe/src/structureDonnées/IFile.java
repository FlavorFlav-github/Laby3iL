/**
 * 
 */
package structureDonn�es;

/**
 * @author Yanicet
 *
 */
public interface IFile<E> {
	void enfiler(E elem);
	E defiler();
	boolean estVide();
	int nbElem();
}
