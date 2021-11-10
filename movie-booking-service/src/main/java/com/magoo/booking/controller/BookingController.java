package com.magoo.booking.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.magoo.booking.entity.MovieBooking;
import com.magoo.booking.entity.MovieCatalog;
import com.magoo.booking.entity.MovieResponse;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	static RestTemplate restTemplate=new RestTemplate();
	
	
	private static List<MovieBooking> list=new ArrayList<>();
	
	static 
	{
		list.add(new MovieBooking(1,"Matrix",4,false));
        list.add(new MovieBooking(4,"The Conjuring",3,true));
        list.add(new MovieBooking(2,"Hera pheri",6,true));
	}
	
	
	@RequestMapping("/movies/{movieId}")
	public MovieBooking getMovieBookingDetails(@PathVariable("movieId") String movieId)
	{
		MovieBooking mb=null;
		for(MovieBooking mbb:list)
		{
			if(movieId.equals(String.valueOf(mbb.getBookingId())))
			{
				mb=mbb;
			}
		}
		return mb;
	}
	
	@RequestMapping(path= "/movies/{movieName}/{noofTickets}" ,  method=RequestMethod.GET)
	public MovieResponse getBookingDetails(@PathVariable("movieName") String movieName,@PathVariable("noofTickets") String noofTickets)
	
	{
		MovieBooking ans=null;
	    for(MovieBooking mb:list)	
	    {
	    	if(mb.getMovieName().equals(movieName))
	    	{
	    		ans=mb;
	    	}
	    }
	    Double price=getPrice(movieName);
	    
	    double payableAmount=price * Double.parseDouble(noofTickets);
	    MovieResponse mv=new MovieResponse();
	    mv.setMovieName(ans.getMovieName());
	    mv.setNoofTickets(noofTickets);
	    mv.setTotAmount(payableAmount);
	    
	    return mv;
		
	}
	
	@RequestMapping(path= "/movies" , method=RequestMethod.POST)
	public ResponseEntity<MovieBooking> addMovie(@RequestBody MovieBooking mb)
	{
		Integer id=list.size()+1;
		mb.setBookingId(id);
		list.add(mb);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mb.getBookingId())
                .toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	public double getPrice(String movieName)
	{
		
		MovieCatalog mc= restTemplate.getForObject("http://localhost:8081/catalog/moviesNam/"+movieName, MovieCatalog.class);
		System.out.println(mc);
		return mc.getPrice();
	}
	
	
}
