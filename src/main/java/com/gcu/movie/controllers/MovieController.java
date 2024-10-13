package com.gcu.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.gcu.movie.business.MovieBusinessServiceInterface;
import com.gcu.movie.models.MovieModel;
@Controller
@RequestMapping("/movies")
public class MovieController {

	//Our business service interface instance(uses bean)
	@Autowired
	private MovieBusinessServiceInterface service;
	
	//Method to get all movie and display the list of movies
	@RequestMapping("/")
	public String showMovies(Model model) {
        model.addAttribute("title", "My Movies");
        // service.getMovies() returns a list of all movies in the "movies" attribute
		model.addAttribute("movies", service.getMovies());
		//return view
        return "list";
    }
	
	//Method to display the create form to the user
	@GetMapping("/create")
    public String showCreateEventForm(Model model) {
		//pass in an empty model
        model.addAttribute("movie", new MovieModel());
        model.addAttribute("pageTitle", "Create Movie");
        //show create-movie form view
        return "create-movie";
    }
	
	//Method to handle the creation of a movie, returns user back to home
	@PostMapping("/create")
    public String createEvent(MovieModel movie, BindingResult result, Model model) {
		//If there is an error, return back to the create page
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Create Event");
            return "create-event";
        }
        //Calls business service method(returns boolean)
        service.create(movie);
        return "redirect:/movies/";
    }
	
	//Method to delete by id
	@PostMapping("/delete/{id}")
    public String deleteEvent(@PathVariable int id) {
        service.delete(id);
        return "redirect:/movies/";
    }
	
	@GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable int id, Model model) {
        MovieModel movie = service.findById(id);
        model.addAttribute("movie", movie);
        return "edit-movie";
    }

    @PostMapping("/edit/{id}")
    public String updateEvent(@PathVariable int id, @ModelAttribute MovieModel movie, Model model) {
    	System.out.println("Edit 2: " + movie.Title );
        service.update(id, movie);
        return "redirect:/movies/";
    }
}

