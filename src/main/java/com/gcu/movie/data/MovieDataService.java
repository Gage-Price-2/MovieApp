package com.gcu.movie.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.movie.data.entity.MovieEntity;
import com.gcu.movie.repository.MoviesRepository;



@Service
public class MovieDataService implements DataAccessInterface<MovieEntity>{

	@Autowired
	private MoviesRepository moviesRepository;
	
	public MovieDataService(MoviesRepository moviesRepository) {
		this.moviesRepository = moviesRepository;
	}
	@Override
	public List<MovieEntity> findAll() {
		// TODO Auto-generated method stub
		List<MovieEntity> movies = new ArrayList<MovieEntity>();
		
		try
		{
			//Gets all from database
			Iterable<MovieEntity> ordersIterable = moviesRepository.findAll();
			
			ordersIterable.forEach(movies::add);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return movies;
	}

	@Override
	public MovieEntity findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(MovieEntity t) {
		try {
			//Adds a new movie to the database using the entity
			moviesRepository.save(t);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(MovieEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(MovieEntity t) {
		// TODO Auto-generated method stub
		return false;
	}



}
