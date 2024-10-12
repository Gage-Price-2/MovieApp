package com.gcu.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
}
/*
@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public String getAllEvents(Model model) {
        List<EventModel> events = eventService.findAll();
        model.addAttribute("events", events);
        model.addAttribute("message", "Showing all events");
        model.addAttribute("pageTitle", "Events");
        return "events";
    }

    @GetMapping("/create")
    public String showCreateEventForm(Model model) {
        model.addAttribute("event", new EventModel());
        model.addAttribute("pageTitle", "Create Event");
        return "create-event";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute @Valid EventModel event, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pageTitle", "Create Event");
            return "create-event";
        }
        eventService.save(event);
        return "redirect:/events";
    }

    @GetMapping("/edit/{id}")
    public String showEditEventForm(@PathVariable String id, Model model) {
        EventModel event = eventService.findById(id);
        model.addAttribute("event", event);
        return "edit-event";
    }

    @PostMapping("/edit/{id}")
    public String updateEvent(@PathVariable String id, @ModelAttribute EventModel event, Model model) {
        EventModel updatedEvent = eventService.updateEvent(id, event);
        model.addAttribute("event", updatedEvent);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable String id) {
        eventService.delete(id);
        return "redirect:/events";
    }

    // EventController.java (part of the existing file)
@GetMapping("/search")
public String searchForm(Model model) {
    model.addAttribute("eventSearch", new EventSearch());
    return "searchForm";
}

@PostMapping("/search")
public String search(@ModelAttribute @Valid EventSearch eventSearch, BindingResult result, Model model) {
    if (result.hasErrors()) {
        return "searchForm";
    }
    List<EventModel> events = eventService.findByDescription(eventSearch.getSearchString());
    model.addAttribute("message", "Search results for " + eventSearch.getSearchString());
    model.addAttribute("events", events);
    return "events";
}*/

