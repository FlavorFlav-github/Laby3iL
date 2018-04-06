/**
 * 
 */
package structureDonnées;

import modèle.IExplorable;
import modèle.Position;

/**
 * @author Yanicet
 *
 */
public class StructureMatrice implements IExplorable{
	private char[][] matrice;
	private int tailleX, tailleY;
	/**
	 * @param matrice
	 * @param tailleX
	 * @param tailleY
	 */
	
	
	public StructureMatrice(int tailleX, int tailleY) {
		super();
		this.matrice = new char[tailleX][tailleY];
		this.tailleX = tailleX;
		this.tailleY = tailleY;
	}
	public StructureMatrice(char[][] matrice,int tailleX, int tailleY) {
		super();
		this.matrice = matrice;
		this.tailleX = tailleX;
		this.tailleY = tailleY;
	}
	public void ajouterElem(char val, int x, int y){
		this.matrice[x][y] = val;
	}
	public void affiche () 
	{
		for (int i=0;i<tailleX;i++) 
		{
			for (int j =0;j<tailleY;j++) 
			{
				System.out.print(matrice[i][j]);
			}
			System.out.println("");
		}
	}
	/**
	 * @return the matrice
	 */
	public char[][] getMatrice() {
		return matrice;
	}
	/**
	 * @param matrice the matrice to set
	 */
	public void setMatrice(char[][] matrice) {
		this.matrice = matrice;
	}
	/**
	 * @return the tailleX
	 */
	public int getTailleX() {
		return tailleX;
	}
	/**
	 * @param tailleX the tailleX to set
	 */
	public void setTailleX(int tailleX) {
		this.tailleX = tailleX;
	}
	/**
	 * @return the tailleY
	 */
	public int getTailleY() {
		return tailleY;
	}
	/**
	 * @param tailleY the tailleY to set
	 */
	public void setTailleY(int tailleY) {
		this.tailleY = tailleY;
	}

	/**
	 * Methode qui retourne les positions des cases 
	 * adjacentes à celle du paramètre d'entré
	 * 
	 * @param pos Positition dont on veut les adjacences
	 * @return res La liste des positions adjacentes 
	 */
	@Override
	public ListeChainee<Position> EtapesSuivantes(Position pos) {
		ListeChainee<Position> res = new ListeChainee<Position>();
		/*On vérifie que la position en x+1 n'est pas en dehors de la matrice*/
		if(pos.getX()+1 < tailleX){
			/*On vérifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX() + 1][pos.getY()]) == ' ')
				res.ajouterElem(new Position(pos.getX() + 1, pos.getY()));
		}
		/*On vérifie que la position en y+1 n'est pas en dehors de la matrice*/
		if(pos.getY()+1 < tailleY){
			/*On vérifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX()][pos.getY()+1]) == ' ')
				res.ajouterElem(new Position(pos.getX(), pos.getY() + 1));
		}
		/*On vérifie que la position en x-1 n'est pas en dehors de la matrice*/
		if(pos.getX()-1 >= 0){
			/*On vérifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX() - 1][pos.getY()]) == ' ')
				res.ajouterElem(new Position(pos.getX() - 1, pos.getY()));
		}
		/*On vérifie que la position en y-1 n'est pas en dehors de la matrice*/
		if(pos.getY()-1 >= 0){
			/*On vérifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX()][pos.getY() - 1]) == ' ')
				res.ajouterElem(new Position(pos.getX(), pos.getY() - 1));
		}
		return res;
	}

	/**
	 * Metode qui vérifie qu'une position correspond à la position attendu
	 * 
	 * @param posAct la position actuelle que l'on cherche à vérifier
	 * @param posArr la position d'arriver 
	 * 
	 * @return vrai si le x et le y de la position actuelle 
	 * est égal au x et y de la position d'arrivé sinon faux
	 */
	@Override
	public boolean EstArrivée(Position posAct, Position posArr) {
		return ((posAct.getX() == posArr.getX()) && (posAct.getY() == posArr.getY()));
	}
	
}
