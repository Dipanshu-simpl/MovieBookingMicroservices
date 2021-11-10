package com.magoo.service.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.magoo.service.entity.MovieCatalog;
import com.magoo.service.entity.MovieResponse;
import com.magoo.service.entity.PaymentInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	private static List<MovieCatalog> movieCatalog=new ArrayList<>();
	static RestTemplate restTemplate =new RestTemplate();
	
	static
	{
		movieCatalog.add(new MovieCatalog(1,"Matrix","A good movie","Action","3 stars",150.0,2));
		movieCatalog.add(new MovieCatalog(2,"Hera pheri","Great movie to watch","Comedy","3.5 stars",160.0,4));
		movieCatalog.add(new MovieCatalog(4,"The Conjuring","Excellent movie","Drama","4 stars",200.0,9));
	}
	
	
	@RequestMapping(path= "/movies" , method=RequestMethod.POST)
	public ResponseEntity<MovieCatalog> addMovie(@RequestBody MovieCatalog mb)
	{
		Integer id=movieCatalog.size()+1;
		mb.setId(id);
		movieCatalog.add(mb);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(mb.getId())
                .toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(path="/moviesNam/{name}"  , method=RequestMethod.GET)
	public MovieCatalog getMovie(@PathVariable("name") String movieName)
	{
		MovieCatalog ct=null;
		for(MovieCatalog mt:movieCatalog)
		{
			if(mt.getName().equals(movieName))
			{
				ct=mt;
			}
		}
		return ct;
		
	}
	
	
	
	@RequestMapping(path="/moviesId/{id}"  , method=RequestMethod.GET)
	public MovieCatalog getMovieById(@PathVariable("id") String id)
	{
		MovieCatalog ct=null;
		for(MovieCatalog mt:movieCatalog)
		{
			if((String.valueOf(mt.getId()).equals(id)))
			{
				ct=mt;
			}
		}
		return ct;
		
	}
	
	@RequestMapping(path= "/movies" ,  method=RequestMethod.GET)
	public List<MovieCatalog> getMovies()
	{
		
		// CalliMovieng MovieBooking service
		
		//RestTemplate restTemplate=new RestTemplate();
		
		//MovieBooking mb= restTemplate.getForObject("http://localhost:8082/booking/panda", MovieBooking.class);
		//System.out.println(mb.getNoOfTickets()+" "+mb.getMovieName());
		
		//List<MovieCatalog> list=Arrays.asList(new MovieCatalog(1,"Titanic","great movie","Romantic","3 stars",90.0));
		
		return movieCatalog;
	}
	
	@RequestMapping(path="/movies/{movieName}/{noofTickets}")
	public PaymentInfo bookMovie(@PathVariable("movieName") String movieName,@PathVariable("noofTickets") String noofTickets)
	{
		
		Map<String,String> params=new HashMap<>();
		params.put("movieName",movieName);
		params.put("noofTickets", noofTickets);
		RestTemplate restTemplate=new RestTemplate();
		
		//MovieResponse res= restTemplate.getForObject("http://localhost:8082/booking/movies/"+movieName+"/"+noofTickets, MovieResponse.class, params);
		MovieCatalog mcc=getMovie(movieName);
		String movieId=String.valueOf(mcc.getId());
		System.out.println(movieId);
		PaymentInfo respon=restTemplate.getForObject("http://localhost:8083/payment/movies/"+movieId ,PaymentInfo.class);
		System.out.println(respon);
		
		return respon;
		
	}
	
	
	@RequestMapping(path="/movies/testing"  , method=RequestMethod.POST)
	public PaymentInfo bookMovie(@RequestBody MovieCatalog movieCatalog)
	{
		
		
		Double price =movieCatalog.getPrice();
		PaymentInfo respon=restTemplate.getForObject("http://localhost:8083/payment/movies/"+movieCatalog.getId() ,PaymentInfo.class);
		
		respon.setTotAmountPaid(movieCatalog.getSeatsToBook()*price);
		
		return respon;
		
	}
	

}
