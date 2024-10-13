package com.gcu.movie.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import com.gcu.movie.data.MovieDataService;
import com.gcu.movie.data.entity.MovieEntity;
import com.gcu.movie.models.MovieModel;

public class MovieBusinessService implements MovieBusinessServiceInterface{

	@Autowired
	public MovieDataService service;
	//Override method from interface
	//Used to call the data repository and collect a list of <ModieModel>
	@Override
	public List<MovieModel> getMovies() {
		// TODO Auto-generated method stub
		//Find all returns a list of entities
		List<MovieEntity> moviesEntity = service.findAll();
		//Convert those entities to model
		List<MovieModel> moviesDomain = new ArrayList<MovieModel>();
		for(MovieEntity entity : moviesEntity) {
			moviesDomain.add(new MovieModel(entity.getId(), entity.getTitle(), entity.getGenre(), entity.getImage(), entity.getRating()));
		}
		return moviesDomain;
	}
	
	public boolean create(MovieModel movie) {
		//convert from movieModel to MovieEntity
		MovieEntity movieEntity = new MovieEntity();
        movieEntity.setTitle(movie.getTitle());
        movieEntity.setGenre(movie.getGenre());
        movieEntity.setImage(movie.getImage());
        movieEntity.setRating(movie.getRating());
        //Call the service.create method to handle the creation
		boolean success = service.create(movieEntity);
		return success;
	}
	
	
	@Override
	public MovieModel findById(int id) {
		// TODO Auto-generated method stub
		MovieEntity movieEntity = service.findById(id);
		//return as model not entity
		return new MovieModel(movieEntity.getId(), movieEntity.getTitle(), movieEntity.getGenre(), movieEntity.getImage(), movieEntity.getRating());
	}
	
	//Update based off an id, set new values to movie model values
	public boolean update(int id, MovieModel movie) {
		//convert from movieModel to MovieEntity
		MovieEntity movieEntity = new MovieEntity();
		movieEntity.setId(id);
		movieEntity.setTitle(movie.getTitle());
		movieEntity.setGenre(movie.getGenre());
		movieEntity.setImage(movie.getImage());
		movieEntity.setRating(movie.getRating());
		//Call the service.create method to handle the creation
		boolean success = service.update(movieEntity);
		return success;
	}

	public void delete(int id) {

		service.delete(id);
	}

}
