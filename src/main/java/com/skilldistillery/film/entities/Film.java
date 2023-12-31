package com.skilldistillery.film.entities;

import java.util.List;
import java.util.Objects;



public class Film {
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String features;
	private int languageId;
	private List<Actor> actors;
	private String languageName;

	public Film() {
		
	}
	
	public Film(String title, String description) {
		this.title=title;
		this.description = description;
	}
	
	public Film(String title, String description,int releaseYear) {
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		
		
	}
	
	public Film(int id, String title, String desc, int releaseYear, int rentDur, double rate, int length,
			double repCost, String rating, String features, String languageName) {
		super();
		this.id = id;
		this.title = title;
		this.description = desc;
		this.releaseYear = releaseYear;
		this.rentalDuration = rentDur;
		this.rentalRate = rate;
		this.length = length;
		this.replacementCost = repCost;
		this.rating = rating;
		this.features = features;
		this.languageName = languageName;
		
	}

	public Film(int id, String filmName, String description,
			int released, String language, String rating) {
		this.id = id;
		this.title = filmName;
		this.description = description;
		this.releaseYear = released;
		this.languageName = language;
		this.rating = rating;
		
		
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

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", features=" + features
				+ ", languageId=" + languageId + ", actors=" + actors + ", languageName=" + languageName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, description, features, id, languageId, languageName, length, rating, releaseYear,
				rentalDuration, rentalRate, replacementCost, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
				&& Objects.equals(features, other.features) && id == other.id && languageId == other.languageId
				&& Objects.equals(languageName, other.languageName) && length == other.length
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear
				&& rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(title, other.title);
	}

}
