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
	private static IListeChainee<Etape> listMarqueurs = new ListeChainee<Etape>();
	public static void setMarqueur(Etape pos){
		listMarqueurs.ajouterElem(pos);
	}
	public static boolean getMarqueur(Etape pos){
		return listMarqueurs.estDansListe(pos);
	}
}
