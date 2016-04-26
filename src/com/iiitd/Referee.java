package com.iiitd;

import java.time.LocalDate;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Referee {
	SimpleStringProperty name;
	SimpleObjectProperty<LocalDate> dob;
	SimpleStringProperty country;
	SimpleIntegerProperty matches;
	
	public Referee(String name, LocalDate dob, String country, Integer matches)
	{
		this.name = new SimpleStringProperty(name);
		this.dob = new SimpleObjectProperty<LocalDate>(dob);
		this.country = new SimpleStringProperty(country);
		this.matches = new SimpleIntegerProperty(matches);
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
		return matches.get();
	}

	public void setPoints(Integer points) {
		this.matches.set(points);;
	}

}
