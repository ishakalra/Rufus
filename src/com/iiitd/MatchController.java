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

public class MatchController {

    @FXML
    private TableColumn<?, ?> cround;

    @FXML
    private TableColumn<?, ?> clost;

    @FXML
    private Button apply;

    @FXML
    private ComboBox<?> year;

    @FXML
    private TableView<?> matchtable;

    @FXML
    private ComboBox<?> country1;

    @FXML
    private Button back;

    @FXML
    private ComboBox<?> tyear;

    @FXML
    private ComboBox<?> tournament;

    @FXML
    private TableColumn<?, ?> cyear;

    @FXML
    private ComboBox<?> referee;

    @FXML
    private ComboBox<?> court;

    @FXML
    private ComboBox<?> country2;

    @FXML
    private ComboBox<?> round;

    @FXML
    private TableColumn<?, ?> catp;

    @FXML
    private ComboBox<?> name2;

    @FXML
    private TableColumn<?, ?> creferee;

    @FXML
    private ComboBox<?> name1;

    @FXML
    private TableColumn<?, ?> cwon;

    @FXML
    private TableColumn<?, ?> ctournament;

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
