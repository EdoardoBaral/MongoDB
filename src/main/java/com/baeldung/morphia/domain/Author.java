package com.baeldung.morphia.domain;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

import java.util.List;

@Entity
public class Author
{
	@Id
	private String name;
	private List<String> books;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public List<String> getBooks()
	{
		return books;
	}
	
	public void setBooks(List<String> books)
	{
		this.books = books;
	}
	
}