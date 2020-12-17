package co.simplon.model;


public class Pays {
	
	private String nom;
	private int id;
	
	public Pays() {
		// TODO Auto-generated constructor stub
	}
	
	public Pays(int id,String nom ) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

	
	

}
