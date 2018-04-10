/**
 * 
 */
package structureDonnées;

import modèle.IExplorable;
import modèle.IMesurable;
import modèle.Etape;

/**
 * @author Yanicet
 *
 */
public class StructureMatrice implements IExplorable<Etape>, IMesurable<Etape> {
	private char[][] matrice;
	private int tailleX, tailleY;
	private int arriverX ;
	private int arriverY ;
	private int departX ;
	private int departY ;
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
		
		for (int i=0;i<tailleX+2;i++) 
		{
			for (int j =0;j<tailleY;j++) 
			{
				//if (i==0)System.out.println("ø");
				//else if (i == tailleX-1)System.out.println("ø");
				//else
				System.out.print(matrice[i][j] + "  ");
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
	public ListeChainee<Etape> EtapesSuivantes(Etape pos) {
		ListeChainee<Etape> res = new ListeChainee<Etape>();
		/*On vérifie que la position en x+1 n'est pas en dehors de la matrice*/
		if(pos.getX()+1 < tailleX){
			/*On vérifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX() + 1][pos.getY()]) == ' ')
				res.ajouterElem(new Etape(pos.getX() + 1, pos.getY()));
		}
		/*On vérifie que la position en y+1 n'est pas en dehors de la matrice*/
		if(pos.getY()+1 < tailleY){
			/*On vérifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX()][pos.getY()+1]) == ' ')
				res.ajouterElem(new Etape(pos.getX(), pos.getY() + 1));
		}
		/*On vérifie que la position en x-1 n'est pas en dehors de la matrice*/
		if(pos.getX()-1 >= 0){
			/*On vérifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX() - 1][pos.getY()]) == ' ')
				res.ajouterElem(new Etape(pos.getX() - 1, pos.getY()));
		}
		/*On vérifie que la position en y-1 n'est pas en dehors de la matrice*/
		if(pos.getY()-1 >= 0){
			/*On vérifie que la position est bien une case vide/explorable*/
			if((matrice[pos.getX()][pos.getY() - 1]) == ' ')
				res.ajouterElem(new Etape(pos.getX(), pos.getY() - 1));
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
	public boolean EstArrivée(Etape posAct, Etape posArr) {
		return calculDistanceEuclidienne(posAct.getX(), posAct.getY(), posArr.getX(), posArr.getY()) == 0;
	}
	
	/**
	 * Methode qui retourne la distance entre deux etapes adjacentes
	 */
	@Override
	public double distance(Etape etapeD, Etape etapeA) {
		return 1;
	}
	
	public double calculDistanceEuclidienne(int x1, int y1, int x2, int y2){
		return Math.sqrt(((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)));
	}
	
	public void remplirChemin(ListeChainee<Etape> chemin){
		for(int i = 0 ; i < chemin.recupererTaille(); i++){
			ajouterElem('.', chemin.recupererValeur(i).getX(), chemin.recupererValeur(i).getY());
		}
	}
	
	/**
	 * @return the arriverX
	 */
	public int getArriverX() {
		return arriverX;
	}
	/**
	 * @param arriverX the arriverX to set
	 */
	public void setArriverX(int arriverX) {
		this.arriverX = arriverX;
	}
	/**
	 * @return the arriverY
	 */
	public int getArriverY() {
		return arriverY;
	}
	/**
	 * @param arriverY the arriverY to set
	 */
	public void setArriverY(int arriverY) {
		this.arriverY = arriverY;
	}
	/**
	 * @return the departX
	 */
	public int getDepartX() {
		return departX;
	}
	/**
	 * @param departX the departX to set
	 */
	public void setDepartX(int departX) {
		this.departX = departX;
	}
	/**
	 * @return the departY
	 */
	public int getDepartY() {
		return departY;
	}
	/**
	 * @param departY the departY to set
	 */
	public void setDepartY(int departY) {
		this.departY = departY;
	}
	
}
