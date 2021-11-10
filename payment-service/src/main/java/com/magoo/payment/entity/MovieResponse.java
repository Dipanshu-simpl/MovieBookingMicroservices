package com.magoo.payment.entity;

public class MovieResponse {

	
	private String movieName;
	private String noofTickets;
	
	private double totAmount;
	
	
	public MovieResponse()
	{
		
	}
	
	
	public MovieResponse(String movieName,String noofTickets,double totAmount)
	{
		this.movieName=movieName;
		this.noofTickets=noofTickets;
		this.totAmount=totAmount;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getNoofTickets() {
		return noofTickets;
	}


	public void setNoofTickets(String noofTickets) {
		this.noofTickets = noofTickets;
	}


	public double getTotAmount() {
		return totAmount;
	}


	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
	}


	@Override
	public String toString() {
		return "Response [movieName=" + movieName + ", noofTickets=" + noofTickets + ", totAmount=" + totAmount + "]";
	}
	
	
	
	
	
}
