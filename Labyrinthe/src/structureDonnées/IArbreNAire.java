/**
 * 
 */
package structureDonnées;

/**
 * @author Yanicet
 *
 */
public interface IArbreNAire<T> {
	void ajouterElement(T elemPere, T nouveauElem);
	ElementArbre<T> recupererElem(T elem);
	void affiche();
	void viderArbre();
	ListeChainee<T> remonterArbre(T elem);
}
