/**
 * 
 */
package mod�le;

import structureDonn�es.ListeChainee;

/**
 * @author Yanicet
 *
 */
public interface IExplorable {
	ListeChainee<Position> EtapesSuivantes(Position pos);
	boolean EstArriv�e(Position posAct, Position posArr);
}
