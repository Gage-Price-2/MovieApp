package com.gcu.movie.data.entity;

import org.springframework.data.relational.core.mapping.*;
import org.springframework.data.annotation.*;


@Table("movie")
public class MovieEntity {

	//Mapping model fields to their corresponding columns in our database
	@Id
	int id;
	
	@Column("Title")
	String title;
	
	@Column("Genre")
	String genre;
	
	@Column("Image")
	String image;
	
	@Column("Rating")
	int rating;

	//Constructor
	public MovieEntity(int id, String title, String genre, String image, int rating) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.image = image;
		this.rating = rating;
	}
	
	public MovieEntity() {
		// TODO Auto-generated constructor stub
	}

	//Getters and Setters for all fields:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
