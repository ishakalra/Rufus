package com.iiitd;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SponsorController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/atp";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "puchku";

    @FXML
    private ComboBox<String> country;

    @FXML
    private TableColumn<?, ?> cplayer;

    @FXML
    private Button apply;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private Button back;

    @FXML
    private TextField atp2;

    @FXML
    private TextField atp1;

    @FXML
    private TextField title1;

    @FXML
    private TextField title2;

    @FXML
    private ComboBox<String> tournament;

    @FXML
    private TableColumn<?, ?> cyear;

    @FXML
    private ComboBox<Integer> year1;

    @FXML
    private ComboBox<Integer> year2;

    @FXML
    private TableColumn<?, ?> catp;

    @FXML
    private TableColumn<?, ?> ctitle;

    @FXML
    private ComboBox<String> name;

    @FXML
    private Button entryb;

    @FXML
    private TableColumn<?, ?> ccountry;

    @FXML
    private TableView<?> sponsortable;

    @FXML
    private ComboBox<String> player;
    
    @FXML
    void entry(ActionEvent event) {
    	name.getItems().removeAll(name.getItems());
		player.getItems().removeAll(player.getItems());
		country.getItems().removeAll(country.getItems());
		tournament.getItems().removeAll(tournament.getItems());
		year1.getItems().removeAll(year1.getItems());
		year2.getItems().removeAll(year2.getItems());
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT SponsorName FROM sponsor";
			rs = statement.executeQuery(query);
			name.getItems().removeAll(name.getItems());
			while (rs.next()) {
				String cool = "";
				cool = rs.getString("SponsorName");
				name.getItems().addAll(cool);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT DISTINCT PlayerSponsored FROM sponsor";
			rs = statement.executeQuery(query);
			player.getItems().removeAll(player.getItems());
			while (rs.next()) {
				String cool = "";
				cool = rs.getString("PlayerSponsored");
				player.getItems().addAll(cool);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT DISTINCT Country FROM player";
			rs = statement.executeQuery(query);
			country.getItems().removeAll(country.getItems());
			while (rs.next()) {
				String cool = "";
				cool = rs.getString("Country");
				country.getItems().addAll(cool);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT TournamentName FROM tournament";
			rs = statement.executeQuery(query);
			tournament.getItems().removeAll(tournament.getItems());
			while (rs.next()) {
				String cool = "";
				cool = rs.getString("TournamentName");
				tournament.getItems().addAll(cool);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		year1.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990);
		year2.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990);
    }
    
    String pname;
    String sname;
    String pcountry;
    String ptour;
    String round;
    int pts1;
    int pts2;
	int syear1;
	int syear2;
	int t1;
	int t2;

    @FXML
    void filter(ActionEvent event) {
    	
    	System.out.println("hello");
    	if(player.getValue()!=null){
    		pname=player.getValue();
    	}
    	else
    		pname="%";
    	
    	System.out.println("2");
    	if(name.getValue()!=null){
    		sname=name.getValue();
    	}
    	else
    		sname="%";
    	if(country.getValue()!=null)
    		pcountry=country.getValue();
    	else
    		pcountry="%";
    	if(tournament.getValue()!=null){
    		ptour=tournament.getValue();
    	}
    	else{
    		ptour="%";
    	}
    	
    	System.out.println("3");
    	
    	if(atp1.getText().equals(""))
    		pts1=0;
    	else
    		pts1=Integer.parseInt(atp1.getText());
    	if(atp2.getText().equals(""))
    		pts2=20000;
    	else
    		pts2=Integer.parseInt(atp2.getText());
    	
    	if(year1.getValue()!=null)
    		syear1=year1.getValue();
    	else
    		syear1=1980;
    	
    	System.out.println("4");
    	if(year2.getValue()!=null)
    		syear2=year2.getValue();
    	else
    		syear2=2020;
    	
    		
    	System.out.println("5");
    		
    		
    	
    	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		System.out.println("hoolala");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT DISTINCT SponsorName,Country,PlayerSponsored,ATPPoints,ContractYear FROM sponsor,player,matches where SponsorName like '%" + sname + "%' and PlayerSponsored=Name and PlayerSponsored like '%" + pname + "%' and " + "Country like '%" + pcountry + "%' and " +"ATPPoints between " + pts1 +
					" and " + pts2 + " and Tourname like '%" + ptour + "%' and ContractYear between " + syear1 + " and " + syear2  ;
			
			rs = statement.executeQuery(query);

			System.out.println("opwqajfeiorhgke'whgriuo52hrpoew'ifhguo3rhg'j");
		
			while (rs.next()) {
				String yo = "";
				String mo = "";
				String to = "";
				String lo = "";
				int so,la,ka;
				
				int ti;
				System.out.println("Yolo");
				yo = rs.getString("Sponsorname");
				mo = rs.getString("PlayerSponsored");
				to = rs.getString("Country");
				la = rs.getInt("ContractYear");
				ka = rs.getInt("ATPPoints");
				
				System.out.println("hola");
				System.out.println(yo + " " + mo + " " + to + " " + la + " " + ka);
			}
			
		} catch (SQLException e) {
			System.out.println("wkehferiofh");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ndcfwejl");
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
    	
    	
    }

    @FXML
    void backb(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Welcome.fxml"));
		Scene scene = new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Welcome to Rufus!");
		Main.stage.show();
    }

}

