package com.example.demo.dto;

import java.net.URL;
import java.time.LocalDate;

public class TransactionDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private LocalDate dateOfSale;
    private String category;
    private URL image;
    private boolean sold;
    
    

    public TransactionDTO(Long id, String title, String description, double price, LocalDate dateOfSale,
			String category, URL image, boolean sold) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.dateOfSale = dateOfSale;
		this.category = category;
		this.image = image;
		this.sold = sold;
	}

	public TransactionDTO() {
        // Default constructor
    }

   
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public URL getImage() {
		return image;
	}

	public void setImage(URL image) {
		this.image = image;
	}

	public boolean isSold() {
		return sold;
	}

	public void setSold(boolean sold) {
		this.sold = sold;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getDateOfSale() {
		return dateOfSale;
	}

	public void setDateOfSale(LocalDate dateOfSale) {
		this.dateOfSale = dateOfSale;
	}

    
}

