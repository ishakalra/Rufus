package com.iiitd;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class HeadController {

    @FXML
    private Label match2;

    @FXML
    private Label match1;

    @FXML
    private Label country1;

    @FXML
    private Label title1;

    @FXML
    private Button backb;

    @FXML
    private Label title2;

    @FXML
    private PieChart pie;

    @FXML
    private Label country2;

    @FXML
    private Button filter;

    @FXML
    private Label dob2;

    @FXML
    private Label dob1;

    @FXML
    private Label atp2;

    @FXML
    private Label atp1;

    @FXML
    private Label head1;

    @FXML
    private Label head2;

    @FXML
    private ComboBox<?> name2;

    @FXML
    private ComboBox<?> name1;

    @FXML
    void apply(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Welcome.fxml"));
		Scene scene = new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Welcome to Rufus!");
		Main.stage.show();
    }

}

