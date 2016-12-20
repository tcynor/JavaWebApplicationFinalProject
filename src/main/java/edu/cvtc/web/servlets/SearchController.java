package edu.cvtc.web.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.movies.Movie;
import edu.cvtc.web.search.MovieSearch;
import edu.cvtc.web.search.SearchBy;
import edu.cvtc.web.search.impl.MovieSearchImpl;

/**
 * Servlet implementation class SearchController
 * 
 *  SearchController servlet provides the ability to search for a movie by it's title, or director. 
 */
@WebServlet("/Search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String target = null;
		
		try {
			final String searchType = request.getParameter("searchType");
			final MovieSearch movieSearch = new MovieSearchImpl();
			List<Movie> movies = new ArrayList<>();
			
			switch(searchType) {
			case SearchBy.TITLE:
				final String title = request.getParameter("title");
				movies = movieSearch.findMoviesByTitle(title);
				break;
			case SearchBy.DIRECTOR:
				final String director = request.getParameter("director");
				movies = movieSearch.findMoviesByDirector(director);
				break;
			default:
				break;				
			}
			
			request.setAttribute("movies", movies);
			target = "searchResults.jsp";
		
		} catch (final MovieSearchException e) {
			e.printStackTrace();
			request.setAttribute("error", "Sorry, there was a problem accessing the database.");
			target = "error.jsp";
		}
		
		request.getRequestDispatcher(target).forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
