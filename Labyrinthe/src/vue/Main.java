/**
 * 
 */
package vue;

import java.nio.file.Path;
import java.nio.file.Paths;

import modèle.Etape;
import modèle.Initialisation;
import modèle.Labyrinthe;
import modèle.Etape;
import structureDonnées.ArbreNAire;
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
		Path fichier = Paths.get("C:\\Users\\yassl\\Downloads\\map4.txt");
		
		StructureMatrice str = Initialisation.LectureFichier(fichier);
		
		Labyrinthe<StructureMatrice> lab = new Labyrinthe<StructureMatrice>();
		ListeChainee<Etape> lis = lab.rechercheItinéraireAEtoile(str, str.getDepartX(),str.getDepartY(), str.getArriverX(),str.getArriverY());
		lis.affiche();
		str.remplirChemin(lis);
		str.affiche();
		
	}

}
