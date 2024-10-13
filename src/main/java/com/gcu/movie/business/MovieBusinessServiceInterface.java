package com.gcu.movie.business;

import java.util.List;

import com.gcu.movie.models.MovieModel;


public interface MovieBusinessServiceInterface {

	public List<MovieModel> getMovies();

	public boolean create(MovieModel movie);

	MovieModel findById(int id);

	public boolean update(int id, MovieModel movie);

	public void delete(int id);
}
