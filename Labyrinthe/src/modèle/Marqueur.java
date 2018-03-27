/**
 * 
 */
package mod�le;

import structureDonn�es.IListeChainee;
import structureDonn�es.ListeChainee;

/**
 * <br/>Les cases qui on �t� marqu�es sont stock�es dans la listMarqueurs, 
 * donc si une position de case est pr�sente dans la liste cela 
 * revient � dire que le marqueur est � vrai sur cette case
 * 
 * @author Yanicet
 * <br/>
 * <b>Remarque : <i>Cette solution ne permet que des marqueurs binaires</i></b>
 */
public class Marqueur {
	private static IListeChainee<Position> listMarqueurs = new ListeChainee<Position>();
	public static void setMarqueur(Position pos){
		listMarqueurs.ajouterElem(pos);
	}
	public static boolean getMarqueur(Position pos){
		return listMarqueurs.estDansListe(pos);
	}
}
