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

	// Database credentials
	static final String USER = "root";
	static final String PASS = "puchku";

	@FXML
	private DatePicker csince;

	@FXML
	private ComboBox<String> cplayer;

	@FXML
	private TextField rname;

	@FXML
	private Button padd;

	@FXML
	private TextField cname;

	@FXML
	private ComboBox<Integer> ppro;

	@FXML
	private ComboBox<String> mname;

	@FXML
	private ComboBox<String> tcourt;

	@FXML
	private Button logout;

	@FXML
	private ComboBox<Integer> myear;

	@FXML
	private Button radd1;

	@FXML
	private ComboBox<String> mplost;

	@FXML
	private DatePicker cdob;

	@FXML
	private Button radd;

	@FXML
	private Button tadd;

	@FXML
	private ComboBox<String> mreferee;

	@FXML
	private Button sadd1;

	@FXML
	private TextField pname;

	@FXML
	private Button madd;

	@FXML
	private ComboBox<String> mpwon;

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
	private TextField ppoints;

	@FXML
	private TextField sname;

	@FXML
	private Button padd1;

	@FXML
	private ComboBox<String> tcategory;

	@FXML
	private ComboBox<String> ccountry;

	@FXML
	private ComboBox<String> rcountry;

	@FXML
	private ComboBox<String> mround;

	@FXML
	private Button sadd;

	@FXML
	private ComboBox<String> pcountry;

	@FXML
	private ComboBox<Integer> syear;

	@FXML
	private ComboBox<String> splayer;

	@FXML
	void lout(ActionEvent event) throws IOException {
		Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Welcome.fxml"));
		Scene scene = new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Hello There");
		Main.stage.show();
	}

	@FXML
	void player(Event event) {
		pcountry.getItems().removeAll(pcountry.getItems());
		ppro.getItems().removeAll(ppro.getItems());
		pcountry.getItems().addAll("USA", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps",
				"Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
				"Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina",
				"Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burma", "Burundi", "Cambodia", "Cameroon",
				"Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "People's Republic of China",
				"Republic of China", "Colombia", "Comoros", "Democratic Republic of the Congo", "Republic of the Congo",
				"Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Danzig", "Denmark", "Djibouti",
				"Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
				"Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gaza Strip", "The Gambia",
				"Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
				"Haiti", "Holy Roman Empire", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq",
				"Republic of Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jonathanland", "Jordan",
				"Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan",
				"Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
				"Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
				"Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro",
				"Morocco", "Mount Athos", "Mozambique", "Namibia", "Nauru", "Nepal", "Newfoundland", "Netherlands",
				"New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Ottoman Empire", "Pakistan", "Palau",
				"Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Prussia",
				"Qatar", "Romania", "Rome", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia",
				"Saint Vincent & the", "Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia",
				"Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia",
				"Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland",
				"Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga",
				"Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine",
				"United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City",
				"Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
		ppro.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997, 1996,
				1995, 1994, 1993, 1992, 1991, 1990);
	}

	

	@FXML
	void addp(ActionEvent event) {
		Connection conn = null;
		Statement stmt = null;
		try {
			String yes = "";
			String country = "";
			int points;
			int year;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			yes = yes + pname.getText();
			country = country + pcountry.getValue();
			LocalDate localDate = pdob.getValue();
			Date date = java.sql.Date.valueOf(localDate);
			points = Integer.parseInt(ppoints.getText());
			year = ppro.getValue();
			String sql = "INSERT INTO player " + "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, yes);
			preparedStmt.setString(2, country);
			preparedStmt.setDate(3, (java.sql.Date) date);
			preparedStmt.setInt(4, points);
			preparedStmt.setInt(5, year);
			preparedStmt.execute();
			System.out.println(pname.getText() + " " + country + " " + localDate + " " + points + " " + year);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

	@FXML
	void addp1(ActionEvent event) {
		pname.setText("");
		pcountry.valueProperty().set("");
		pdob.setValue(null);
		ppoints.setText("");
		ppro.setValue(null);
	}

	@FXML
	void mtc(Event event){
		myear.getItems().removeAll(myear.getItems());
		mround.getItems().removeAll(mround.getItems());
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT Name FROM player";
			rs = statement.executeQuery(query);
			mpwon.getItems().removeAll(mpwon.getItems());
			mplost.getItems().removeAll(mplost.getItems());
			while (rs.next()) {
				String PlayerWon = "";
				String PlayerLost = "";
				PlayerWon = rs.getString("Name");
				PlayerLost = rs.getString("Name");
				mpwon.getItems().addAll(PlayerWon);
				mplost.getItems().addAll(PlayerLost);

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
			mname.getItems().removeAll(mname.getItems());
			while (rs.next()) {
				String tour = "";
				tour = rs.getString("TournamentName");
				mname.getItems().addAll(tour);
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
			String query2 = "SELECT RefereeName FROM referee";
			rs = statement.executeQuery(query2);
			mreferee.getItems().removeAll(mreferee.getItems());
			while (rs.next()) {
				String refer = "";
				refer = rs.getString("RefereeName");
				mreferee.getItems().addAll(refer);
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
		
		myear.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990);
		mround.getItems().addAll("Quaterfinals","Semifinals","Finals");
	}
	
	
	
	@FXML
	void addm(ActionEvent event) {
		Connection conn = null;
		Statement stmt = null;
		try {
			String matchtour = "";
			String player1 = "";
			String player2 = "";
			int matchyear;
			String matchround = "";
			String matchref = "";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			matchtour = matchtour + mname.getValue();
			matchyear = myear.getValue();
			player1 = player1 + mpwon.getValue();
			player2 = player2 + mplost.getValue();
			matchround = matchround + mround.getValue();
			matchref = matchref+ mreferee.getValue();
			String sql = "INSERT INTO matches " + "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, matchtour);
			preparedStmt.setInt(2, matchyear);
			preparedStmt.setString(3, player1);
			preparedStmt.setString(4, player2);
			preparedStmt.setString(5, matchround);
			preparedStmt.setString(6, matchref);
			preparedStmt.execute();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

	@FXML
	void addm1(ActionEvent event) {
		mname.valueProperty().set("");
		mpwon.valueProperty().set("");
		mplost.valueProperty().set("");
		mround.valueProperty().set("");
		mreferee.valueProperty().set("");
		myear.setValue(null);
	}

	@FXML
	void coach(Event event) {
		ccountry.getItems().removeAll(ccountry.getItems());
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT Name FROM player";
			rs = statement.executeQuery(query);
			cplayer.getItems().removeAll(cplayer.getItems());
			while (rs.next()) {
				String coachee = "";
				coachee = rs.getString("Name");
				cplayer.getItems().addAll(coachee);

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
		ccountry.getItems().addAll("USA", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps",
				"Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
				"Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina",
				"Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burma", "Burundi", "Cambodia", "Cameroon",
				"Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "People's Republic of China",
				"Republic of China", "Colombia", "Comoros", "Democratic Republic of the Congo", "Republic of the Congo",
				"Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Danzig", "Denmark", "Djibouti",
				"Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
				"Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gaza Strip", "The Gambia",
				"Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
				"Haiti", "Holy Roman Empire", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq",
				"Republic of Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jonathanland", "Jordan",
				"Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan",
				"Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
				"Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
				"Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro",
				"Morocco", "Mount Athos", "Mozambique", "Namibia", "Nauru", "Nepal", "Newfoundland", "Netherlands",
				"New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Ottoman Empire", "Pakistan", "Palau",
				"Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Prussia",
				"Qatar", "Romania", "Rome", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia",
				"Saint Vincent & the", "Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia",
				"Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia",
				"Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland",
				"Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga",
				"Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine",
				"United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City",
				"Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
	}

	
	@FXML
	void addc(ActionEvent event) {
		Connection conn = null;
		Statement stmt = null;
		try {
			String coachname = "";
			String coachee = "";
			String coachcountry = "";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			coachname = coachname + cname.getText();
			coachcountry = coachcountry + ccountry.getValue();
			LocalDate localDate = cdob.getValue();
			LocalDate localDate1 = csince.getValue();
			LocalDate localDate2 = ctill.getValue();
			coachee = coachee + cplayer.getValue();
			Date date = java.sql.Date.valueOf(localDate);
			Date date1 = java.sql.Date.valueOf(localDate1);
			Date date2 = java.sql.Date.valueOf(localDate2);
			String sql = "INSERT INTO coach " + "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, coachname);
			preparedStmt.setString(3, coachcountry);
			preparedStmt.setString(4, coachee);
			preparedStmt.setDate(2, (java.sql.Date) date);
			preparedStmt.setDate(5, (java.sql.Date) date1);
			preparedStmt.setDate(6, (java.sql.Date) date2);
			preparedStmt.execute();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

	@FXML
	void addc1(ActionEvent event) {
		cname.setText("");
		ccountry.valueProperty().set("");
		cplayer.valueProperty().set("");
		cdob.setValue(null);
		csince.setValue(null);
		ctill.setValue(null);
	}

	@FXML
	void referee(Event event) {
		rcountry.getItems().removeAll(rcountry.getItems());
		rcountry.getItems().addAll("USA", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps",
				"Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh",
				"Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina",
				"Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burma", "Burundi", "Cambodia", "Cameroon",
				"Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "People's Republic of China",
				"Republic of China", "Colombia", "Comoros", "Democratic Republic of the Congo", "Republic of the Congo",
				"Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Danzig", "Denmark", "Djibouti",
				"Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
				"Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gaza Strip", "The Gambia",
				"Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana",
				"Haiti", "Holy Roman Empire", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq",
				"Republic of Ireland", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jonathanland", "Jordan",
				"Kazakhstan", "Kenya", "Kiribati", "North Korea", "South Korea", "Kosovo", "Kuwait", "Kyrgyzstan",
				"Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg",
				"Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands",
				"Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro",
				"Morocco", "Mount Athos", "Mozambique", "Namibia", "Nauru", "Nepal", "Newfoundland", "Netherlands",
				"New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Ottoman Empire", "Pakistan", "Palau",
				"Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Prussia",
				"Qatar", "Romania", "Rome", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia",
				"Saint Vincent & the", "Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia",
				"Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia",
				"Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland",
				"Sweden", "Switzerland", "Syria", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga",
				"Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine",
				"United Arab Emirates", "United Kingdom", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City",
				"Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe");
	}

	

	@FXML
	void addr(ActionEvent event) {
		Connection conn = null;
		Statement stmt = null;
		try {
			String refname = "";
			String refcountry = "";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			refname = refname + rname.getText();
			refcountry = refcountry + rcountry.getValue();
			LocalDate localDate = rdob.getValue();
			Date date = java.sql.Date.valueOf(localDate);
			String sql = "INSERT INTO referee " + "VALUES (?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, refname);
			preparedStmt.setString(3, refcountry);
			preparedStmt.setDate(2, (java.sql.Date) date);
			preparedStmt.execute();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

	@FXML
	void addr1(ActionEvent event) {
		rname.setText("");
		rcountry.valueProperty().set("");
		rdob.setValue(null);
	}

	@FXML
	void sponsor(Event event) {
		syear.getItems().removeAll(syear.getItems());
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER, PASS);
			statement = connection.createStatement();
			String query = "SELECT Name FROM player";
			rs = statement.executeQuery(query);
			splayer.getItems().removeAll(splayer.getItems());
			// while(rs.next().getString("Name")!=null){
			while (rs.next()) {
				String sponsplayer = "";
				System.out.println(rs.getString("Name"));
				sponsplayer = rs.getString("Name");
				splayer.getItems().addAll(sponsplayer);

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
		syear.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990);
	}

	

	@FXML
	void adds(ActionEvent event) {
		Connection conn = null;
		Statement stmt = null;
		try {
			String sName = "";
			String sponsplay = "";
			int contract;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			sName = sname.getText();
			sponsplay = splayer.getValue();
			contract = syear.getValue();
			String sql = "INSERT INTO sponsor " + "VALUES (?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, sName);
			preparedStmt.setString(2, sponsplay);
			preparedStmt.setInt(3, contract);
			preparedStmt.execute();
			// System.out.println(pname.getText() + " " + country + " " +
			// localDate + " " + points + " " + year);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}
	}

	@FXML
	void adds1(ActionEvent event) {
		sname.setText("");
		splayer.valueProperty().set("");
		syear.setValue(null);
	}

	@FXML
	void tournament(Event event) {
		tcourt.getItems().removeAll(tcourt.getItems());
		tcategory.getItems().removeAll(tcategory.getItems());
		tyear.getItems().removeAll(tyear.getItems());
		tcourt.getItems().addAll("Hard", "Grass", "Clay");
		tcategory.getItems().addAll("Grand Slam", "ATP 1000", "ATP 500");
		tyear.getItems().addAll(2016, 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008, 2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999, 1998, 1997,
				1996, 1995, 1994, 1993, 1992, 1991, 1990 , 1989 , 1988 , 1987 , 1986 , 1985 , 1984 , 1983 , 1982 , 1981 , 1980 , 1979 , 1978 , 1977 , 1976 , 
				1975 , 1974 , 1973 , 1972 , 1971 , 1970 , 1969 , 1968 , 1967 , 1966 , 1965 , 1964 , 1963 , 1962 , 1961 , 1960 , 1959 , 1958 , 1957 , 1956 , 1955 , 
				1954 , 1953 , 1952 , 1951 , 1950 , 1949 , 1948 , 1947 , 1946 , 1945 , 1944 , 1943 , 1942 , 1941 , 1940 , 1939 , 1938 , 1937 , 1936 , 1935 , 1934 , 1933 , 
				1932 , 1931 , 1930 , 1929 , 1928 , 1927 , 1926 , 1925 , 1924 , 1923 , 1922 , 1921 , 1920 , 1919 , 1918 , 1917 , 1916 , 1915 , 1914 , 1913 , 1912 , 
				1911 , 1910 , 1909 , 1908 , 1907 , 1906 , 1905 , 1904 , 1903 , 1902 , 1901 , 1900 , 1899 , 1898 , 1897 , 1896 , 1895 , 1894 , 1893 , 1892 , 1891 , 1890 , 
				1889 , 1888 , 1887 , 1886 , 1885 , 1884 , 1883 , 1882 , 1881);
	}

	

	@FXML
	void addt(ActionEvent event) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			String tName = "";
			String tCourt = "";
			String tCategory = "";
			int tYear;
			int tpoints = 0;
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			tName = tName + tname.getText();
			tCategory = tCategory + tcategory.getValue();
			if(tCategory.equals("Grand Slam")){
				tpoints = 2000;
			}
			else if(tCategory.equals("ATP 1000")){
				tpoints = 1000;
			}
			else if(tCategory.equals("ATP 500")){
				tpoints = 500;
			}
			tCourt = tCourt + tcourt.getValue();
			tYear = tyear.getValue();
			String sql = "INSERT INTO tournament " + "VALUES (?, ?, ?, ?)";
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, tName);
			preparedStmt.setInt(3, tpoints);
			preparedStmt.setString(2, tCourt);
			preparedStmt.setInt(4, tYear);
			preparedStmt.execute();
			// System.out.println(pname.getText() + " " + country + " " +
			// localDate + " " + points + " " + year);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
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
