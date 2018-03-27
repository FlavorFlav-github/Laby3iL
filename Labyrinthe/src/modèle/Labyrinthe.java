/**
 * 
 */
package modèle;

import structureDonnées.ArbreNAire;
import structureDonnées.File;
import structureDonnées.ListeChainee;

/**
 * @author Yanicet
 *
 */
public class Labyrinthe<E extends IExplorable>{
	public ListeChainee<Position> rechercheItinéraireLargeur(E structure, int posxDepart, int posyDepart, int posxArriver, int posyArriver){
		int i;
		Position depart = new Position(posxDepart, posyDepart);
		Position arriver = new Position(posxArriver, posyArriver);
		/*La file des positions à visitées*/
		File<Position> f;
		ListeChainee<Position> s;
		ArbreNAire<Position> a;
		Position u, v;
		Marqueur.setMarqueur(depart);
		f = new File<Position>();
		a = new ArbreNAire<Position>();
		f.enfiler(depart);
		a.ajouterElement(null, depart);
		while(!f.estVide()){
			/*On récupère le prochain élément de la file à traiter*/
			v = f.defiler();
			if(structure.EstArrivée(v, arriver)){
				/*On est au point d'arriver, on retourne la liste du chemin parcourus*/
				return construireChemin(a, v);
			}
			/*On récupère la liste des éléments adjacents à celui que l'on traite*/
			s = structure.EtapesSuivantes(v);
			for(i = 0; i < s.recupererTaille(); i++){
				u = s.recupererValeur(i);
				a.ajouterElement(v, u);
				if(!Marqueur.getMarqueur(u)){
					Marqueur.setMarqueur(u);
					f.enfiler(u);
				}
			}
		}
		return null;
	}
	
	public ListeChainee<Position> construireChemin(ArbreNAire<Position> a, Position arriver){
		ListeChainee<Position> chemin = a.remonterArbre(arriver);
		chemin.inverserList();
		return chemin;
	}
}
