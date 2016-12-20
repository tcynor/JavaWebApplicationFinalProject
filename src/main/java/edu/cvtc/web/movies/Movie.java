package edu.cvtc.web.movies;

/**
 * @author Travis Cynor
 *
 * This class provides information about a movie's title, director and duration.
 * Also, holds the fields getters, and toString method for output. 
 */
public class Movie {
	
	private String title;
	private String director;
	private Integer duration;
	
	public Movie(final String title, final String director, final Integer duration) {
		super();
		this.title = title;
		this.director = director;
		this.duration = duration;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}
	
	@Override
	public String toString() {
		return "Movies [title=" + title + ", director=" + director 
						+ ", duration=" + duration + "]";
	}
	
}
