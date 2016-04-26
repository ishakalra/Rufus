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
import javafx.scene.control.TextField;

public class PlayerController {

    @FXML
    private TextField match2;

    @FXML
    private ComboBox<String> country;

    @FXML
    private TextField match1;
    
    @FXML
    private ComboBox<String> title1;

    @FXML
    private ComboBox<String> title2;

    @FXML
    private TableColumn<?, ?> cpro;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private ComboBox<String> wont;

    @FXML
    private Button back;

    @FXML
    private ComboBox<String> court;

    @FXML
    private ComboBox<String> pro1;

    @FXML
    private DatePicker born2;

    @FXML
    private Button filter;

    @FXML
    private ComboBox<String> pro2;

    @FXML
    private DatePicker born1;
    
    @FXML
    private TableView<?> playertable;

    @FXML
    private TableColumn<?, ?> catp;

    @FXML
    private TableColumn<?, ?> ctitle;

    @FXML
    private ComboBox<String> name;

    @FXML
    private TableColumn<?, ?> ccountry;

    @FXML
    private TextField atp2;

    @FXML
    private TextField atp1;

    @FXML
    private TableColumn<?, ?> cdob;

    @FXML
    private TableColumn<?, ?> cmatch;

    @FXML
    void apply(ActionEvent event) {
//    	if((name.getValue().toString().length()!=0)&&(name.getValue().toString().length()!=0)
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
