package structureDonn�es;
/**
 * 
 * @author Yanicet
 *
 * @param <E>
 */
public class File<E> implements IFile<E> {
	
	/*L'utilit� de l'�l�ment de tete est de ne pas avoir � 
	 * parcourir toute la file losque l'on ajoute un nouvelle �l�ment*/
	private Element<E> tete;
	private Element<E> queue;
	private int taille;
	
	
	/**
	 * Constructeur de la classe file
	 */
	public File() {
		super();
		this.taille = 0;
	}
	/**
	 * Methode d'ajout d'un �l�ment dans la file en d�but
	 * 
	 * @param elem la valeur g�n�rique de l'�l�ment � ajouter
	 */
	@Override
	public void enfiler(E elem) {
		Element<E> newElem = new Element<E>(elem);
		if(taille == 0){
			tete = newElem;
			queue = newElem;
		}
		else{
			newElem.setNextElem(tete);
			tete.setPrevElem(newElem);
			tete = newElem;
		}
		taille++;
	}

	/**
	 * Methode de retrait de l'�l�ment de queue de la file
	 * 
	 * @return la valeur de l'�l�ment g�nrique de queue
	 */
	@Override
	public E defiler() {
		E resVal = null;
		if(!estVide()){
			/*On r�cup�re de la valeur de l'�l�ment de queue � retourner*/
			resVal = queue.getValue();
			/*On change l'�l�ment de queue pour que se 
			 * soit le pr�c�dent de l'�l�ment de queue actuelle*/
			queue = queue.getPrevElem();
			/*Si la queue est alors null cela signifie que 
			 * la file est vide alors on met la tete � null*/
			if(queue != null) queue.setNextElem(null);
			else tete = null;
			taille--;
		}
		return resVal;
	}

	/**
	 * M�thode v�rifiant si la file est vide
	 * 
	 * @return vrai si file vide sinon faux
	 */
	@Override
	public boolean estVide() {
		return (tete == null && queue == null);
	}

	/**
	 * M�thode qui r�cup�re le nombre d'�l�ment dans la file
	 * 
	 * @return taille de la file
	 */
	@Override
	public int nbElem() {
		return taille;
	}

	/**
	 * @return the taille
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * @param taille the taille to set
	 */
	public void setTaille(int taille) {
		this.taille = taille;
	}
	
	public void afficher(){
		Element<E> elem = queue;
		System.out.print("[");
		while(elem != null){
			System.out.print(elem.getValue().toString());
			elem = elem.getPrevElem();
			if(elem != null) System.out.print("; ");
		}
		System.out.println("]");
	}

}
