package structureDonnées;

/**
 * Class de la liste chainee
 * @author Yassine
 *
 * @param <T>
 */
public class ListeChainee<T extends Comparable<T>> implements IListeChainee<T>{

	private Element<T> tete;
	private Element<T> queue;
	private int taille;
	/**
	 * Créer une list chainee vide
	 */
	public ListeChainee(){
		this.taille = 0;
	}
	/**
	 * Ajoute un élément de type T au bout de la liste
	 * 
	 * @param obj1 Nouvelle element à ajouter dans la liste
	 */
	@Override
	public void ajouterElem(T obj1) {
		Element<T> newElem = new Element<T>(obj1);
		if(taille == 0){
			this.tete = newElem;
			this.queue = newElem;
		}
		else{
			this.queue.setNextElem(newElem);
			newElem.setPrevElem(this.queue);
			this.queue = newElem;
		}
		this.taille++;
	}

	/**
	 * Ajoute un élément de type T a l'indice d'entrer
	 * 
	 * @param obj1 Nouvelle element à ajouter dans la liste
	 * @param i indice auquel ajouter l'élément
	 * 
	 * @see Element
	 */
	@Override
	public void ajouterElem(T obj1, int i) {
		Element<T> newElem = new Element<T>(obj1);
		if(i > taille) throw new IndexOutOfBoundsException();
		else{
			if(taille == 0 || i == taille){
				ajouterElem(obj1);
			}
			else if(i == 0){
				newElem.setNextElem(this.tete);
				this.tete.setPrevElem(newElem);
				this.tete = newElem;
			}
			else{
				int j = 0;
				Element<T> currElem = this.tete;
				while(j != (i-1)){
					currElem = currElem.getNextElem();
					j++;
				}
				newElem.setNextElem(currElem.getNextElem());
				currElem.getNextElem().setPrevElem(newElem);
				currElem.setNextElem(newElem);
				newElem.setPrevElem(currElem);
			}
			this.taille++;
		}
	}

	/**
	 * Supprime un élément de la liste
	 * 
	 * @param obj1 Element à supprimer
	 * @return true si élément supprimer avec succès sinon false
	 */
	@Override
	public boolean supprimerElem(T obj1) {
		Element<T> currElemRecto = this.tete;
		Element<T> currElemVerso = this.queue;
		/*Parcours de la liste en double sens*/
		for(int i = 0; i < ((taille+1) / 2); i++){
			if(currElemRecto.getValue().equals(obj1)){
				deleteFromTete(currElemRecto);
				this.taille--;
				return true;
			}
			if(currElemVerso.getValue().equals(obj1)){
				deleteFromQueue(currElemVerso);
				this.taille--;
				return true;
			}
			currElemRecto = currElemRecto.getNextElem();
			currElemVerso = currElemVerso.getPrevElem();
		}
		return false;
	}

	/**
	 * Supprimer un élément par son indice
	 * 
	 * @param i indice de l'élément à supprimer
	 * @return true si élément supprimer avec succès sinon false
	 */
	@Override
	public boolean supprimerElem(int i) {
		boolean sens = false;
		Element<T> currElem = null;
		if(i >= taille) return false;

		if(taille == 1){
			this.taille = 0;
			this.tete = null;
			this.queue = null;
			return true;
		}
		else{

			if(i >= (taille / 2)){
				sens = true;
				currElem = this.queue;
			}
			else{
				sens = false;
				currElem = this.tete;
			}
			for(int j = 0 ;  j < (taille+1 / 2); j++){
				if(sens){
					if(i == (taille - 1 - j)){
						deleteFromQueue(currElem);
						this.taille--;
						return true;
					}
					currElem = currElem.getPrevElem();
				}
				else{
					if(i == j){
						deleteFromTete(currElem);
						this.taille--;
						return true;
					}
					currElem = currElem.getNextElem();
				}
			}
		}
		return false;
	}

	public void deleteFromTete(Element<T> obj1){
		if(obj1.getNextElem() != null){
			obj1.getNextElem().setPrevElem(obj1.getPrevElem());
			if(obj1 == this.tete) this.tete = obj1.getNextElem();
		}
		else{
			if(obj1 == this.tete) this.tete = null;
		}
		if(obj1.getPrevElem() != null)obj1.getPrevElem().setNextElem(obj1.getNextElem());
	}

	public void deleteFromQueue(Element<T> obj1){
		if(obj1.getNextElem() != null)obj1.getNextElem().setPrevElem(obj1.getPrevElem());
		if(obj1.getPrevElem() != null){
			obj1.getPrevElem().setNextElem(obj1.getNextElem());
			if(obj1 == this.queue) this.queue = obj1.getPrevElem();
		}
		else{
			if(obj1 == this.queue) this.queue = null;
		}
	}
	/**
	 * Récupère un élément de la liste par son indice
	 * 
	 * @param i indice de l'élément à récupérer
	 * @return la valeur de l'élément trouvé ou null si aucun élément à l'indice i
	 * @see Element
	 */
	@Override
	public T recupererValeur(int i) {
		boolean sens;
		Element<T> currElem;
		if(i >= taille) return null;
		if(i >= (taille / 2)){
			sens = true;
			currElem = this.queue;
		}
		else{
			sens = false;
			currElem = this.tete;
		}
		/*On ne parcours seulement la moitier de la liste, 
		 * si l'indice recherché est supérieur à la moitié du nombre 
		 * d'élément de la liste alors on parcours en  partant de la 
		 * fin sinon on parcours en partant du début*/
		for(int j = 0 ;  j < (taille+1 / 2); j++){
			/*Parcours par la queue*/
			if(sens){
				if(i == (taille - 1 - j))return currElem.getValue();
				currElem = currElem.getPrevElem();
			}
			/*Parcours par la tete*/
			else{
				if(i == j) return currElem.getValue();
				currElem = currElem.getNextElem();
			}

		}
		return null;
	}

	/**
	 * Récdupère un élément de la liste par son indice
	 * 
	 * @param i indice de l'élément à récupérer
	 * @return l'élément trouvé ou null si aucun élément à l'indice i
	 * @see Element
	 */
	public Element<T> getElem(int i) {
		boolean sens;
		Element<T> currElem;
		if(i >= taille) return null;
		if(i >= (taille / 2)){
			sens = true;
			currElem = this.queue;
		}
		else{
			sens = false;
			currElem = this.tete;
		}
		/*On ne parcours seulement la moitier de la liste, 
		 * si l'indice recherché est supérieur à la moitié du nombre 
		 * d'élément de la liste alors on parcours en  partant de la 
		 * fin sinon on parcours en partant du début*/
		for(int j = 0 ;  j < (taille+1 / 2); j++){
			/*Parcours par la queue*/
			if(sens){
				if(i == (taille - 1 - j))return currElem;
				currElem = currElem.getPrevElem();
			}
			/*Parcours par la tete*/
			else{
				if(i == j) return currElem;
				currElem = currElem.getNextElem();
			}

		}
		return null;
	}

	/**
	 * Recupère la taille de la liste
	 * 
	 * @return nombre d'élément de la liste
	 */
	@Override
	public int recupererTaille() {
		return this.taille;
	}

	/**
	 * Affiche les valeurs des éléments de la liste
	 */
	@Override
	public void affiche() {
		if(this.taille > 0)
		{	
		Element<T> currElem = this.tete;
		System.out.print("[");
		while(currElem != null){
			System.out.print(currElem.getValue());
			if(currElem.getNextElem() != null) System.out.print(", ");
			currElem = currElem.getNextElem();
		}
		System.out.println("]");
		}
		else System.out.println("Pas de chemin possible");
	}
	@Override
	public boolean estDansListe(T obj1) {
		Element<T> currElemTete = this.tete;
		Element<T> currElemQueue = this.queue;
		for(int i = 0 ;  i < (taille+1) / 2; i++){
			if(currElemTete.getValue().equals(obj1)) return true;
			else currElemTete = currElemTete.getNextElem();

			if(currElemQueue.getValue().equals(obj1)) return true;
			else currElemQueue = currElemQueue.getPrevElem();
		}
		return false;
	}

	/**
	 * Methode permettant d'inverser la liste
	 */
	@Override
	public void inverserList() {
		Element<T> currElem = this.tete;
		Element<T> currElemPrev;
		for(int i = 0; i < taille; i++){
			currElemPrev = currElem.getPrevElem();
			currElem.setPrevElem(currElem.getNextElem());
			currElem.setNextElem(currElemPrev);
			currElem = currElem.getPrevElem();
		}
		currElem = this.tete;
		this.tete = this.queue;
		this.queue = currElem;
	}

	/**
	 * Ajouter un élément dans une liste triée
	 */
	@Override
	public void ajuterElemTrier(T obj1) {
		Element<T> newElem = new Element<T>(obj1);
		if(taille == 0){
			this.tete = newElem;
			this.queue = newElem;
		}
		else{
			Element<T> elemTemp = this.tete;
			while(obj1.compareTo(elemTemp.getValue()) > 0){
				if(elemTemp.getNextElem() == null) break;
				elemTemp = elemTemp.getNextElem();
			}
			if(elemTemp.equals(this.tete)){
				if(obj1.compareTo(elemTemp.getValue()) < 0){
					this.tete = newElem;
					newElem.setNextElem(elemTemp);
					elemTemp.setPrevElem(newElem);
				}
				else{
					newElem.setPrevElem(elemTemp);
					if(this.queue.equals(elemTemp)) this.queue = newElem;
					if(elemTemp.getNextElem() != null){
						newElem.setNextElem(elemTemp.getNextElem());
						elemTemp.getNextElem().setPrevElem(newElem);
					}
					elemTemp.setNextElem(newElem);
				}
			}
			else{
				if(elemTemp.equals(this.queue)){
					if(obj1.compareTo(elemTemp.getValue()) > 0){
						this.queue = newElem;
						newElem.setPrevElem(elemTemp);
						elemTemp.setNextElem(newElem);
					}
					else{
						newElem.setNextElem(elemTemp);
						newElem.setPrevElem(elemTemp.getPrevElem());
						elemTemp.getPrevElem().setNextElem(newElem);
						elemTemp.setPrevElem(newElem);
					}
				}
				else{
					newElem.setNextElem(elemTemp);
					newElem.setPrevElem(elemTemp.getPrevElem());
					elemTemp.getPrevElem().setNextElem(newElem);
					elemTemp.setPrevElem(newElem);
				}
			}

		}
		this.taille++;
	}

	/**
	 * Vérifie si la liste est vide, donc si la la tete point vers null
	 */
	@Override
	public boolean estVide(){
		return this.tete == null;
	}
}
