package TP_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class BD {
	
	private static final String URL = "jdbc:mysql://localhost:3307/db_berro";
	
	private static final String LOGIN = "berro";
	
	private static final String PWD = "berro";
	
	private static Connection cx;
	
	private static void connexion() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			throw new Exception("SAUNDERS BD - connexion() : chargement du pilote - " + ex.getMessage());
		}
		
		try {
			cx = DriverManager.getConnection(URL, LOGIN, PWD);
		} catch (SQLException ex) {
			throw new Exception("SAUNDERS BD - connexion() : connexion a la BD - " + ex.getMessage());
		}
	}
	
	// Singleton
	public static Connection getInstance() throws Exception {
		if (cx == null) {
			connexion();
		}
		return cx;
	}
	
	public static void main(String[] args) {
		try {
			BD.getInstance();
			System.out.println("Connexion Successful");
			
			Auteur auteur = new Auteur("SAUNDERS", "Gabriel");
			
			DaoAuteur daoAuteur = new DaoAuteur();
			daoAuteur.setCx(BD.getInstance());
			
			if (daoAuteur.create(auteur)) {
				System.out.println("Insertion Successful");
			}
			
			auteur = new Auteur(120, "SAUNDERS", "Gabriel");
			if (daoAuteur.update(auteur)) {
				System.out.println("Update Successful");
			}
			List<Auteur> auteurs = daoAuteur.readAll();
			for (Auteur a : auteurs) {
				System.out.println(a);
			}
			
			
			Auteur auteurRead = daoAuteur.read(120);
			System.out.println(auteurRead);
			
			if (daoAuteur.delete(120)) {
				System.out.println("Deletion Successful");
			}
			Auteur auteurToDelete = new Auteur(66, "", "");
			
			if (daoAuteur.delete(auteurToDelete)) {
				System.out.println("Deletion Successful");
			}
			
			
			DaoFilm daoFilm = new DaoFilm();
			daoFilm.setCx(BD.getInstance());
			Film film = new Film("Kick Ass", "Science-fiction", 66);
			
			if (daoFilm.create(film)) {
				System.out.println("Insertion Successful");
			}
			film = new Film(22, "Dune 2", "Science-fiction", 44);
			if (daoFilm.update(film)) {
				System.out.println("Update Successful");
			}
			film = new Film(22, "Dune", "Science-fiction", 43);
			if (daoFilm.update(film)) {
				System.out.println("Update Successful");
			}
			film = new Film(22, "Dark Forest", "Science-fiction", 13);
			if (daoFilm.update(film)) {
				System.out.println("Update Successful");
			}
			film = new Film(22, "Children of Dune", "Science-fiction", 47);
			if (daoFilm.update(film)) {
				System.out.println("Update Successful");
			}
			
			film = new Film(12, "", "", 0);
			if (daoFilm.delete(film)) {
				System.out.println("Deletion Successful");
			}
			if (daoFilm.delete(20)) {
				System.out.println("Deletion Successful");
			}
			
			System.out.println(daoFilm.read(66));
			
			List<Film> films = daoFilm.readAll();
			films.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
