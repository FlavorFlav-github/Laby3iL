/**
 * 
 */
package modèle;

import structureDonnées.ListeChainee;

/**
 * @author Yanicet
 *
 */
public interface IExplorable<T> {
	ListeChainee<T> EtapesSuivantes(T pos);
	boolean EstArrivée(T posAct, T posArr);
}
