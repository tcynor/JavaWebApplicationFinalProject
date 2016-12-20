/**
 * 
 */
package edu.cvtc.web.search.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.DirectorComparator;
import edu.cvtc.web.comparators.DurationComparator;
import edu.cvtc.web.comparators.MovieTitleComparator;
import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.movies.Movie;
import edu.cvtc.web.predicates.DirectorPredicate;
import edu.cvtc.web.predicates.TitlePredicate;
import edu.cvtc.web.search.MovieSearch;

/**
 * @author TravisCynor
 *
 */
public class MovieSearchImpl implements MovieSearch {
	
	private static final String EXCEPTION_MESSAGE = "List of movies could not be retrieved from the database.";

	@Override
	public List<Movie> findMoviesByTitle(String title) throws MovieSearchException {
		
		try {			
			final MovieDao movieDao = new MovieDaoImpl();			
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new TitlePredicate(title)));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);			
		}	
	}

	@Override
	public List<Movie> findMoviesByDirector(String director) throws MovieSearchException {
		
		try {
			final MovieDao movieDao = new MovieDaoImpl();
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new DirectorPredicate(director)));
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);
		}
		
	}

	@Override
	public List<Movie> retrieveMovies(final String sortType) throws MovieSearchException {
		
		try {
			final MovieDao movieDao = new MovieDaoImpl();
			final List<Movie> movies = movieDao.retrieveMovies();
			
			if (null != sortType) {
				sortMovies(movies,sortType);
			}
			
			return movies;
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);
		}
	}
	
	private void sortMovies(final List<Movie> movies, final String sortType) {
		switch(sortType) {		
		case SortBy.TITLE:
			Collections.sort(movies, new MovieTitleComparator());
			break;
		case SortBy.DIRECTOR:
			Collections.sort(movies, new DirectorComparator());
			break;
		case SortBy.DURATION:
			Collections.sort(movies, new DurationComparator());
			break;
			default:
				break;
		}
	}	
}


