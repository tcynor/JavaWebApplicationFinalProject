package edu.cvtc.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.movies.Movie;
import edu.cvtc.web.util.DBUtility;

/**
 * @author TravisCynor
 *
 * This class creates the movie database, inserts the movie values and retrieves data when called upon. 
 */
public class MovieDaoImpl implements MovieDao {
	
	private static final String DROP_TABLE_MOVIE = "drop table if exists movie";
	private static final String CREATE_TABLE_MOVIE = "create table movie(id integer primary key autoincrement, title text, director text, duration text)";
	private static final String SELECT_ALL_FROM_MOVIE = "select * from movie";
	

	@Override
	public void createDatabase() throws ClassNotFoundException, SQLException {
		
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try {
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			statement.executeUpdate(DROP_TABLE_MOVIE);
			statement.executeUpdate(CREATE_TABLE_MOVIE);
			
		} finally {
			DBUtility.closeConnections(connection, statement);
		}			
	} 
	
	@Override
	public void insertMovie(final Movie movie) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = DBUtility.createConnection();
			
			final String insertValues = "insert into movie (title, director, duration) values (?, ?, ?)";
			preparedStatement = connection.prepareStatement(insertValues);
			
			preparedStatement.setString(1, movie.getTitle());
			preparedStatement.setString(2, movie.getDirector());
			preparedStatement.setInt(3, movie.getDuration());
			
			preparedStatement.setQueryTimeout(DBUtility.TIMEOUT);
			preparedStatement.executeUpdate();
			
		} finally {
			DBUtility.closeConnections(connection, preparedStatement);
			
		}
		
	}

	@Override
	public List<Movie> retrieveMovies() throws Exception {
		final List<Movie> movie = new ArrayList<>();
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
				
		try {
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_MOVIE);
			
			while (resultSet.next()) {
				final String title = resultSet.getString("title");
				final String director = resultSet.getString("director");
				final int duration = resultSet.getInt("duration");
				
				final Movie movies = new Movie(title, director, duration);
				movie.add(movies);
			}
			
			resultSet.close();
			
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return movie;
	}

}
