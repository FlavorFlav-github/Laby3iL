package mod�le;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import structureDonn�es.StructureMatrice;


/**
 * @author Anicet.G
 *
 */

public class Initialisation 
{	
	protected static String name;
	protected static char[][] Matrice;
	protected static int departX =	-1;		
	protected static int departY = 	-1;	
	protected static int arriveeX =	-1;
	protected static int arriveeY =	-1;
	protected static int tailleX = 	-1;
	protected static int tailleY =	-1;


	public static StructureMatrice LectureFichier (Path fichier)		//Fonction permettant de cr�er la matrice � partir du fichier texte
	{
		String[] Splitter = new String[2];
		if(Files.exists(fichier)) 	
		{     
			if(Files.isReadable(fichier)) 								
			{
				try
				{
					List<String> Sfichier = Files.readAllLines(fichier);		//On r�cup�re toutes les lignes
					for(int i =0;i<Sfichier.size()-1;i++) 						//on parcours le fichier sauf la derni�re ligne
					{
						if(i==0) name =Sfichier.get(0);							//r�cup�ration du nom du labyrinthe
						else if (i==1)											//r�cup�ration du point de d�part
						{
							Splitter=Sfichier.get(i).split("\t");
							departX=Integer.parseInt(Splitter[0])-1;
							departY=Integer.parseInt(Splitter[1])-1;
							
						}
						else if (i==2) 											//r�cup�ration du point d'arriv�e
						{
							Splitter=Sfichier.get(i).split("\t");
							arriveeX=Integer.parseInt(Splitter[0])-1;
							arriveeY=Integer.parseInt(Splitter[1])-1;
						}
						else if (i==3) 											//r�cup�ration des dimensions
						{
							Splitter=Sfichier.get(i).split("\t");
							tailleX=Integer.parseInt(Splitter[0])-2;
							tailleY=Integer.parseInt(Splitter[1]);
							
							Matrice  = new char[tailleX][tailleY]; 
						}
						else if (i>4) 											//on recopie chaque caract�re dans un tableau de caract�re repr�sentant la matrice
						{
							for (int j=0;j<Sfichier.get(i).length();j++) 
							{
								Matrice[i-5][j] = Sfichier.get(i).charAt(j);
							}
						}
					}
					StructureMatrice Anderson = new StructureMatrice(Matrice,tailleX, tailleY);		//cr�ation de la matrice � partir de ses dimensions et du tableau
					Anderson.setArriverX(arriveeX);
					Anderson.setArriverY(arriveeY);
					Anderson.setDepartX(departX);
					Anderson.setDepartY(departY);
					return Anderson;
				}
				catch(IOException e) 
				{
					e.printStackTrace();
				}
			}
			else System.out.println("Impossible de lire le fichier");
		}
		else System.out.println("Impossible d'ouvrir le fichier");
		return null;
	}


}

