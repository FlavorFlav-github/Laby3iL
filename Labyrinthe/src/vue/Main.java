/**
 * 
 */
package vue;

import modèle.Etape;
import modèle.Labyrinthe;
import modèle.Etape;
import structureDonnées.ListeChainee;
import structureDonnées.StructureMatrice;

/**
 * @author yassl
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		/*StructureMatrice str = new StructureMatrice(9,4);
		str.ajouterElem(' ', 0, 0);
		str.ajouterElem(' ', 0, 1);
		str.ajouterElem(' ', 1, 0);
		str.ajouterElem(' ', 1, 1);
		str.ajouterElem(' ', 1, 2);
		str.ajouterElem(' ', 1, 3);
		str.ajouterElem(' ', 0, 2);
		str.ajouterElem(' ', 0, 3);
		str.ajouterElem(' ', 2, 3);
		str.ajouterElem(' ', 3, 3);
		str.ajouterElem(' ', 3, 2);
		str.ajouterElem(' ', 3, 1);
		str.ajouterElem(' ', 3, 0);
		str.ajouterElem(' ', 4, 0);
		str.ajouterElem(' ', 5, 0);
		str.ajouterElem(' ', 5, 1);
		str.ajouterElem(' ', 5, 2);
		str.ajouterElem(' ', 5, 3);
		str.ajouterElem(' ', 6, 0);
		str.ajouterElem(' ', 6, 1);
		str.ajouterElem(' ', 6, 2);
		str.ajouterElem(' ', 6, 3);
		
		str.ajouterElem('d', 2, 0);
		str.ajouterElem('d', 2, 1);
		str.ajouterElem('d', 2, 2);
		str.ajouterElem('d', 4, 1);
		str.ajouterElem('d', 4, 2);
		str.ajouterElem('d', 4, 3);
		
		Labyrinthe<StructureMatrice> lab = new Labyrinthe<StructureMatrice>();
		ListeChainee<Etape> lis = lab.rechercheItinéraireLargeur(str, 0,0, 6,2);
		lis.affiche();*/
		
		ListeChainee<Integer> in = new ListeChainee<Integer>();
		in.ajuterElemTrier(6);
		in.ajuterElemTrier(5);
		in.ajuterElemTrier(7);
		in.affiche();
	}

}
