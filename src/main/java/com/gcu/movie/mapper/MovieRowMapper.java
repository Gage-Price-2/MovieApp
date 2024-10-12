package com.gcu.movie.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.gcu.movie.data.entity.MovieEntity;

public class MovieRowMapper implements RowMapper<MovieEntity>{

	@Override
	public MovieEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new MovieEntity(rs.getInt("ID"), rs.getString("Title"), rs.getString("Genre"), rs.getString("Image"), rs.getInt("Rating"));
	}

}
