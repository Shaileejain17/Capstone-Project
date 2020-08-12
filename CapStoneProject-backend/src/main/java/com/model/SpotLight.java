package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class SpotLight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String title;
	private String description;
	private String language;
	private String country;
	private String keywords;
	private boolean spotlight;
	private String productImage;
	private Date startDate;
	private Date endDate;
	
	public SpotLight() {
		// TODO Auto-generated constructor stub
	}

	public SpotLight(int id, String title, String description, String language, String country, String keywords,
			boolean spotlight, String productImage, Date startDate, Date endDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.country = country;
		this.keywords = keywords;
		this.spotlight = spotlight;
		this.productImage = productImage;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public boolean getSpotlight() {
		return spotlight;
	}

	public void setSpotlight(boolean spotlight) {
		this.spotlight = spotlight;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "SpotLight [id=" + id + ", title=" + title + ", description=" + description + ", language=" + language
				+ ", country=" + country + ", keywords=" + keywords + ", spotlight=" + spotlight + ", productImage="
				+ productImage + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
