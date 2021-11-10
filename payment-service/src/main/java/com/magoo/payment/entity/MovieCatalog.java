package com.magoo.payment.entity;

public class MovieCatalog {
	
	private int id;
	private String name;
	
	private String desc;
	
	private String genre;
	
	private String rating;
	
	private double price;
	
	
	private int seatsAvailable;
	
	private int noOfSeatsToBook;
	
	public MovieCatalog()
	{
		
	}
	
	public MovieCatalog(int id,String name,String desc,String genre,String rating,double price,int seatsAvailable,int noOfSeatsToBook)
	{
		this.id=id;
		this.name=name;
		this.desc=desc;
		this.genre=genre;
		this.rating=rating;
		this.price=price;
		this.seatsAvailable=seatsAvailable;
		this.noOfSeatsToBook=noOfSeatsToBook;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getNoOfSeatsToBook() {
		return noOfSeatsToBook;
	}

	public void setNoOfSeatsToBook(int noOfSeatsToBook) {
		this.noOfSeatsToBook = noOfSeatsToBook;
	}

	@Override
	public String toString() {
		return "MovieCatalog [id=" + id + ", name=" + name + ", desc=" + desc + ", genre=" + genre + ", rating="
				+ rating + ", price=" + price + ", seatsAvailable=" + seatsAvailable + ", noOfSeatsToBook="
				+ noOfSeatsToBook + "]";
	}
	
	
	
}
	