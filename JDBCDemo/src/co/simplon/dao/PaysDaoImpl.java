package co.simplon.dao;

import co.simplon.model.Pays;


import java.sql.*;
import java.util.*;

public class PaysDaoImpl implements PaysDAO {
	
	private DAOContext daoContext;
	
	public PaysDaoImpl(DAOContext daoContext) {
		// TODO Auto-generated constructor stub
		this.daoContext = daoContext;
	}  
	
	@Override
	public void ajouter(Pays pays) {
		// TODO Auto-generated method stub
		System.out.println(pays.getNom());
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		System.out.println(pays.getNom());
		try {
			connexion = DAOContext.getConnection();
			preparedStatement = connexion.prepareStatement("INSERT INTO pays(nom) VALUES(?);");
			preparedStatement. setString(1, pays.getNom());
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Pays> lister() {
		// TODO Auto-generated method stub
		List<Pays> Lpays = new ArrayList<Pays>();
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = DAOContext.getConnection();
			
			//Réquète 
			preparedStatement = connexion.prepareStatement("SELECT id,nom FROM testjdbc.pays ;");
			ResultSet rs = preparedStatement.executeQuery();
			
			//Récupération de données
			while(rs.next()){
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				
				
				Pays nvPays = new Pays();
				nvPays.setId(id);
				nvPays.setNom(nom);
				Lpays.add(nvPays);
				
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return Lpays;
	}

	@Override
	public void modifier(Pays pays) {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connexion = DAOContext.getConnection();
			preparedStatement = connexion.prepareStatement("UPDATE pays SET nom = ? WHERE id = ?");
			preparedStatement.setString(1, pays.getNom());
			preparedStatement.setInt(2, pays.getId());
			preparedStatement.executeUpdate();
			System.out.println("Succes");
		}catch(SQLException e) {
			System.out.println("Erreur update");
			e.printStackTrace();
		}
		
	}

	@Override
	public void supprimer(Pays pays) {
		// TODO Auto-generated method stub
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		try {
			connexion = DAOContext.getConnection();
			preparedStatement = connexion.prepareStatement("DELETE from pays where id = ?");
			preparedStatement.setInt(1, pays.getId());
			preparedStatement.executeUpdate();
			System.out.println("Succes");
		}catch(SQLException e) {
			System.out.println("Erreur suppression");
			e.printStackTrace();
		}
		
	}



}
