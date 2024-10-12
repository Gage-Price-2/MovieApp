package com.gcu.movie.models;

public class MovieModel {
	//Model attributes
	public int Id;
	public String Title;
	public String Genre;
	public String Image;
	public int Rating;
	
	//Parameterized Constructor
	public MovieModel(int id, String title, String genre, String image, int rating) {
		super();
		Id = id;
		Title = title;
		Genre = genre;
		Image = image;
		Rating = rating;
	}
	
	public MovieModel() {
		// TODO Auto-generated constructor stub
	}

	/* Getter/Setter section for all fields*/
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	
	
}
