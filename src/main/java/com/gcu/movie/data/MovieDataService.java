package com.gcu.movie.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		try{
			 Optional<MovieEntity> entityOptional = moviesRepository.findById(id);
		      return entityOptional.orElse(null); 
			
		}
		catch(Exception e) {
			return null;
		}
		
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
		try {
			//Adds a new movie to the database using the entity
			moviesRepository.save(t);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		try {
			//Adds a new movie to the database using the entity
			moviesRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	@Override
	public boolean delete(MovieEntity t) {
		// TODO Auto-generated method stub
		return false;
	}



}
