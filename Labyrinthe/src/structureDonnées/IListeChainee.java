package structureDonnées;
/**
 * Interface pour une liste chainee
 * @author Yassine
 *
 * @param <T>
 */
public interface IListeChainee<T> {
	void ajouterElem(T obj1);
	void ajouterElem(T obj1, int i);
	boolean supprimerElem(T obj1);
	boolean supprimerElem(int indice);
	T recupererValeur(int indice); 
	boolean estDansListe(T obj1);
	void affiche();
	int recupererTaille();
	void inverserList();
}
