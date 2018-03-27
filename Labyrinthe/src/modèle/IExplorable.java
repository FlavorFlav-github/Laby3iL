/**
 * 
 */
package modèle;

import structureDonnées.ListeChainee;

/**
 * @author Yanicet
 *
 */
public interface IExplorable {
	ListeChainee<Position> EtapesSuivantes(Position pos);
	boolean EstArrivée(Position posAct, Position posArr);
}
