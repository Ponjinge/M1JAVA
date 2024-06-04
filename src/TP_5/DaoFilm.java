package TP_5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoFilm implements Dao<Film> {
	
	private Connection cx;
	
	public void setCx(Connection cx) {
		this.cx = cx;
	}
	
	@Override
	public boolean create(Film film) throws SQLException {
		String sqlRequest = "INSERT INTO Film (Titre, Genre, NumAuteur) VALUES (?, ?, ?)";
		int nb = 0;
		try (PreparedStatement statement = cx.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, film.getTitre());
			statement.setString(2, film.getGenre());
			statement.setLong(3, film.getIdAuteur());
			
			nb = statement.executeUpdate();
			
			ResultSet resultSet = statement.getGeneratedKeys();
			resultSet.next();
			film.setCode(resultSet.getLong(1));
		}
		return nb == 1;
	}
	@Override
	public Film read(long id) throws SQLException {
		String sql = "SELECT * FROM Film WHERE Code = ?";
		Film film = null;
		try (PreparedStatement st = cx.prepareStatement(sql)) {
			st.setLong(1, id);
			
			ResultSet resultSet = st.executeQuery();
			
			while (resultSet.next()) {
				film = new Film(resultSet.getLong("Code"), resultSet.getString("Titre"), resultSet.getString("Genre"), resultSet.getLong("NumAuteur"));
			}
		}
		return film;
	}
	@Override
	public boolean update(Film film) throws SQLException {
		String sql = "UPDATE Film SET Titre = ?, Genre = ?, NumAuteur = ? WHERE Code = ?";
		int nb = 0;
		try (PreparedStatement st = cx.prepareStatement(sql)) {
			st.setString(1, film.getTitre());
			st.setString(2, film.getGenre());
			st.setLong(3, film.getIdAuteur());
			st.setLong(4, film.getCode());
			
			nb = st.executeUpdate();
		}
		
		return nb == 1;
	}
	
	@Override
	public boolean delete(Film film) throws SQLException {
		String sql = "DELETE FROM Film WHERE Code = ?";
		int nb = 0;
		try (PreparedStatement st = cx.prepareStatement(sql)) {
			st.setLong(1, film.getCode());
			nb = st.executeUpdate();
		}
		return nb == 1;
	}
	
	@Override
	public boolean delete(long id) throws SQLException {
		String sql = "DELETE FROM Film WHERE Code = ?";
		int nb = 0;
		try (PreparedStatement st = cx.prepareStatement(sql)) {
			st.setLong(1, id);
			nb = st.executeUpdate();
		}
		
		return nb == 1;
	}
	
	@Override
	public List<Film> readAll() throws SQLException {
		List<Film> liste = new ArrayList<>();
		
		String sql = "SELECT * FROM Film";
		try (PreparedStatement statement = cx.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Film film = new Film(resultSet.getLong("Code"), resultSet.getString("Titre"), resultSet.getString("Genre"), resultSet.getLong("NumAuteur"));
				liste.add(film);
			}
		}
		return liste;
	}
}
