package com.skilldistillery.filmquery.entities;

import java.util.*;

public class Film {
	private int id;
	private String title;
	private String description;
	private Integer releaseYear;
	private int languageId;
	private String language;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String filmCategory;
	private List<Actor> cast = new ArrayList<>();

	public Film() {

	}

	public Film(int id, String title, String description, Integer releaseYear, int languageId, String language,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating,
			String specialFeatures, List<Actor> cast) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.language = language;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.cast = cast;
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

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer year) {
		this.releaseYear = year;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
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

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getFilmCategory() {
		return filmCategory;
	}

	public void setFilmCategory(String filmCategory) {
		this.filmCategory = filmCategory;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	public String allDetails() {
		StringBuilder builder = new StringBuilder();
		builder.append("*****ALL " + getTitle() + " Details*****");
		builder.append("\nFilm ID: \t");
		builder.append(getId());
		builder.append("\nTitle: \t");
		builder.append(getTitle());
		builder.append("\nDescription: \t");
		builder.append(getDescription());
		builder.append("\nRelease Year: \t");
		builder.append(getReleaseYear());
		builder.append("\nLanguage ID: \t");
		builder.append(getLanguageId());
		builder.append("\nLanguage: \t");
		builder.append(getLanguage());
		builder.append("\nRental Duration: \t");
		builder.append(getRentalDuration());
		builder.append("\nRental Rate: \t");
		builder.append(getRentalRate());
		builder.append("\nLength: \t");
		builder.append(getLength());
		builder.append("\nReplacement Cost: \t");
		builder.append(getReplacementCost());
		builder.append("\nRating: \t");
		builder.append(getRating());
		builder.append("\nFilm Category: \t");
		builder.append(getFilmCategory());
		builder.append("\nSpecial Features: \t");
		builder.append(getSpecialFeatures());
		builder.append("\nDescription: \t");
		builder.append(getDescription());
		builder.append("\nActors in this film: ");
		for (Actor actor : cast) {
			builder.append("\n" + actor.getFirstName() + " " + actor.getLastName());
		}
		builder.append("\n");
		return builder.toString();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Title: \t");
		builder.append(getTitle());
		builder.append("\nRelease Year: \t");
		builder.append(getReleaseYear());
		builder.append("\nRating: \t");
		builder.append(getRating());
		builder.append("\nLanguage: \t");
		builder.append(getLanguage());
		builder.append("\nDescription: \t");
		builder.append(getDescription());
		builder.append("\nActors in this film: ");
		for (Actor actor : cast) {
			builder.append("\n" + actor.getFirstName() + " " + actor.getLastName());
		}
		builder.append("\n");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + languageId;
		result = prime * result + length;
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + rentalDuration;
		long temp;
		temp = Double.doubleToLongBits(rentalRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(replacementCost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((specialFeatures == null) ? 0 : specialFeatures.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		return result;
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (languageId != other.languageId)
			return false;
		if (length != other.length)
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (rentalDuration != other.rentalDuration)
			return false;
		if (Double.doubleToLongBits(rentalRate) != Double.doubleToLongBits(other.rentalRate))
			return false;
		if (Double.doubleToLongBits(replacementCost) != Double.doubleToLongBits(other.replacementCost))
			return false;
		if (specialFeatures == null) {
			if (other.specialFeatures != null)
				return false;
		} else if (!specialFeatures.equals(other.specialFeatures))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		return true;
	}

}
