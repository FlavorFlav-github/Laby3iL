/**
 * 
 */
package structureDonn�es;

import mod�le.IExplorable;
import mod�le.Position;

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
	 * adjacentes � celle du param�tre d'entr�
	 * 
	 * @param pos Positition dont on veut les adjacences
	 * @return res La liste des positions adjacentes 
	 */
	@Override
	public ListeChainee<Position> EtapesSuivantes(Position pos) {
		ListeChainee<Position> res = new ListeChainee<Position>();
		/*On v�rifie que la position en x+1 n'est pas en dehors de la matrice*/
		if(pos.getX()+1 < tailleX){
			/*On v�rifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX() + 1][pos.getY()]) == ' ')
				res.ajouterElem(new Position(pos.getX() + 1, pos.getY()));
		}
		/*On v�rifie que la position en y+1 n'est pas en dehors de la matrice*/
		if(pos.getY()+1 < tailleY){
			/*On v�rifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX()][pos.getY()+1]) == ' ')
				res.ajouterElem(new Position(pos.getX(), pos.getY() + 1));
		}
		/*On v�rifie que la position en x-1 n'est pas en dehors de la matrice*/
		if(pos.getX()-1 >= 0){
			/*On v�rifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX() - 1][pos.getY()]) == ' ')
				res.ajouterElem(new Position(pos.getX() - 1, pos.getY()));
		}
		/*On v�rifie que la position en y-1 n'est pas en dehors de la matrice*/
		if(pos.getY()-1 >= 0){
			/*On v�rifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX()][pos.getY() - 1]) == ' ')
				res.ajouterElem(new Position(pos.getX(), pos.getY() - 1));
		}
		return res;
	}

	/**
	 * Metode qui v�rifie qu'une position correspond � la position attendu
	 * 
	 * @param posAct la position actuelle que l'on cherche � v�rifier
	 * @param posArr la position d'arriver 
	 * 
	 * @return vrai si le x et le y de la position actuelle 
	 * est �gal au x et y de la position d'arriv� sinon faux
	 */
	@Override
	public boolean EstArriv�e(Position posAct, Position posArr) {
		return ((posAct.getX() == posArr.getX()) && (posAct.getY() == posArr.getY()));
	}
	
}
