package com.iiitd;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private ComboBox<?> country;

    @FXML
    private TextField match1;
    
    @FXML
    private ComboBox<?> title1;

    @FXML
    private ComboBox<?> title2;

    @FXML
    private TableColumn<?, ?> cpro;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private ComboBox<?> wont;

    @FXML
    private Button back;

    @FXML
    private ComboBox<?> court;

    @FXML
    private ComboBox<?> pro1;

    @FXML
    private DatePicker born2;

    @FXML
    private Button filter;

    @FXML
    private ComboBox<?> pro2;

    @FXML
    private DatePicker born1;
    
    @FXML
    private TableView<?> playertable;

    @FXML
    private TableColumn<?, ?> catp;

    @FXML
    private TableColumn<?, ?> ctitle;

    @FXML
    private ComboBox<?> name;

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

    }

    @FXML
    void backb(ActionEvent event) {

    }

}
