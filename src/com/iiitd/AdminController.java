package com.iiitd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

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
    private ComboBox<?> tcourt;

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
    private ComboBox<?> tyear;

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
    private ComboBox<?> tcategory;

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
    private ComboBox<?> syear;

    @FXML
    private ComboBox<?> splayer;

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
    			"United States of America","Afghanistan","Albania","Algeria","Andorra","Angola",
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
    	yes = yes + pname.getText();
    	country = country + pcountry.getValue();
    	LocalDate localDate = pdob.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        points=Integer.parseInt(ppoints.getValue());
        year = ppro.getValue();
        System.out.println(yes + " " + country + " " + date + " " + points + " " + year);
    }

    @FXML
    void addp1(ActionEvent event) {

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
    void adds(ActionEvent event) {

    }

    @FXML
    void adds1(ActionEvent event) {

    }

    @FXML
    void addt(ActionEvent event) {

    }

    @FXML
    void addt1(ActionEvent event) {

    }

}

