package com.example.sellingbooks;

public class Book {

	String name;
	int year;
	double price;
	
	public Book(String name, int year, double price)
	{
		this.name = name;
		this.price = price;
		this.year = year;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void to_String()
	{
		System.out.println("Book Name: " + name + ", Year of publication: " + year  + ", Price: " + price);
	}
}
