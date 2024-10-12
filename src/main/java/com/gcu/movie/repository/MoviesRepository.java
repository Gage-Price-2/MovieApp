package com.gcu.movie.repository;

import org.springframework.data.repository.CrudRepository;

import com.gcu.movie.data.entity.MovieEntity;

public interface MoviesRepository extends CrudRepository<MovieEntity, Integer>{

}
