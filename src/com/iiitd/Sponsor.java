package com.iiitd;

import java.time.LocalDate;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sponsor {
	SimpleStringProperty name;
	SimpleIntegerProperty year;
	SimpleStringProperty player;
	SimpleIntegerProperty atp;
	SimpleStringProperty country;
	SimpleIntegerProperty titles;
	
	public Sponsor(String name, Integer year, String player, Integer atp, String country, Integer titles)
	{
		this.name = new SimpleStringProperty(name);
		this.year = new SimpleIntegerProperty(year);
		this.player = new SimpleStringProperty(player);
		this.atp = new SimpleIntegerProperty(atp);
		this.country = new SimpleStringProperty(country);
		this.titles = new SimpleIntegerProperty(titles);
	}

	public String getName() {
		return name.get();
	}

	public Integer getYear() {
		return year.get();
	}

	public String getPlayer() {
		return player.get();
	}

	public Integer getAtp() {
		return atp.get();
	}

	public String getCountry() {
		return country.get();
	}

	public Integer getTitles() {
		return titles.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}

	public void setYear(Integer year) {
		this.year.set(year);;
	}

	public void setPlayer(String player) {
		this.player.set(player);;
	}

	public void setAtp(Integer atp) {
		this.atp.set(atp);;
	}

	public void setCountry(String country) {
		this.country.set(country);;
	}

	public void setTitles(Integer titles) {
		this.titles.set(titles);;
	}

}
