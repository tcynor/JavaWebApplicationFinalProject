package edu.cvtc.web.predicates;

import com.google.common.base.Predicate; 

import edu.cvtc.web.movies.Movie;

/**
 * @author TravisCynor
 *
 */
public class TitlePredicate implements Predicate<Movie> {
	
	private String title;
	
	public TitlePredicate(final String title) {
		this.title = title;
	}

	@Override
	public boolean apply(Movie movies) {
		return movies.getTitle().equalsIgnoreCase(title);
		
	}

}
