package com.iiitd;
import java.sql.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.Date;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.iiitd.Main;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;

public class AdminController {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/atp";

	   //  Database credentials
	static final String USER = "root";
	static final String PASS = "Jagdishiya1";

    @FXML
    private DatePicker csince;

    @FXML
    private ComboBox<?> cplayer;

    @FXML
    private TextField rname;

    @FXML
    private Button padd;

    @FXML
    private TextField cname;

    @FXML
    private ComboBox<Integer> ppro;

    @FXML
    private ComboBox<?> mname;

    @FXML
    private ComboBox<String> tcourt;

    @FXML
    private Button logout;

    @FXML
    private ComboBox<?> myear;

    @FXML
    private Button radd1;

    @FXML
    private ComboBox<?> mplost;

    @FXML
    private DatePicker cdob;

    @FXML
    private Button radd;

    @FXML
    private Button tadd;

    @FXML
    private ComboBox<?> mreferee;

    @FXML
    private Button sadd1;

    @FXML
    private TextField pname;

    @FXML
    private Button madd;

    @FXML
    private ComboBox<?> mpwon;

    @FXML
    private TextField tname;

    @FXML
    private ComboBox<Integer> tyear;

    @FXML
    private Button madd1;

    @FXML
    private Button cadd;

    @FXML
    private DatePicker rdob;

    @FXML
    private DatePicker ctill;

    @FXML
    private DatePicker pdob;

    @FXML
    private Button cadd1;

    @FXML
    private Button tadd1;

    @FXML
    private ComboBox<String> ppoints;

    @FXML
    private TextField sname;

    @FXML
    private Button padd1;

    @FXML
    private ComboBox<String> tcategory;

    @FXML
    private ComboBox<?> ccountry;

    @FXML
    private ComboBox<?> rcountry;

    @FXML
    private ComboBox<?> mround;

    @FXML
    private Button sadd;

    @FXML
    private ComboBox<String> pcountry;

    @FXML
    private ComboBox<Integer> syear;

    @FXML
    private ComboBox<String> splayer;

    @FXML
    void lout(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Welcome.fxml"));
		Scene scene=new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Hello There");
		Main.stage.show();
    }
    
    @FXML
    void player(Event event){
    	pcountry.getItems().addAll(
    			"USA","Afghanistan","Albania","Algeria","Andorra","Angola",
    			"Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain",
    			"Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivia","Bosnia Herzegovina","Botswana","Brazil",
    			"Brunei","Bulgaria","Burkina","Burma","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","People's Republic of China",
    			"Republic of China","Colombia","Comoros","Democratic Republic of the Congo","Republic of the Congo","Costa Rica",
    			"Croatia","Cuba","Cyprus","Czech Republic","Danzig","Denmark","Djibouti","Dominica","Dominican Republic","East Timor","Ecuador","Egypt",
    			"El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gaza Strip","The Gambia","Georgia","Germany","Ghana","Greece",
    			"Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Holy Roman Empire","Honduras","Hungary","Iceland","India","Indonesia","Iran","Iraq",
    			"Republic of Ireland","Israel","Italy","Ivory Coast","Jamaica","Japan","Jonathanland","Jordan","Kazakhstan","Kenya","Kiribati","North Korea","South Korea","Kosovo",
    			"Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives",
    			"Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Morocco","Mount Athos","Mozambique","Namibia","Nauru",
    			"Nepal","Newfoundland","Netherlands","New Zealand","Nicaragua","Niger","Nigeria","Norway","Oman","Ottoman Empire","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru",
    			"Philippines","Poland","Portugal","Prussia","Qatar","Romania","Rome","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia","Saint Vincent & the","Grenadines","Samoa","San Marino",
    			"Sao Tome & Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","Spain","Sri Lanka","Sudan",
    			"Suriname","Swaziland","Sweden","Switzerland","Syria","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago","Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine",
    			"United Arab Emirates","United Kingdom","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen","Zambia","Zimbabwe");
    	ppoints.getItems().addAll("1000","2000","3000","4000");
    	ppro.getItems().addAll(2010,2009,2008, 2007, 2006,      2005,      2004,      2003,      2002,      2001,      2000,      1999,      1998,      1997,      1996,      1995,      1994,      1993,      1992,      1991,      1990);
    }
    
    String yes = "";
    String country = "";
    int points;
    int year;
    @FXML
    void addp(ActionEvent event) {
    	Connection conn = null;
    	Statement stmt = null;
    	try{
    	Class.forName("com.mysql.jdbc.Driver");
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	stmt = conn.createStatement();
    	yes = yes + pname.getText();
    	country = country + pcountry.getValue();
    	LocalDate localDate = pdob.getValue();
    	Date date = java.sql.Date.valueOf(localDate);
        points=Integer.parseInt(ppoints.getValue());
        year = ppro.getValue();
        String sql = "INSERT INTO player " + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString (1, yes);
        preparedStmt.setString (2, country);
        preparedStmt.setDate   (3, (java.sql.Date) date);
        preparedStmt.setInt(4, points);
        preparedStmt.setInt (5, year);
        preparedStmt.execute();
        System.out.println(pname.getText() + " " + country + " " + localDate + " " + points + " " + year);
    	}
    	catch(SQLException se){
    	      //Handle errors for JDBC
    	      se.printStackTrace();
    	   }
    	catch(Exception e){
    	      //Handle errors for Class.forName
    	      e.printStackTrace();}
    	finally{
    	      //finally block used to close resources
    	      try{
    	         if(stmt!=null)
    	            conn.close();
    	      }catch(SQLException se){
    	      }// do nothing
    	      try{
    	         if(conn!=null)
    	            conn.close();
    	      }
    	      catch(SQLException se){
    	         se.printStackTrace();
    	      }//end finally try
    	   }
    }

    @FXML
    void addp1(ActionEvent event) {
    	pname.setText("");
    	pcountry.valueProperty().set("");
    	pdob.setValue(null);
    	ppoints.setValue("");
    	ppro.setValue(null);
    }

    @FXML
    void addm(ActionEvent event) {

    }

    @FXML
    void addm1(ActionEvent event) {

    }

    @FXML
    void addc(ActionEvent event) {

    }

    @FXML
    void addc1(ActionEvent event) {

    }

    @FXML
    void addr(ActionEvent event) {

    }

    @FXML
    void addr1(ActionEvent event) {

    }
    
    @FXML
    void sponsor(Event event){
    	ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
        try {  
        	Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
            String query = "SELECT Name FROM player";
            rs = statement.executeQuery(query);
            if (rs.next()) {
            	String sponsplayer = "";
            	sponsplayer = rs.getString(1);
                splayer.getItems().add(sponsplayer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            catch (Exception e) {
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
        syear.getItems().addAll(2010,2009,2008, 2007, 2006,      2005,      2004,      2003,      2002,      2001,      2000,      1999,      1998,      1997,      1996,      1995,      1994,      1993,      1992,      1991,      1990);
    }
    
    String sName = "";
    String sponsplay = "";
    int contract;
    
    @FXML
    void adds(ActionEvent event) {
    	Connection conn = null;
    	Statement stmt = null;
    	try{
    	Class.forName("com.mysql.jdbc.Driver");
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	stmt = conn.createStatement();
    	sName= sname.getText();
    	sponsplay = splayer.getValue();
    	contract = syear.getValue();
        String sql = "INSERT INTO sponsor " + "VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString (1, sName);
        preparedStmt.setString (2, sponsplay);
        preparedStmt.setInt(3, contract);
        preparedStmt.execute();
//        System.out.println(pname.getText() + " " + country + " " + localDate + " " + points + " " + year);
    	}
    	catch(SQLException se){
    	      //Handle errors for JDBC
    	      se.printStackTrace();
    	   }
    	catch(Exception e){
    	      //Handle errors for Class.forName
    	      e.printStackTrace();}
    	finally{
    	      //finally block used to close resources
    	      try{
    	         if(stmt!=null)
    	            conn.close();
    	      }catch(SQLException se){
    	      }// do nothing
    	      try{
    	         if(conn!=null)
    	            conn.close();
    	      }
    	      catch(SQLException se){
    	         se.printStackTrace();
    	      }//end finally try
    	   }
    }

    @FXML
    void adds1(ActionEvent event) {
    	sname.setText("");
    	splayer.valueProperty().set("");
    	syear.setValue(null);
    }
    
    @FXML
    void tournament(Event event){
    	tcourt.getItems().addAll("Hard","Grass","Clay");
    	tcategory.getItems().addAll("Grand Slam","ATP 1000","ATP 500");
    	tyear.getItems().addAll(2010,2009,2008, 2007, 2006,      2005,      2004,      2003,      2002,      2001,      2000,      1999,      1998,      1997,      1996,      1995,      1994,      1993,      1992,      1991,      1990);
    }
    
    String tName = "";
    String tCourt = "";
    String tCategory = "";
    int tYear;
    
    @FXML
    void addt(ActionEvent event) {
    	Connection conn = null;
    	Statement stmt = null;
    	try{
    	Class.forName("com.mysql.jdbc.Driver");
    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
    	stmt = conn.createStatement();
    	tName = tName + tname.getText();
    	tCategory = tCategory + tcategory.getValue();
    	tCourt = tCourt + tcourt.getValue();
        tYear = tyear.getValue();
        String sql = "INSERT INTO tournament " + "VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStmt = conn.prepareStatement(sql);
        preparedStmt.setString (1, tName);
        preparedStmt.setString (3, tCategory);
        preparedStmt.setString (2, tCourt);
        preparedStmt.setInt(4, tYear);
        preparedStmt.execute();
//        System.out.println(pname.getText() + " " + country + " " + localDate + " " + points + " " + year);
    	}
    	catch(SQLException se){
    	      //Handle errors for JDBC
    	      se.printStackTrace();
    	   }
    	catch(Exception e){
    	      //Handle errors for Class.forName
    	      e.printStackTrace();}
    	finally{
    	      //finally block used to close resources
    	      try{
    	         if(stmt!=null)
    	            conn.close();
    	      }catch(SQLException se){
    	      }// do nothing
    	      try{
    	         if(conn!=null)
    	            conn.close();
    	      }
    	      catch(SQLException se){
    	         se.printStackTrace();
    	      }//end finally try
    	   }
    }
    
    @FXML
    void addt1(ActionEvent event) {
    	tname.setText("");
    	tcourt.valueProperty().set("");
    	tcategory.setValue("");
    	tyear.setValue(null);
    }

}

