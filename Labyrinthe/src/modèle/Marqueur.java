/**
 * 
 */
package modèle;

import structureDonnées.IListeChainee;
import structureDonnées.ListeChainee;

/**
 * <br/>Les cases qui on été marquées sont stockées dans la listMarqueurs, 
 * donc si une position de case est présente dans la liste cela 
 * revient à dire que le marqueur est à vrai sur cette case
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
