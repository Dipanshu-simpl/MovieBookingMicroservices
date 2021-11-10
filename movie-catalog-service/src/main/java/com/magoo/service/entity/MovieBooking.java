package com.magoo.service.entity;

public class MovieBooking {
	
	private int bookingId;
	private String movieName;
	
	private int noOfTickets;
	private boolean bookFlag;
	
	public MovieBooking()
	{
		
	}
	
	public MovieBooking(int bookingId,String movieName,int noOfTickets,boolean bookFlag)
	{
		this.bookingId=bookingId;
		this.movieName=movieName;
		this.noOfTickets=noOfTickets;
		this.bookFlag=bookFlag;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public boolean isBookFlag() {
		return bookFlag;
	}

	public void setBookFlag(boolean bookFlag) {
		this.bookFlag = bookFlag;
	}

	@Override
	public String toString() {
		return "MovieBooking [bookingId=" + bookingId + ", movieName=" + movieName + ", noOfTickets=" + noOfTickets
				+ ", bookFlag=" + bookFlag + "]";
	}
	
	

}
