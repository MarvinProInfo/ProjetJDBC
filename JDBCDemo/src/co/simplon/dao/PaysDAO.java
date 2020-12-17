package co.simplon.dao;

import java.util.List;

import co.simplon.model.Pays;

public interface PaysDAO {
	
	void ajouter ( Pays pays);
	List<Pays> lister();
	void modifier (Pays pays);
	void supprimer (Pays pays);

}
