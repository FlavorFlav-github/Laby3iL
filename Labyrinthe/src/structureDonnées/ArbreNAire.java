/**
 * 
 */
package structureDonn�es;

/**
 * @author Yanicet
 *
 */
public class ArbreNAire<T> implements IArbreNAire<T>{
	private ElementArbre<T> racine;
	private int nombreElement;
	
	/**
	 * Constructeur de la classe ArbreNAire qui 
	 * initialise le nombre d'�l�ment de l'arbre � 0
	 */
	public ArbreNAire() {
		super();
		this.nombreElement = 0;
	}

	/**
	 * Ajoute un �lement dans l'arbre sachant son p�re
	 * 
	 * @param elemPere la valeur de l'�l�ment pere apr�s lequel on doit ajouter le nouvelle �l�ment
	 * @param noueauElem la valeur du nouvelle �l�ment � ajouter
	 */
	@Override
	public void ajouterElement(T elemPere, T nouveauElem) {
		ElementArbre<T> newElem = new ElementArbre<T>(nouveauElem);
		/*Si l'arbre est vide ajoute l'�l�ment � la racine*/
		if(racine == null){
			racine = newElem;
			this.nombreElement++;
		}
		else{
			/*L'ajout ne peut se faire que si l'�lement pere est renseign� et si il existe*/
			if(elemPere != null){
				ElementArbre<T> pere = recupererElem(elemPere);
				if(pere != null){
					/*Si l'�l�ment p�re n'a pas encore sa liste de fils cr�er, on la cr�er*/
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
	 * R�cup�re un �l�ment dans l'arbre
	 * 
	 * @return l'�l�ment de larbre recherch�
	 */
	@Override
	public ElementArbre<T> recupererElem(T elem) {
		ElementArbre<T> actu = this.racine;
		if(actu.getValue().equals(elem)) return actu;
		return parcoursRecursifRecherche(actu.getNextElem(),elem );
	}
	
	/**
	 * Recherche d'un �l�ment dans l'arbre en parcours r�cusrsif
	 * @param listElem la liste des �l�ments � parcourir
	 * @param valeurCherche la valeur que l'on recherche
	 * @return l'�l�ment de l'arbre recherch�
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
	 * Affichage des �lements de l'arbre en parcours r�cursif
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
	 * Vide l'arbre de tout �l�ment
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
