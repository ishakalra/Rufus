package com.iiitd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import com.iiitd.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

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
    private ComboBox<?> ppro;

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
    private ComboBox<?> ppoints;

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
    private ComboBox<?> pcountry;

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
    void addp(ActionEvent event) {

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

