package modèle;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import structureDonnées.StructureMatrice;




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


	public static StructureMatrice LectureFichier (Path fichier)
	{
		String[] Splitter = new String[2];
		if(Files.exists(fichier)) 
		{     
			if(Files.isReadable(fichier)) 
			{
				try
				{
					List<String> Sfichier = Files.readAllLines(fichier);
					for(int i =0;i<Sfichier.size()-1;i++) 
					{
						if(i==0) name =Sfichier.get(0);
						else if (i==1) 
						{
							Splitter=Sfichier.get(i).split("\t");
							departX=Integer.parseInt(Splitter[0])-1;
							departY=Integer.parseInt(Splitter[1])-1;
							
						}
						else if (i==2) 
						{
							Splitter=Sfichier.get(i).split("\t");
							arriveeX=Integer.parseInt(Splitter[0])-1;
							arriveeY=Integer.parseInt(Splitter[1])-1;
						}
						else if (i==3) 
						{
							Splitter=Sfichier.get(i).split("\t");
							tailleX=Integer.parseInt(Splitter[0])-2;
							tailleY=Integer.parseInt(Splitter[1]);
							
							Matrice  = new char[tailleX][tailleY]; 
						}
						else if (i>4) 
						{
							for (int j=0;j<Sfichier.get(i).length();j++) 
							{
								Matrice[i-5][j] = Sfichier.get(i).charAt(j);
							}
						}
					}
					StructureMatrice Anderson = new StructureMatrice(Matrice,tailleX, tailleY);
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

