package com.iiitd;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Match {
	SimpleStringProperty tournament;
	SimpleIntegerProperty year;
	SimpleStringProperty round;
	SimpleStringProperty pwon;
	SimpleStringProperty plost;
	SimpleStringProperty referee;
	SimpleStringProperty atp;
	
	public Match(String tournament, Integer year, String round, String pwon, String plost, String referee, String atp)
	{
		this.tournament = new SimpleStringProperty(tournament);
		this.year = new SimpleIntegerProperty(year);
		this.round = new SimpleStringProperty(round);
		this.pwon = new SimpleStringProperty(pwon);
		this.plost = new SimpleStringProperty(plost);
		this.referee = new SimpleStringProperty(referee);
		this.atp = new SimpleStringProperty(atp);
	}

	public String getTournament() {
		return tournament.get();
	}

	public Integer getYear() {
		return year.get();
	}

	public String getRound() {
		return round.get();
	}

	public String getPwon() {
		return pwon.get();
	}

	public String getPlost() {
		return plost.get();
	}

	public String getReferee() {
		return referee.get();
	}

	public String getAtp() {
		return atp.get();
	}

	public void setTournament(String tournament) {
		this.tournament.set(tournament);;
	}

	public void setYear(Integer year) {
		this.year.set(year);;
	}

	public void setRound(String round) {
		this.round.set(round);;
	}

	public void setPwon(String pwon) {
		this.pwon.set(pwon);;
	}

	public void setPlost(String plost) {
		this.plost.set(plost);;
	}

	public void setReferee(String referee) {
		this.referee.set(referee);;
	}

	public void setAtp(String atp) {
		this.atp.set(atp);;
	}
	
	
}
