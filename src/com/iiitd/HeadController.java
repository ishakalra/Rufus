package com.iiitd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class HeadController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/atp";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "puchku";
	
	static HashMap<String, Integer> hash = new HashMap<String, Integer>();

    @FXML
    private Label match2;

    @FXML
    private Label match1;

    @FXML
    private Label country1;

    @FXML
    private Label title1;
    
    @FXML
    private Button entryb;

    @FXML
    private Button backb;

    @FXML
    private Label title2;

    @FXML
    private PieChart pie;

    @FXML
    private Label country2;

    @FXML
    private Button filter;

    @FXML
    private Label dob2;

    @FXML
    private Label dob1;

    @FXML
    private Label atp2;

    @FXML
    private Label atp1;

    @FXML
    private Label head1;

    @FXML
    private Label head2;

    @FXML
    private ComboBox<String> name2;

    @FXML
    private ComboBox<String> name1;
    
    @FXML
    void entry(ActionEvent event) {
    	name1.getItems().removeAll(name1.getItems());
    	name2.getItems().removeAll(name2.getItems());
    	
    	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT Name FROM player";
			rs = statement.executeQuery(query);
			name1.getItems().removeAll(name1.getItems());
			while (rs.next()) {
				String Player = "";
				Player = rs.getString("Name");
				name1.getItems().addAll(Player);
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
			String query = "SELECT Name FROM player";
			rs = statement.executeQuery(query);
			name2.getItems().removeAll(name2.getItems());
			while (rs.next()) {
				String Player = "";
				Player = rs.getString("Name");
				name2.getItems().addAll(Player);
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
    }

    String pname1;
    String pname2;
    
    @FXML
    void apply(ActionEvent event) {
    	String bdob1="", bdob2="", count1="", count2="", pnt1="", pnt2="", m1="", m2="", t1="", t2="", h1="", h2="";
    	pname1 = name1.getValue();
    	pname2 = name2.getValue();
    	
    	ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT Name,Country,ATPPoints,DOB FROM player WHERE Name like '%" + pname1 +"%'";
			rs = statement.executeQuery(query);
			if(!rs.next()){
				System.out.println("bekaaarrrr");
			}
			Date e;
			e = rs.getDate("DOB");
			System.out.println(e);
			bdob1 = rs.getDate("DOB").toString();
			count1 = rs.getString("Country");
			pnt1 = String.valueOf(rs.getInt("ATPPoints"));
			System.out.println("Player1 "+pname1+" "+bdob1+" "+count1+" "+pnt1);
					
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			System.out.println("reached");
			String query = "SELECT Name,Country,ATPPoints,DOB FROM player WHERE Name like '%" + pname2 +"%'";
			rs = statement.executeQuery(query);
			if(!rs.next()){
				System.out.println("bekaaarrrr");
			}
			count2 = rs.getString("Country");
			System.out.println("done");
			bdob2 = rs.getDate("DOB").toString();
			
			pnt2 = String.valueOf(rs.getInt("ATPPoints"));
			System.out.println("Player2 "+pname2+" "+bdob2+" "+count2+" "+pnt2);
					
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT count(*) AS mat1 FROM matches WHERE tPlayerWon like '%" + pname1 +"%'";
			rs = statement.executeQuery(query);
			if(!rs.next()){
				System.out.println("bekaaarrrr");
			}
			m1 = String.valueOf(rs.getInt("mat1"));
			System.out.println("match1 "+m1);
					
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT count(*) AS mat1 FROM matches WHERE tPlayerWon like '%" + pname2 +"%'";
			rs = statement.executeQuery(query);
			if(!rs.next()){
				System.out.println("bekaaarrrr");
			}
			m2 = String.valueOf(rs.getInt("mat1"));
			System.out.println("match2 "+m2);
					
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT count(*) AS mat1 FROM matches WHERE tPlayerWon like '%" + pname1 +"%' and tRound='Finals'";
			rs = statement.executeQuery(query);
			if(!rs.next()){
				System.out.println("bekaaarrrr");
			}
			t1 = String.valueOf(rs.getInt("mat1"));
			System.out.println("title1 "+t1);
					
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT count(*) AS mat1 FROM matches WHERE tPlayerWon like '%" + pname2 +"%' and tRound='Finals'";
			rs = statement.executeQuery(query);
			if(!rs.next()){
				System.out.println("bekaaarrrr");
			}
			t2 = String.valueOf(rs.getInt("mat1"));
			System.out.println("title2 "+t2);
					
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT count(*) AS mat1 FROM matches WHERE tPlayerWon like '%" + pname1 +"%' and tPlayerLost like '%" + pname2 + "%'";
			rs = statement.executeQuery(query);
			if(!rs.next()){
				System.out.println("bekaaarrrr");
			}
			h1 = String.valueOf(rs.getInt("mat1"));
			System.out.println("head1 "+h1);
					
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
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT count(*) AS mat1 FROM matches WHERE tPlayerWon like '%" + pname2 +"%' and tPlayerLost like '%" + pname1 + "%'";
			rs = statement.executeQuery(query);
			if(!rs.next()){
				System.out.println("bekaaarrrr");
			}
			h2 = String.valueOf(rs.getInt("mat1"));
			System.out.println("head2 "+h2);
					
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
		
		dob1.setText(bdob1);
		dob2.setText(bdob2);
		country1.setText(count1);
		country2.setText(count2);
		atp1.setText(pnt1);
		atp2.setText(pnt2);
		match1.setText(m1);
		match2.setText(m2);
		title1.setText(t1);
		title2.setText(t2);
		head1.setText(h1);
		head2.setText(h2);
		
		int he1 = Integer.parseInt(h1), he2 = Integer.parseInt(h2);
		hash = new HashMap<String, Integer>();
		hash.put(pname1, he1);
		hash.put(pname2, he2);
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		for (String key : hash.keySet()) {
		    pieChartData.add(new PieChart.Data(key, hash.get(key)));
		}
//		pieChartData.add(new PieChart.Data("Unspent", a));
        pie.setTitle("Head to Head");
        pie.setData(pieChartData);
		
    	
    }

    @FXML
    void back(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Welcome.fxml"));
		Scene scene = new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Welcome to Rufus!");
		Main.stage.show();
    }

}

