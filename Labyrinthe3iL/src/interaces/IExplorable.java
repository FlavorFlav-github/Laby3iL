/**
 * 
 */
package interaces;

import structureDonnées.ListeChainee;

/**
 * @author Yanicet
 *
 */
public interface IExplorable<T extends Comparable<T>> {
	ListeChainee<T> EtapesSuivantes(T pos);
	boolean EstArrivée(T posAct, T posArr);
}
