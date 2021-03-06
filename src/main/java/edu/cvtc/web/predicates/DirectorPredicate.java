/**
 * 
 */
package edu.cvtc.web.predicates;

import com.google.common.base.Predicate;

import edu.cvtc.web.movies.Movie;

/**
 * @author TravisCynor
 *
 */
public class DirectorPredicate implements Predicate<Movie> {
	
	private String director;
	
	public DirectorPredicate(final String director) {
		this.director = director;
	}

	@Override
	public boolean apply(final Movie movie) {
		return movie.getDirector().equals(director);
	}
}
