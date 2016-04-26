package com.iiitd;



import java.io.IOException;

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

public class RefereeController {

    @FXML
    private ComboBox<?> country;

    @FXML
    private TableColumn<?, ?> cmatches;

    @FXML
    private ComboBox<?> player1;

    @FXML
    private Button apply;

    @FXML
    private ComboBox<?> player2;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private Button back;

    @FXML
    private ComboBox<?> tournament;

    @FXML
    private ComboBox<?> court;

    @FXML
    private ComboBox<?> year1;

    @FXML
    private ComboBox<?> year2;

    @FXML
    private TableView<?> refereetable;

    @FXML
    private DatePicker dob2;

    @FXML
    private DatePicker dob1;

    @FXML
    private ComboBox<?> name;

    @FXML
    private TableColumn<?, ?> ccountry;

    @FXML
    private TableColumn<?, ?> cdob;

    @FXML
    void backb(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Welcome.fxml"));
		Scene scene = new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Welcome to Rufus!");
		Main.stage.show();
    }

    @FXML
    void filter(ActionEvent event) {

    }

}

