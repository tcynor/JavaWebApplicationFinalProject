/**
 * 
 */
package edu.cvtc.web.comparators;

import java.util.Comparator;
import edu.cvtc.web.movies.Movie;

/**
 * @author TravisCynor
 * 
 * This class compares movie titles.
 *
 */
public class MovieTitleComparator implements Comparator<Movie> {
	
	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getTitle().compareTo(m2.getTitle());
	}
	
}
	

