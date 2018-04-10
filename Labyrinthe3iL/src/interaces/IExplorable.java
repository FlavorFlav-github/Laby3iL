/**
 * 
 */
package interaces;

import structureDonn�es.ListeChainee;

/**
 * @author Yanicet
 *
 */
public interface IExplorable<T extends Comparable<T>> {
	ListeChainee<T> EtapesSuivantes(T pos);
	boolean EstArriv�e(T posAct, T posArr);
}
