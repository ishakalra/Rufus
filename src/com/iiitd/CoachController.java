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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CoachController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/atp";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "puchku";

    @FXML
    private ComboBox<String> country;

    @FXML
    private TableView<?> coachtable;

    @FXML
    private TableColumn<?, ?> csince;

    @FXML
    private TableColumn<?, ?> cplayer;

    @FXML
    private Button apply;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private Button back;

    @FXML
    private DatePicker contract2;

    @FXML
    private ComboBox<Integer> pro1;

    @FXML
    private ComboBox<Integer> pro2;

    @FXML
    private TableColumn<?, ?> ctill;

    @FXML
    private DatePicker contract1;

    @FXML
    private ComboBox<String> cooachee;

    @FXML
    private DatePicker dob2;

    @FXML
    private ComboBox<String> coachee_country;

    @FXML
    private DatePicker dob1;

    @FXML
    private ComboBox<String> name;

    @FXML
    private TableColumn<?, ?> ccountry;

    @FXML
    private TableColumn<?, ?> cdob;
    
    @FXML
    private Button entryb;
    
    @FXML
    void entry(ActionEvent event) {
    	name.getItems().removeAll(name.getItems());
		cooachee.getItems().removeAll(cooachee.getItems());
		country.getItems().removeAll(country.getItems());
		coachee_country.getItems().removeAll(coachee_country.getItems());
		pro1.getItems().removeAll(pro1.getItems());
		pro2.getItems().removeAll(pro2.getItems());
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT CName FROM coach";
			rs = statement.executeQuery(query);
			name.getItems().removeAll(name.getItems());
			while (rs.next()) {
				String cool = "";
				cool = rs.getString("CName");
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
			String query = "SELECT DISTINCT coachee FROM coach";
			rs = statement.executeQuery(query);
			cooachee.getItems().removeAll(cooachee.getItems());
			while (rs.next()) {
				String cool = "";
				cool = rs.getString("coachee");
				cooachee.getItems().addAll(cool);
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
			String query = "SELECT Ccountry FROM coach";
			rs = statement.executeQuery(query);
			country.getItems().removeAll(country.getItems());
			while (rs.next()) {
				String cool = "";
				cool = rs.getString("Ccountry");
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
			String query = "SELECT Country FROM player";
			rs = statement.executeQuery(query);
			coachee_country.getItems().removeAll(coachee_country.getItems());
			while (rs.next()) {
				String cool = "";
				cool = rs.getString("Country");
				coachee_country.getItems().addAll(cool);
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
    }

    String pname;
    String pcountry;
    String came;
    String coachcountry;
    LocalDate localDate;
	LocalDate localDate1;
	LocalDate bdate1;
	LocalDate bdate2;
	int year1;
	int year2;
	
    @FXML
    void filter(ActionEvent event) {
    	if(name.getValue()!=null){
    		came=name.getValue();
    	}
    	else
    		came="%";
    	
    	if(coachee_country.getValue()!=null){
    		pcountry=coachee_country.getValue();
    	}
    	else
    		pcountry="%";
    	
    	if(cooachee.getValue()!=null){
    		pname=cooachee.getValue();
    	}
    	else
    		pname="%";
    	
    	if(country.getValue()!=null){
    		coachcountry=country.getValue();
    	}
    	else
    		coachcountry="%";
    	
    	if(pro1.getValue()!=null)
    		year1=pro1.getValue();
    	else
    		year1=1980;
    	if(pro2.getValue()!=null)
    		year2=pro2.getValue();
    	else
    		year2=2020;
    	
    	if(contract1.getValue()!=null)
    		localDate=contract1.getValue();
    	else
    	{
    		localDate=LocalDate.now().minus(109500, ChronoUnit.DAYS);
    	}
    	if(contract2.getValue()!=null)
    		localDate1=contract2.getValue();
    	else
    	{
    		localDate1=LocalDate.now();
    	}
    	
    	if(dob1.getValue()!=null)
    		bdate1=dob1.getValue();
    	else
    	{
    		bdate1=LocalDate.now().minus(109500, ChronoUnit.DAYS);
    	}
    	if(dob2.getValue()!=null)
    		bdate2=dob2.getValue();
    	else
    	{
    		bdate2=LocalDate.now();
    	}
    	
    	Date cdate1 = java.sql.Date.valueOf(localDate);
    	Date cdate2 = java.sql.Date.valueOf(localDate1); 
    	Date bidate1 = java.sql.Date.valueOf(bdate1);
    	Date bidate2 = java.sql.Date.valueOf(bdate2); 
    	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT CName,Ccountry,coachee,Cdob,CoachSince,CoachTill FROM coach,player where CName like '%" + came + "%' and coachee=Name and coachee like '%" + pname + "%' and " + "Country like '%" + pcountry + "%' and " + 
				"Ccountry like '%" + coachcountry + "%' and "+ " Cdob >= date('"+bidate1+"') and DOB<=date('"+bidate2+"') and CoachSince >= date('"+cdate1+"') and CoachTill <= date('"+cdate2+"') and YearPro between " + year1 + " and " + year2;
			
//			String query1 = "SELECT Name FROM player Where DOB between ? and ?";
//			String query1 = "SELECT * FROM player Where DOB>=date('"+date1+"') and DOB<=date('"+date2+"')";
//			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query1);
//			ps.setDate(1, (java.sql.Date) date1);
//			ps.setDate(2, (java.sql.Date) date1);
			rs = statement.executeQuery(query);
			System.out.println("opwqajfeiorhgke'whgriuo52hrpoew'ifhguo3rhg'j");
//			if(!rs.next())
//			{
//				System.out.println("cool");
//			}
			while (rs.next()) {
				String yo = "";
				String mo = "";
				String to = "";
				String lo = "";
				int so;
				Date la, ka, pa;
				int ti;
				System.out.println("Yolo");
				yo = rs.getString("Cname");
				mo = rs.getString("coachee");
				to = rs.getString("Ccountry");
				la = rs.getDate("Cdob");
				ka = rs.getDate("CoachSince");
				pa = rs.getDate("CoachTill");
				
				System.out.println("hola");
				System.out.println(yo + " " + mo + " " + to + " " + la + " " + ka + " " + pa);
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

