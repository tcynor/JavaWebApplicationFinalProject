/**
 * 
 */
package edu.cvtc.web.search;

import java.util.List;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.movies.Movie;

/**
 * @author TravisCynor
 *
 */
public interface MovieSearch {
	
	List<Movie> findMoviesByTitle(String title) throws MovieSearchException;
	
	List<Movie> findMoviesByDirector(String director) throws MovieSearchException;
	
	List<Movie> retrieveMovies(String sortType) throws MovieSearchException;

}
