package com.iiitd;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;

public class RefereeController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/atp";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "puchku";

    @FXML
    private ComboBox<String> country;

    @FXML
    private TableColumn<Referee,Integer> cmatches;

    @FXML
    private ComboBox<String> player1;

    @FXML
    private Button apply;

    @FXML
    private ComboBox<String> player2;

    @FXML
    private TableColumn<Referee,String> cname;

    @FXML
    private Button back;

    @FXML
    private ComboBox<String> tournament;

    @FXML
    private ComboBox<String> court;

    @FXML
    private ComboBox<Integer> year1;

    @FXML
    private ComboBox<Integer> year2;

    @FXML
    private TableView<?> refereetable;

    @FXML
    private DatePicker dob2;

    @FXML
    private DatePicker dob1;

    @FXML
    private ComboBox<String> name;

    @FXML
    private TableColumn<Referee,String> ccountry;

    @FXML
    private TableColumn<Referee,LocalDate> cdob;
    
    static ArrayList<Referee> listed = new ArrayList<Referee>();
    static ObservableList data;
    
    private ObservableList getData(){
    	
    	ObservableList data = FXCollections.observableList(listed);
		return data;
    	
    }
    
    @FXML
    void entry(ActionEvent event){
    	name.getItems().removeAll(name.getItems());
		country.getItems().removeAll(country.getItems());
		court.getItems().removeAll(court.getItems());
		tournament.getItems().removeAll(tournament.getItems());
		year1.getItems().removeAll(year1.getItems());
		year2.getItems().removeAll(year2.getItems());
		player1.getItems().removeAll(player1.getItems());
		player2.getItems().removeAll(player2.getItems());
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT distinct RefereeName FROM referee";
			rs = statement.executeQuery(query);
			name.getItems().removeAll(name.getItems());
			while (rs.next()) {
				String refer = "";
				refer = rs.getString("RefereeName");
				name.getItems().addAll(refer);
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
			String query = "SELECT country from referee";
			rs = statement.executeQuery(query);
			country.getItems().removeAll(country.getItems());
			while (rs.next()) {
				String refcount = "";
				refcount = rs.getString("Country");
				country.getItems().addAll(refcount);

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
			String query1 = "SELECT distinct Tourname from matches";
			rs = statement.executeQuery(query1);
			tournament.getItems().removeAll(tournament.getItems());
			while (rs.next()) {
				String proness = "";
				proness = rs.getString("Tourname");
				tournament.getItems().addAll(proness);
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
			String query1 = "SELECT distinct tPlayerWon from matches";
			rs = statement.executeQuery(query1);
			player1.getItems().removeAll(player1.getItems());
			while (rs.next()) {
				String yo = "";
				yo = rs.getString("tPlayerWon");
				player1.getItems().addAll(yo);
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
			String query1 = "SELECT distinct tPlayerLost from matches";
			rs = statement.executeQuery(query1);
			player2.getItems().removeAll(player2.getItems());
			while (rs.next()) {
				String yeah = "";
				yeah = rs.getString("tPlayerLost");
				player2.getItems().addAll(yeah);
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
		court.getItems().addAll("Hard", "Clay","Grass");
    }
    
    String rname;
    String rround;
    String rcourt;
    String rcountry;
    int ryear;
    String rtournament;
    int ryr;
    String rwon;
    String rlost;
    LocalDate localDate;
	LocalDate localDate1;
    
    @FXML
    void filter(ActionEvent event) {
    	if(name.getValue()!=null){
    		rname=name.getValue();
    	}
    	else
    		rname="%";
    	if(court.getValue()!=null){
    		rcourt=court.getValue();
    	}
    	else
    		rcourt="%";
    	if(country.getValue()!=null){
    		rcountry=country.getValue();
    	}
    	else
    		rcountry="%";
    	System.out.println("adsihvoefvj");
    	if(tournament.getValue()!=null){
    		rtournament=tournament.getValue();
    	}
    	else
    		rtournament="%";
    	if(year1.getValue()!=null){
    		ryear=year1.getValue();
    	}
    	else{
    		ryear=1950;
    	}
    	if(year2.getValue()!=null){
    		ryr=year2.getValue();
    	}
    	else
    		ryr=2020;
    	if(player1.getValue()!=null){
    		rwon=player1.getValue();
    	}
    	else{
    		rwon="%";
    	}
    	
    	if(player2.getValue()!=null){
    		rlost=player2.getValue();
    	}
    	else
    		rlost="%";
    	
    	if(dob1.getValue()!=null)
    		localDate=dob1.getValue();
    	else
    	{
    		localDate=LocalDate.now().minus(109500, ChronoUnit.DAYS);
    	}
    	if(dob2.getValue()!=null)
    		localDate1=dob2.getValue();
    	else
    	{
    		localDate1=LocalDate.now();
    	}
    	
    	
    	Date date1 = java.sql.Date.valueOf(localDate);
    	Date date2 = java.sql.Date.valueOf(localDate1);
    	
    	
    	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT RefereeName,dob,Country,count(*) as mansi FROM referee,matches,tournament where RefereeName=Tref and TournamentName=Tourname and RefereeName like '%" + rname + "%' and " +  "Country like '%" 
			+ rcountry + "%' and " +  "CourtType like '%" + rcourt + "%' and " + "Tourname like '%" + rtournament + "%' and " + "tyear >= " + ryear + " and tyear <= " + ryr + " and " + "tPlayerWon like '%" + rwon + "%' and " + "tPlayerLost like '%" + rlost + "%' and " 
			+ "dob >= date('"+date1+"') and DOB<=date('"+date2+"') group by RefereeName";
			rs = statement.executeQuery(query);
			System.out.println("woefhciuowhdc");
			listed = new ArrayList<Referee>();
			while (rs.next()) {
				String yo = "";
				String mo = "";
				String to = "";
				java.sql.Date lo;
				String bo = "";
				String co = "";
				int so;
				yo = rs.getString("RefereeName");
				so = rs.getInt("mansi");
				mo = rs.getString("Country");
				lo = rs.getDate("dob");
				bo=lo.toString();
				LocalDate l1 = LocalDate.parse(bo);
				System.out.println(yo + " " + lo + " " + mo + " " + so);
				listed.add(new Referee(yo,l1,mo,so));
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
		
		data = FXCollections.observableList(listed);
		cname.setCellValueFactory(
				new PropertyValueFactory<Referee,String>("name")
		);
		cdob.setCellValueFactory(
				new PropertyValueFactory<Referee,LocalDate>("dob")
		);
		ccountry.setCellValueFactory(
				new PropertyValueFactory<Referee,String>("country")
		);
		cmatches.setCellValueFactory(
				new PropertyValueFactory<Referee,Integer>("matches")
		);
		//data = getData();
		refereetable.setItems(data);
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

