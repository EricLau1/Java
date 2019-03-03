package com.eric.books.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book implements Serializable {

	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Size(max=50)	
	@Column(nullable=false)
	private String title;
	
	@Column(columnDefinition="Decimal(2,1) default '1.0'")
	private Double rating;

	public Book() {}
	
	public Book(Long id, @NotBlank @Size(max = 50) String title, Double rating) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
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

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
}
