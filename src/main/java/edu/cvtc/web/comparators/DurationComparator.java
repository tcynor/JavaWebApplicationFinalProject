package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.movies.Movie;

/**
 * @author TravisCynor
 *
 * The DurationComparator class is source code for comparing movie durations numerically.
 */
public class DurationComparator implements Comparator<Movie> {

	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getDuration().compareTo(m2.getDuration());
	}
}
