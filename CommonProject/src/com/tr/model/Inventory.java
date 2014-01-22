package com.tr.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CP_INVENTORY")
public class Inventory {

	private double isbn;
	private String bookName;
	private String authorName;
	private Category genre;
	private Publisher publisher;
	private float price;
	private String description;
	private File CoverImage;

	@Id
	@GenericGenerator(name = "ISBN", strategy = "assigned")
	@GeneratedValue(generator = "ISBN")
	@Column(name = "ISBN")
	public double getIsbn() {
		return isbn;
	}

	public void setIsbn(double isbn) {
		this.isbn = isbn;
	}

	@Column(name = "BOOKNAME")
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Column(name = "AUTHORNAME")
	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "pid")
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	@JoinColumn(name = "categoryId")
	public Category getGenre() {
		return genre;
	}

	public void setGenre(Category genre) {
		this.genre = genre;
	}

	@Column(name = "PRICE")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "COVERIMAGE")
	public final File getCoverImage() {
		return CoverImage;
	}

	public final void setCoverImage(File coverImage) {
		CoverImage = coverImage;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
