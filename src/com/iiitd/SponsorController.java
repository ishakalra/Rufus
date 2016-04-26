package com.iiitd;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SponsorController {

    @FXML
    private ComboBox<?> country;

    @FXML
    private TableColumn<?, ?> cplayer;

    @FXML
    private Button apply;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private Button back;

    @FXML
    private ComboBox<?> title1;

    @FXML
    private ComboBox<?> title2;

    @FXML
    private ComboBox<?> tournament;

    @FXML
    private TableColumn<?, ?> cyear;

    @FXML
    private ComboBox<?> year1;

    @FXML
    private ComboBox<?> year2;

    @FXML
    private TableColumn<?, ?> catp;

    @FXML
    private TableColumn<?, ?> ctitle;

    @FXML
    private ComboBox<?> name;

    @FXML
    private ComboBox<?> atp2;

    @FXML
    private TableColumn<?, ?> ccountry;

    @FXML
    private ComboBox<?> atp1;

    @FXML
    private TableView<?> sponsortable;

    @FXML
    private ComboBox<?> player;

    @FXML
    void filter(ActionEvent event) {

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

