package com.gcu.movie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.gcu.movie.business.MovieBusinessService;
import com.gcu.movie.business.MovieBusinessServiceInterface;
import com.gcu.movie.data.DataAccessInterface;
import com.gcu.movie.data.MovieDataService;

@Configuration
public class SpringConfig {

	@Bean(name="movieBusinessService")
	public MovieBusinessServiceInterface getMoviesBusiness() {
		return new MovieBusinessService();
	}


}
