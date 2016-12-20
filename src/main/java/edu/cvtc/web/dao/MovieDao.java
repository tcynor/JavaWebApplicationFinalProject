/**
 * 
 */
package edu.cvtc.web.dao;

import java.sql.SQLException; 
import java.util.List;

import edu.cvtc.web.movies.Movie;

/**
 * @author TravisCynor
 *
 */
public interface MovieDao {
	
	void createDatabase() throws ClassNotFoundException, SQLException;
	
	List<Movie> retrieveMovies() throws Exception;

	void insertMovie(Movie movie) throws Exception;

}
