package TP_5;

import java.sql.SQLException;
import java.util.List;

/*
	Interface Data Access Object
 */
public interface Dao<E> {
	
	// Création
	public boolean create(E e) throws SQLException;
	
	// Lecture
	public E read(long id) throws SQLException;
	
	// Mise à jour
	public boolean update(E e) throws SQLException;
	
	// Suppression
	public boolean delete(E e) throws SQLException;
	
	public boolean delete(long id) throws SQLException;
	
	public List<E> readAll() throws SQLException;
	
}
