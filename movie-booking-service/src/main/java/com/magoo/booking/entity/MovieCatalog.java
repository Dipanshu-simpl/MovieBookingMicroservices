package com.magoo.booking.entity;

public class MovieCatalog {
	
	private int id;
	private String name;
	
	private String desc;
	
	private String genre;
	
	private String rating;
	
	private double price;
	
	public MovieCatalog()
	{
		
	}
	
	public MovieCatalog(int id,String name,String desc,String genre,String rating,double price)
	{
		this.id=id;
		this.name=name;
		this.desc=desc;
		this.genre=genre;
		this.rating=rating;
		this.price=price;
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

	
	public Double getPrice()
	{
		return price;
	}
	
	public void setDouble(Double price)
	{
		this.price=price;
	}

	@Override
	public String toString() {
		return "MovieCatalog [id=" + id + ", name=" + name + ", desc=" + desc + ", genre=" + genre + ", rating="
				+ rating + ", price=" + price + "]";
	}
	
	
	

}
