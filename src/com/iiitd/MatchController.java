package com.iiitd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MatchController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/atp";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "puchku";

    @FXML
    private TableColumn<Match, String> cround;

    @FXML
    private TableColumn<Match, String> clost;

    @FXML
    private Button apply;

    @FXML
    private ComboBox<Integer> year;

    @FXML
    private TableView<?> matchtable;

    @FXML
    private Button back;

    @FXML
    private ComboBox<Integer> tyear;

    @FXML
    private ComboBox<String> tournament;

    @FXML
    private TableColumn<Match, Integer> cyear;

    @FXML
    private ComboBox<String> referee;

    @FXML
    private ComboBox<String> court;

    @FXML
    private ComboBox<String> round;

    @FXML
    private TableColumn<Match, String> catp;

    @FXML
    private ComboBox<String> name2;

    @FXML
    private TableColumn<Match, String> creferee;

    @FXML
    private ComboBox<String> name1;

    @FXML
    private TableColumn<Match, String> cwon;

    @FXML
    private TableColumn<Match, String> ctournament;
    
    static ArrayList<Match> listed = new ArrayList<Match>();
    static ObservableList data;
    
    private ObservableList getData(){
    	
    	ObservableList data = FXCollections.observableList(listed);
		return data;
    	
    }
    
    @FXML
    void entry(ActionEvent event){
    	tournament.getItems().removeAll(tournament.getItems());
		round.getItems().removeAll(round.getItems());
		tyear.getItems().removeAll(tyear.getItems());
		referee.getItems().removeAll(referee.getItems());
		court.getItems().removeAll(court.getItems());
		year.getItems().removeAll(year.getItems());
		name1.getItems().removeAll(name1.getItems());
		name2.getItems().removeAll(name2.getItems());
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT distinct Tourname FROM matches";
			rs = statement.executeQuery(query);
			tournament.getItems().removeAll(tournament.getItems());
			while (rs.next()) {
				String tour = "";
				tour = rs.getString("Tourname");
				tournament.getItems().addAll(tour);
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
			String query = "SELECT distinct Tref from matches";
			rs = statement.executeQuery(query);
			referee.getItems().removeAll(referee.getItems());
			while (rs.next()) {
				String refboy = "";
				refboy = rs.getString("Tref");
				referee.getItems().addAll(refboy);

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
			name1.getItems().removeAll(name1.getItems());
			while (rs.next()) {
				String won = "";
				won = rs.getString("tPlayerWon");
				name1.getItems().addAll(won);
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
			name2.getItems().removeAll(name2.getItems());
			while (rs.next()) {
				String lost = "";
				lost = rs.getString("tPlayerLost");
				name2.getItems().addAll(lost);
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
		
		
		round.getItems().addAll("Finals","Semifinals","Quarterfinals","Pre-quarterfinals");
		tyear.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990 , 1989 , 1988 , 1987 , 1986 , 1985 , 1984 , 1983 , 1982 , 1981 , 1980 , 1979 , 1978 , 1977 , 1976 , 
				1975 , 1974 , 1973 , 1972 , 1971 , 1970 , 1969 , 1968 , 1967 , 1966 , 1965 , 1964 , 1963 , 1962 , 1961 , 1960 , 1959 , 1958 , 1957 , 1956 , 1955 , 
				1954 , 1953 , 1952 , 1951 , 1950 , 1949 , 1948 , 1947 , 1946 , 1945 , 1944 , 1943 , 1942 , 1941 , 1940 , 1939 , 1938 , 1937 , 1936 , 1935 , 1934 , 1933 , 
				1932 , 1931 , 1930 , 1929 , 1928 , 1927 , 1926 , 1925 , 1924 , 1923 , 1922 , 1921 , 1920 , 1919 , 1918 , 1917 , 1916 , 1915 , 1914 , 1913 , 1912 , 
				1911 , 1910 , 1909 , 1908 , 1907 , 1906 , 1905 , 1904 , 1903 , 1902 , 1901 , 1900 , 1899 , 1898 , 1897 , 1896 , 1895 , 1894 , 1893 , 1892 , 1891 , 1890 , 
				1889 , 1888 , 1887 , 1886 , 1885 , 1884 , 1883 , 1882 , 1881, 1880, 1879, 1878, 1877, 1876, 1875);
		year.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990);
		court.getItems().addAll("Hard", "Clay","Grass");
    }
    
    String mname;
    String mround;
    String mcourt;
    String myear;
    String mreferee;
    String myr;
    String mwon;
    String mlost;
    int ayush1, ayush2;
    int mansi1, mansi2;
    
    @FXML
    void filter(ActionEvent event) {
    	if(tournament.getValue()!=null){
    		mname=tournament.getValue();
    	}
    	else
    		mname="%";
    	if(court.getValue()!=null){
    		mcourt=court.getValue();
    	}
    	else
    		mcourt="%";
    	if(round.getValue()!=null){
    		mround=round.getValue();
    	}
    	else
    		mround="%";
    	if(year.getValue()!=null){
    		myear=year.getValue().toString();
    		ayush1 = Integer.parseInt(myear);
    		ayush2 = ayush1;
    	}
    	else{
    		ayush1=1990;
    		ayush2=2015;
    	}
    	if(referee.getValue()!=null){
    		mreferee=referee.getValue();
    	}
    	else
    		mreferee="%";
    	if(tyear.getValue()!=null){
    		myr=tyear.getValue().toString();
    		mansi1 = Integer.parseInt(myr);
    		mansi2 = mansi1;
    	}
    	else{
    		mansi1 = 1850;
    		mansi2 = 2020;
    	}
    		
    	if(name1.getValue()!=null){
    		mwon=name1.getValue();
    	}
    	else
    		mwon="%";
    	if(name2.getValue()!=null){
    		mlost=name2.getValue();
    	}
    	else
    		mlost="%";
    	
    	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT Tourname,tRound,Tref,CourtType,tyear,tPlayerWon,tPlayerLost FROM tournament,matches where Tourname=TournamentName and Tourname like '%" + mname + "%' and " +  "CourtType like '%" 
			+ mcourt + "%' and " +  "tRound like '%" + mround + "%' and " + "tyear >= " + ayush1 + " and tyear <= " + ayush2 + " and " + "Tref like '%" + mreferee + "%' and " + "tPlayerWon like '%" + mwon + "%' and " 
			+ "tPlayerLost like '%" + mlost + "%' and " + "YearBegin >= " + mansi1 + " and YearBegin <= " + mansi2;
			rs = statement.executeQuery(query);
			
			listed = new ArrayList<Match>();
			while (rs.next()) {
				String yo = "";
				String mo = "";
				String to = "";
				String lo = "";
				String bo = "";
				String co = "";
				int so;
				yo = rs.getString("Tourname");
				mo = rs.getString("tRound");
				to = rs.getString("Tref");
				lo = rs.getString("CourtType");
				bo = rs.getString("tPlayerWon");
				co = rs.getString("tPlayerLost");
				so = rs.getInt("tyear");
				
				System.out.println(yo + " " + mo + " " + to + " " + lo + " " + bo + " " + co + " " + so);
				listed.add(new Match(yo,so,mo,bo,co,to,lo));
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
		ctournament.setCellValueFactory(
				new PropertyValueFactory<Match,String>("tournament")
		);
		cyear.setCellValueFactory(
				new PropertyValueFactory<Match,Integer>("year")
		);
		cround.setCellValueFactory(
				new PropertyValueFactory<Match,String>("round")
		);
		cwon.setCellValueFactory(
				new PropertyValueFactory<Match,String>("pwon")
		);
		clost.setCellValueFactory(
				new PropertyValueFactory<Match,String>("plost")
		);
		creferee.setCellValueFactory(
				new PropertyValueFactory<Match,String>("referee")
		);
		catp.setCellValueFactory(
				new PropertyValueFactory<Match,String>("atp")
		);
		
		//data = getData();
		matchtable.setItems(data);
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