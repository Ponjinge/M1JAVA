package TP_5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAuteur implements Dao<Auteur> {
	private Connection cx;
	
	public void setCx(Connection cx) {
		this.cx = cx;
	}
	
	@Override
	public boolean create(Auteur auteur) throws SQLException {
		String sqlRequest = "INSERT INTO Auteur(Nom, Prenom) VALUES(?, ?)";
		int nb = 0;
		try (PreparedStatement st = cx.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, auteur.getNom());
			st.setString(2, auteur.getPrenom());
			
			nb = st.executeUpdate();
			
			ResultSet resultSet = st.getGeneratedKeys();
			resultSet.next();
			auteur.setId(resultSet.getLong(1));
			
		}
		return nb == 1;
	}
	
	@Override
	public Auteur read(long id) throws SQLException {
		String sqlQuery = "SELECT * FROM Auteur WHERE Numero = ?";
		Auteur auteur = null;
		try (PreparedStatement statement = cx.prepareStatement(sqlQuery)) {
			statement.setLong(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				auteur = new Auteur(resultSet.getLong("Numero"), resultSet.getString("Nom"), resultSet.getString("Prenom"));
			}
		}
		return auteur;
	}
	
	@Override
	public boolean update(Auteur auteur) throws SQLException {
		String sql = "UPDATE Auteur SET Nom = ?, Prenom = ? WHERE Numero = ?";
		int nb = 0;
		try (PreparedStatement st = cx.prepareStatement(sql)) {
			st.setString(1, auteur.getNom());
			st.setString(2, auteur.getPrenom());
			st.setLong(3, auteur.getId());
			
			nb = st.executeUpdate();
			
		}
		return nb == 1;
	}
	
	@Override
	public boolean delete(Auteur auteur) throws SQLException {
		String sql = "DELETE FROM Auteur WHERE Numero = ?";
		int nb = 0;
		try (PreparedStatement st = cx.prepareStatement(sql)) {
			st.setLong(1, auteur.getId());
			nb = st.executeUpdate();
		}
		return nb == 1;
	}
	
	@Override
	public boolean delete(long id) throws SQLException {
		String sql = "DELETE FROM Auteur WHERE Numero = ?";
		int nb = 0;
		try (PreparedStatement st = cx.prepareStatement(sql)) {
			st.setLong(1, id);
			nb = st.executeUpdate();
		}
		return nb == 1;
	}
	
	@Override
	public List<Auteur> readAll() throws SQLException {
		List<Auteur> liste = new ArrayList<>();

		String sql = "SELECT * FROM Auteur";

		try (PreparedStatement st = cx.prepareStatement(sql)) {
			ResultSet resultSet = st.executeQuery();
			
			while (resultSet.next()) {
				Auteur auteur = new Auteur(resultSet.getLong("Numero"), resultSet.getString("Nom"), resultSet.getString("Prenom"));
				liste.add(auteur);
			}
		}
		return liste;
	}
}
