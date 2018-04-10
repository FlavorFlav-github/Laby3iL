/**
 * 
 */
package interaces;

import structureDonn�es.ElementArbre;
import structureDonn�es.ListeChainee;

/**
 * @author Yanicet
 *
 */
public interface IArbreNAire<T extends Comparable<T>> {
	void ajouterElement(T elemPere, T nouveauElem);
	ElementArbre<T> recupererElem(T elem);
	void affiche();
	void viderArbre();
	ListeChainee<T> remonterArbre(T elem);
}