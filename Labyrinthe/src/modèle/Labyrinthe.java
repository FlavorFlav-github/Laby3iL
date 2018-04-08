
package modèle;

import structureDonnées.ArbreNAire;
import structureDonnées.File;
import structureDonnées.ListeChainee;
import structureDonnées.StructureMatrice;

/**
 * @author Yanicet
 *
 */
public class Labyrinthe<E extends IExplorable<Etape> & IMesurable<Etape>>{
	public ListeChainee<Etape> rechercheItinéraireLargeur(E structure, int posxDepart, int posyDepart, int posxArriver, int posyArriver){
		int i;
		Etape depart = new Etape(posxDepart, posyDepart);
		Etape arriver = new Etape(posxArriver, posyArriver);
		/*La file des positions à visitées*/
		File<Etape> f;
		ListeChainee<Etape> s;
		ArbreNAire<Etape> a;
		Etape u, v;
		Marqueur.setMarqueur(depart);
		f = new File<Etape>();
		a = new ArbreNAire<Etape>();
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
				if(!Marqueur.getMarqueur(u)){
					a.ajouterElement(v, u);
					Marqueur.setMarqueur(u);
					f.enfiler(u);
				}
			}
		}
		return null;
	}
	
	
	public ListeChainee<Etape> rechercheItinéraireAEtoile(E structure, int posxDepart, int posyDepart, int posxArriver, int posyArriver){
		int i;
		Etape depart = new Etape(posxDepart, posyDepart);
		Etape arriver = new Etape(posxArriver, posyArriver);
		/*La liste des positions à visitées*/
		ListeChainee<Etape> f;
		ListeChainee<Etape> s;
		ArbreNAire<Etape> a;
		Etape u, v;
		Marqueur.setMarqueur(depart);
		f = new ListeChainee<Etape>();
		a = new ArbreNAire<Etape>();
		f.ajuterElemTrier(depart);
		a.ajouterElement(null, depart);
		while(!f.estVide()){
			/*On récupère le prochain élément de la file à traiter*/
			v = f.recupererValeur(0);
			f.supprimerElem(0);
			if(structure.EstArrivée(v, arriver)){
				/*On est au point d'arriver, on retourne la liste du chemin parcourus*/
				return construireChemin(a, v);
			}
			/*On récupère la liste des éléments adjacents à celui que l'on traite*/
			s = structure.EtapesSuivantes(v);
			for(i = 0; i < s.recupererTaille(); i++){
				u = s.recupererValeur(i);
				if(!Marqueur.getMarqueur(u)){
					a.ajouterElement(v, u);
					Marqueur.setMarqueur(u);
					u.setDistanceDepuisDepart(v.getDistanceDepuisDepart() + structure.distance(v, u));
					f.ajuterElemTrier(u);
				}
			}
		}
		return null;
	}
	
	public double calculDistanceEuclidienne(int x1, int y1, int x2, int y2){
		return Math.sqrt(((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)));
	}
	
	
	public ListeChainee<Etape> construireChemin(ArbreNAire<Etape> a, Etape arriver){
		ListeChainee<Etape> chemin = a.remonterArbre(arriver);
		chemin.inverserList();
		return chemin;
	}
	
	public void tracerChemin(ListeChainee<Etape> chemin, StructureMatrice s){
		for(int i = 0; i< chemin.recupererTaille(); i++){
			s.ajouterElem('.', chemin.getElem(i).getValue().getX(), chemin.getElem(i).getValue().getY());
		}
		s.affiche();		
	}
}
