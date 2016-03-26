package com.iiitd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class CoachController {

    @FXML
    private ComboBox<?> country;

    @FXML
    private TableView<?> coachtable;

    @FXML
    private TableColumn<?, ?> csince;

    @FXML
    private TableColumn<?, ?> cplayer;

    @FXML
    private Button apply;

    @FXML
    private TableColumn<?, ?> cname;

    @FXML
    private Button back;

    @FXML
    private DatePicker contract2;

    @FXML
    private ComboBox<?> pro1;

    @FXML
    private ComboBox<?> pro2;

    @FXML
    private TableColumn<?, ?> ctill;

    @FXML
    private DatePicker contract1;

    @FXML
    private ComboBox<?> cooachee;

    @FXML
    private DatePicker dob2;

    @FXML
    private ComboBox<?> coachee_country;

    @FXML
    private DatePicker dob1;

    @FXML
    private ComboBox<?> name;

    @FXML
    private TableColumn<?, ?> ccountry;

    @FXML
    private TableColumn<?, ?> cdob;

    @FXML
    void filter(ActionEvent event) {

    }

    @FXML
    void backb(ActionEvent event) {

    }

}

