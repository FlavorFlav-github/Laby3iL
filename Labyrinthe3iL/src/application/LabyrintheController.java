package application;

import java.nio.file.Paths;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import mod�le.Etape;
import mod�le.Initialisation;
import mod�le.Labyrinthe;
import structureDonn�es.ListeChainee;
import structureDonn�es.StructureMatrice;

public class LabyrintheController {
	@FXML
	ChoiceBox<String> choixMap;
	@FXML
	ChoiceBox<String> choixAlgo;
	@FXML
	TextArea zoneAffichage;
	
	StructureMatrice str;
	
	@FXML
	public void initialize() {
		str = Initialisation.LectureFichier(Paths.get(System.getProperty("user.dir") + System.getProperty("file.separator") + "files" + System.getProperty("file.separator"), "map.txt"));
		Labyrinthe<StructureMatrice> lab = new Labyrinthe<StructureMatrice>();
		ListeChainee<Etape> lis = lab.rechercheItin�raireAEtoile(str, str.getDepartX(),str.getDepartY(), str.getArriverX(),str.getArriverY());
		str.remplirChemin(lis);
		zoneAffichage.setText(str.toString());
		str.affiche();
	}
	   
	public void actionChoixMap(ActionEvent e){
		System.out.println(choixMap.getValue());
		str = Initialisation.LectureFichier(Paths.get(System.getProperty("user.dir"), "map4.txt"));
		str.affiche();
	}
	
	public void actionChoixAlgo(ActionEvent e){
		
	}

	public void actionAfficheLaby(ActionEvent e){
		
	}
}
