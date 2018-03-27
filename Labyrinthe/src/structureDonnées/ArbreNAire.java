/**
 * 
 */
package structureDonnées;

/**
 * @author Yanicet
 *
 */
public class ArbreNAire<T> implements IArbreNAire<T>{
	private ElementArbre<T> racine;
	private int nombreElement;
	
	/**
	 * Constructeur de la classe ArbreNAire qui 
	 * initialise le nombre d'élément de l'arbre à 0
	 */
	public ArbreNAire() {
		super();
		this.nombreElement = 0;
	}

	/**
	 * Ajoute un élement dans l'arbre sachant son père
	 * 
	 * @param elemPere la valeur de l'élément pere après lequel on doit ajouter le nouvelle élément
	 * @param noueauElem la valeur du nouvelle élément à ajouter
	 */
	@Override
	public void ajouterElement(T elemPere, T nouveauElem) {
		ElementArbre<T> newElem = new ElementArbre<T>(nouveauElem);
		/*Si l'arbre est vide ajoute l'élément à la racine*/
		if(racine == null){
			racine = newElem;
			this.nombreElement++;
		}
		else{
			/*L'ajout ne peut se faire que si l'élement pere est renseigné et si il existe*/
			if(elemPere != null){
				ElementArbre<T> pere = recupererElem(elemPere);
				if(pere != null){
					/*Si l'élément père n'a pas encore sa liste de fils créer, on la créer*/
					if(pere.getNextElem() == null){
						pere.setNextElem(new ListeChainee<ElementArbre<T>>());
					}
					pere.getNextElem().ajouterElem(newElem);
					newElem.setPrevElem(pere);
				}
			}
		}
		
	}

	/**
	 * Récupère un élément dans l'arbre
	 * 
	 * @return l'élément de larbre recherché
	 */
	@Override
	public ElementArbre<T> recupererElem(T elem) {
		ElementArbre<T> actu = this.racine;
		if(actu.getValue().equals(elem)) return actu;
		return parcoursRecursifRecherche(actu.getNextElem(),elem );
	}
	
	/**
	 * Recherche d'un élément dans l'arbre en parcours récusrsif
	 * @param listElem la liste des éléments à parcourir
	 * @param valeurCherche la valeur que l'on recherche
	 * @return l'élément de l'arbre recherché
	 */
	public ElementArbre<T> parcoursRecursifRecherche(ListeChainee<ElementArbre<T>> listElem, T valeurCherche ){
		ElementArbre<T> value;
		if(listElem != null){
			for(int i = 0; i<listElem.recupererTaille(); i++){
				value = listElem.recupererValeur(i);
				if(value.getValue().equals(valeurCherche)) return value;
				if(value.getNextElem() != null){
					value = parcoursRecursifRecherche(value.getNextElem(), valeurCherche );
					if(value != null) return value;
				}
			}
		}
		return null;
	}
	
	/**
	 * Affichage des élements de l'arbre en parcours récursif
	 * @param listElem
	 */
	public void parcoursRecursifAffiche(ListeChainee<ElementArbre<T>> listElem){
		ElementArbre<T> value;
		if(listElem != null){
			for(int i = 0; i<listElem.recupererTaille(); i++){
				value = listElem.recupererValeur(i);
				System.out.println(value.getValue().toString());
				if(value.getNextElem() != null){
					parcoursRecursifAffiche(value.getNextElem());
				}
			}
		}
	}
	
	/**
	 * Affiche le contenu de l'arbre
	 */
	@Override
	public void affiche() {
		ElementArbre<T> actu = this.racine;
		if(actu != null){
			System.out.println(actu.getValue().toString());
			parcoursRecursifAffiche(actu.getNextElem());
		}
		
	}

	/**
	 * Vide l'arbre de tout élément
	 */
	@Override
	public void viderArbre() {
		this.racine = null;
	}
	
	@Override
	public ListeChainee<T> remonterArbre(T elem){
		ListeChainee<T> res = new ListeChainee<T>();
		ElementArbre<T> elemArbre = recupererElem(elem);
		while(elemArbre != null){
			res.ajouterElem(elemArbre.getValue());
			elemArbre = elemArbre.getPrevElem();
		}		
		return res;
	}

}
