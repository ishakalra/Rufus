package com.iiitd;

import java.time.LocalDate;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Coach {
	SimpleStringProperty name;
	SimpleObjectProperty<LocalDate> dob;
	SimpleStringProperty country;
	SimpleStringProperty coachee;
	SimpleObjectProperty<LocalDate> coachingsince;
	SimpleObjectProperty<LocalDate> coachingtill;
	
	public Coach(String name, LocalDate dob, String country, String coachee, LocalDate coachingsince, LocalDate coachingtill)
	{
		this.name = new SimpleStringProperty(name);
		this.dob = new SimpleObjectProperty<LocalDate>(dob);
		this.country = new SimpleStringProperty(country);
		this.coachee = new SimpleStringProperty(coachee);
		this.coachingsince = new SimpleObjectProperty<LocalDate>(coachingsince);
		this.coachingtill = new SimpleObjectProperty<LocalDate>(coachingtill);
	}

	public String getName() {
		return name.get();
	}

	public LocalDate getDob() {
		return dob.get();
	}

	public String getCountry() {
		return country.get();
	}

	public String getCoachee() {
		return coachee.get();
	}

	public LocalDate getCoachingsince() {
		return coachingsince.get();
	}

	public LocalDate getCoachingtill() {
		return coachingtill.get();
	}

	public void setName(String name) {
		this.name.set(name);;
	}

	public void setDob(LocalDate dob) {
		this.dob.set(dob);;
	}

	public void setCountry(String country) {
		this.country.set(country);;
	}

	public void setCoachee(String coachee) {
		this.coachee.set(coachee);;
	}

	public void setCoachingsince(LocalDate coachingsince) {
		this.coachingsince.set(coachingsince);;
	}

	public void setCoachingtill(LocalDate coachingtill) {
		this.coachingtill.set(coachingtill);;
	}
	
	
}
