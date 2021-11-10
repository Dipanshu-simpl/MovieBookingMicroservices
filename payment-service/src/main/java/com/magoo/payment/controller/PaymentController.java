package com.magoo.payment.controller;

import java.security.SecureRandom;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.magoo.payment.entity.MovieBooking;
import com.magoo.payment.entity.MovieCatalog;
import com.magoo.payment.entity.MovieResponse;
import com.magoo.payment.entity.PaymentInfo;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	static RestTemplate restTemplate=new RestTemplate();

	public static String randomString(int len){
	   StringBuilder sb = new StringBuilder(len);
	   for(int i = 0; i < len; i++)
	      sb.append(AB.charAt(rnd.nextInt(AB.length())));
	   return sb.toString();
	}
	
	
	@RequestMapping("/movies/{movieId}")
	public PaymentInfo makePayment(@PathVariable("movieId") String movieId)
	{
		PaymentInfo pi=new PaymentInfo();
		//String name=getMovieName(movieId);
		pi.setTransactionId(randomString(16));
		pi.setMovieId(movieId);
		pi.setPayStatus(true);
		pi.setModeOfPayment("ONLINE-CREDIT CARD");
		//MovieCatalog mcc=getMoviedetails(movieId);
		
		MovieBooking nm=restTemplate.getForObject("http://localhost:8082/booking/movies/"+movieId,MovieBooking.class);
		System.out.println(nm);
	    MovieResponse rs=restTemplate.getForObject("http://localhost:8082/booking/movies/"+nm.getMovieName()+"/"+nm.getNoOfTickets(), MovieResponse.class);
		
	    pi.setTotAmountPaid(rs.getTotAmount());
		
		return pi;
		
	}
	
	
	
	public static String getMovieName(String id)
	{
		
		MovieCatalog mcc=restTemplate.getForObject("http://localhost:8081/catalog/moviesId/"+id, MovieCatalog.class);
	    return mcc.getName();
	}
	
	public static MovieCatalog getMoviedetails(String id)
	{
		
		MovieCatalog mC=restTemplate.getForObject("http://localhost:8082/booking/movies/"+id, MovieCatalog.class);
		return mC;
	}

}
