package com.example.sellingbooks;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

	private static ArrayList<Book> available_books = new ArrayList();
	private static ArrayList<Book> basket = new ArrayList();
	private static double total_price=0;
	private static Scanner s = new Scanner(System.in);
	
	// The main creates tha books, and an easy option menu
	public static void main(String [ ] args)
	{
		create_books();
		
		System.out.println("Command Options: ");
		System.out.println("1: Display availalbe books");
		System.out.println("2: Display books in basket");
		System.out.println("3: Add book");
		System.out.println("4: Remove book");
		System.out.println("6: Show options");
		System.out.println("7: Quit");
		
		String title;
		String choice = s.nextLine();
		
		do {	
		switch (choice){
		    case "1":
		    	display_available_books();
		    	choice= s.nextLine();
		        break; 
		    case "2":
		    	display_books_in_basket();
		    	choice= s.nextLine();
		        break; 
		    case "3":
		    	add_book();
		    	choice= s.nextLine();
		        break; 
		    case "4":
		    	remove_book();
		    	choice= s.nextLine();
		        break; 
		    case "5":
		    	calculate_price();
		    	choice= s.nextLine();
		        break;  
		    case "6":
		    	System.out.println("Command Options: ");
				System.out.println("1: Display availalbe books");
				System.out.println("2: Display books in basket");
				System.out.println("3: Add book");
				System.out.println("4: Remove book");
				System.out.println("5: Calculate price");
				System.out.println("6: Show options");
				System.out.println("7: Quit");
				
				choice = s.nextLine();
				break;
			default:
				System.out.println("Invalid choice");
				choice= s.nextLine();
				break;
		}}while (choice != "7");    	
	}
	
	//Creates the available books and adds them to the available books list
	public static void create_books()
	{
		available_books.add(new Book("Moby Dick", 1851, 15.20));
		available_books.add(new Book("The Terrible Privacy of Maxwell Sim", 2010, 13.14));
		available_books.add(new Book("Still Life With Woodpecker", 1980, 11.05));
		available_books.add(new Book("Sleeping Murder", 1976, 10.24));
		available_books.add(new Book("Three Men in a Boat", 1889, 12.87));
		available_books.add(new Book("The Time Machine", 1995, 10.43));
		available_books.add(new Book("The Caves of Steel", 1954, 8.12));
		available_books.add(new Book("Idle Thoughts of an Idle Fellow", 1886, 7.32));
		available_books.add(new Book("A Christmas Carol", 18430, 4.23));
		available_books.add(new Book("A Tale of Two Cities", 1859, 6.32));
		available_books.add(new Book("Great Expectations", 1861, 13.21));
	}
	
	//Display the available books. If the list is empty, it will display an appropriate message
	public static void display_available_books()
	{
		if(available_books.size()>0)
		{
			for(Book book:available_books)
			{
				book.to_String();
			}
		}
		else
		{
			System.out.println("There are no more available books");
		}
	}
	
	//Display the books in the basket. If the basket is empty, it will display an appropriate message
	public static void display_books_in_basket()
	{
		if(basket.size()>0)
		{
			for(Book book:basket)
			{
				book.to_String();
			}
		}
		else
		{
			System.out.println("The basket is empty");
		}
	}
	
	//Removes a book from the available books list and puts in the basket. 
	public static void add_book()
	{
		System.out.println("Please give the book title");
		String title = s.nextLine();
		try
		{
			for(Book book:available_books)
			{
				if(book.getName().equals(title))
				{
					basket.add(book);
					available_books.remove(book);	
					System.out.println("Thank you for selecting a book");
					System.out.println("You will be brought back to the menu");
				}
				else if(!book.getName().equals(title))
				{
					continue;
				}

			}
		} catch(Exception e) {}
	}
	
	//Removes a book from the basket and puts it back to the list
	public static void remove_book()
	{
		System.out.println("Please give the book title");
		String title = s.nextLine();
		try
		{
			for(Book book:basket)
			{
				if(book.getName().equals(title))
				{
					available_books.add(book);
					basket.remove(book);
					System.out.println("Thank you for selecting a book");
					System.out.println("You will be brought back to the menu");
				}
				else if(!book.getName().equals(title))
				{
					continue;
				}

			}
		} catch(Exception e) {}
	}
	
	//Calculates the price of the books in the basket; and adds discounts if applicable
	public static void calculate_price()
	{
		for(Book book:basket)
		{
			if(book.getYear()>2000)
			{
				total_price = total_price + apply_book_discount(book);;
			}
			else
			{
				total_price = total_price + book.getPrice();
			}
					
		}
		total_price = apply_total_discount(total_price);
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("The total price is: " + df.format(total_price));
		total_price=0;
	}
	
	//Discounts a book; Used for books that were published after 2000
	public static double apply_book_discount(Book book)
	{
		double new_price = book.getPrice() - ((book.getPrice() * 10) / 100);
		return new_price;
	}
	
	//Discounts books if they surpass the price of 30
	public static double apply_total_discount(double price)
	{
		double new_price=0;
			if(price>30)
			{
				new_price = price - ((price * 5) / 100);
			}
			else
			{
				return price;
			}
			return new_price;
	}
}
