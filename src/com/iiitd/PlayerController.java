package com.iiitd;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.mysql.jdbc.PreparedStatement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PlayerController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/atp";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "puchku";

    @FXML
    private TextField match2;

    @FXML
    private ComboBox<String> country;

    @FXML
    private TextField match1;
    
    @FXML
    private TextField title1;

    @FXML
    private TextField title2;

    @FXML
    private TableColumn<?, ?> cpro;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private ComboBox<String> wont;

    @FXML
    private Button back;

    @FXML
    private ComboBox<String> court;

    @FXML
    private ComboBox<Integer> pro1;

    @FXML
    private DatePicker born2;

    @FXML
    private Button filter;

    @FXML
    private ComboBox<Integer> pro2;

    @FXML
    private DatePicker born1;
    
    @FXML
    private TableView<?> playertable;

    @FXML
    private TableColumn<?, ?> catp;

    @FXML
    private TableColumn<?, ?> ctitle;

    @FXML
    private ComboBox<String> name;

    @FXML
    private TableColumn<?, ?> ccountry;

    @FXML
    private TextField atp2;

    @FXML
    private TextField atp1;

    @FXML
    private TableColumn<?, ?> cdob;

    @FXML
    private TableColumn<?, ?> cmatch;
    
    @FXML
    void entry(ActionEvent event){
    	name.getItems().removeAll(name.getItems());
		court.getItems().removeAll(court.getItems());
		country.getItems().removeAll(country.getItems());
		wont.getItems().removeAll(wont.getItems());
		pro1.getItems().removeAll(pro1.getItems());
		pro2.getItems().removeAll(pro2.getItems());
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT Name FROM player";
			rs = statement.executeQuery(query);
			name.getItems().removeAll(name.getItems());
			while (rs.next()) {
				String Player = "";
				Player = rs.getString("Name");
				name.getItems().addAll(Player);
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
			String query = "SELECT Country FROM player";
			rs = statement.executeQuery(query);
			country.getItems().removeAll(country.getItems());
			while (rs.next()) {
				String Coun = "";
				Coun = rs.getString("Country");
				country.getItems().addAll(Coun);

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
			String query1 = "SELECT TournamentName FROM tournament";
			rs = statement.executeQuery(query1);
			wont.getItems().removeAll(wont.getItems());
			while (rs.next()) {
				String tour = "";
				tour = rs.getString("TournamentName");
				wont.getItems().addAll(tour);
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
		
		
		
		pro1.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990);
		pro2.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990);
		court.getItems().addAll("Hard", "Clay","Grass");
    }
    String pname;
    String pcourt;
    String pcountry;
    String ptour;
    int pts1;
    int pts2;
    LocalDate localDate;
	LocalDate localDate1;
	int matchwonbeg;
	int matchwonend;
	int year1;
	int year2;
	int numwonbeg;
	int numwonend;
	
    @FXML
    void apply(ActionEvent event) {
    	
    	System.out.println("wkdvjefiohvnwemkcroubgjwelnackvorebgjdcn");
//    	if((name.getValue().toString().length()!=0)&&(name.getValue().toString().length()!=0)
    	if(name.getValue()!=null){
    		pname=name.getValue();
    	}
    	else
    		pname="%";
    	if(court.getValue()!=null){
    		pcourt=court.getValue();
    	}
    	else
    		pcourt="%";
    	if(country.getValue()!=null)
    		pcountry=country.getValue();
    	else
    		pcountry="%";
    	if(wont.getValue()!=null)
    		ptour=wont.getValue();
    	else
    		ptour="%";
    	System.out.println("ayush is a ioewhfiuewfb");
    	if(atp1.getText().equals(""))
    		pts1=0;
    	else
    		pts1=Integer.parseInt(atp1.getText());
    	if(atp2.getText().equals(""))
    		pts2=20000;
    	else
    		pts2=Integer.parseInt(atp2.getText());
    	System.out.println("ayush is a ioewhfiuewfb");
    	if(born1.getValue()!=null)
    		localDate=born1.getValue();
    	else
    	{
    		localDate=LocalDate.now().minus(109500, ChronoUnit.DAYS);
    	}
    	if(born2.getValue()!=null)
    		localDate1=born2.getValue();
    	else
    	{
    		localDate1=LocalDate.now();
    	}
    	if(match1.getText().equals(""))
    		matchwonbeg=0;
    	else
    		matchwonbeg=Integer.parseInt(match1.getText());
    	if(match2.getText().equals(""))
    		matchwonend=2000;
    	else
    		matchwonend=Integer.parseInt(match2.getText());
    	if(pro1.getValue()!=null)
    		year1=pro1.getValue();
    	else
    		year1=1980;
    	if(pro2.getValue()!=null)
    		year2=pro2.getValue();
    	else
    		year2=2020;
//    	if(title1.getText().equals(""))
//    		numwonbeg=0;
//    	else
//    		numwonbeg=Integer.parseInt(title1.getText());
//    	if(title2.getText().equals(""))
//    		numwonend=50;
//    	else
//    		numwonend=Integer.parseInt(title2.getText());
    	System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyhfcnfedfhi;fr");
    	
    	Date date1 = java.sql.Date.valueOf(localDate);
    	Date date2 = java.sql.Date.valueOf(localDate1); 
    	
    	
    	System.out.println(date1+ " "+date2);
    	String d1 = localDate.toString();
//    	System.out.println(d1);
    	String d2 = localDate1.toString();
    	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT Name,Country,ATPPoints,DOB,YearPro FROM player,tournament,matches where Tourname=TournamentName and Name like '%" + pname + "%' and " +  "CourtType like '%" 
			+ pcourt + "%' and " +  "Country like '%" + pcountry + "%' and " + "TournamentName like '%" + ptour + "%' and " + "ATPPoints between " + pts1 +
					" and " + pts2 + " and DOB >= date('"+date1+"') and DOB<=date('"+date2+"') and YearPro between " + year1 + " and " + year2 + " and Name=tPlayerWon  group by Name having count(*) >= " + matchwonbeg +
					" and count(*) <= " + matchwonend;
			
//			String query1 = "SELECT Name FROM player Where DOB between ? and ?";
//			String query1 = "SELECT * FROM player Where DOB>=date('"+date1+"') and DOB<=date('"+date2+"')";
//			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query1);
//			ps.setDate(1, (java.sql.Date) date1);
//			ps.setDate(2, (java.sql.Date) date1);
			rs = statement.executeQuery(query);
			System.out.println("opwqajfeiorhgke'whgriuo52hrpoew'ifhguo3rhg'j");

			while (rs.next()) {
				String yo = "";
				String mo = "";
				String to = "";
				String lo = "";
				int so;
				Date la;
				int ti;
				System.out.println("Yolo");
				yo = rs.getString("Name");
//				mo = rs.getString("CourtType");
				to = rs.getString("Country");
//				lo = rs.getString("TournamentName");
				so = rs.getInt("ATPPoints");
				la = rs.getDate("DOB");
				ti = rs.getInt("YearPro");
				System.out.println("Yolo");
				System.out.println(la);
				System.out.println(yo + " " + to + " " + so + " " + la + " " + ti);
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
