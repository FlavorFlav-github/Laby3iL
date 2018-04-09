/**
 * 
 */
package vue;

import java.nio.file.Path;
import java.nio.file.Paths;

import mod�le.Etape;
import mod�le.Initialisation;
import mod�le.Labyrinthe;
import mod�le.Etape;
import structureDonn�es.ArbreNAire;
import structureDonn�es.ListeChainee;
import structureDonn�es.StructureMatrice;

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
		ListeChainee<Etape> lis = lab.rechercheItin�raireAEtoile(str, str.getDepartX(),str.getDepartY(), str.getArriverX(),str.getArriverY());
		lis.affiche();
		str.remplirChemin(lis);
		str.affiche();
		
	}

}
