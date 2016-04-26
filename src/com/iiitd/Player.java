package com.iiitd;

import java.time.LocalDate;
import java.util.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Player {
	
	SimpleStringProperty name;
	SimpleStringProperty country;
	SimpleObjectProperty<LocalDate> dob;
	SimpleIntegerProperty points;
	SimpleIntegerProperty year;
	SimpleIntegerProperty matches;
	SimpleIntegerProperty titles;
	
	public Player(String name, String country, LocalDate dob, int points, int year, int matches, int titles)
	{
		this.name = new SimpleStringProperty(name);
		this.country = new SimpleStringProperty(country);
		this.dob = new SimpleObjectProperty<LocalDate>(dob);
		this.points = new SimpleIntegerProperty(points);
		this.year = new SimpleIntegerProperty(year);
		this.matches = new SimpleIntegerProperty(matches);
		this.titles = new SimpleIntegerProperty(titles);
		
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}

	public String getCountry() {
		return country.get();
	}

	public void setCountry(String country) {
		this.country.set(country);;
	}

	public LocalDate getDob() {
		return dob.get();
	}

	public void setDob(LocalDate dob) {
		this.dob.set(dob);;
	}

	public Integer getPoints() {
		return points.get();
	}

	public void setPoints(Integer points) {
		this.points.set(points);;
	}

	public Integer getYear() {
		return year.get();
	}

	public void setYear(Integer year) {
		this.year.set(year);;
	}

	public Integer getMatches() {
		return matches.get();
	}

	public void setMatches(Integer matches) {
		this.matches.set(matches);;
	}

	public Integer getTitles() {
		return titles.get();
	}

	public void setTitles(Integer titles) {
		this.titles.set(titles);;
	}
}
