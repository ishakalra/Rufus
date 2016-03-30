package com.iiitd;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import com.iiitd.Main;

import javafx.fxml.FXMLLoader;

public class WelcomeController {

    @FXML
    private PasswordField password;

    @FXML
    private Button sinfo;

    @FXML
    private Button cinfo;

    @FXML
    private Button pinfo;

    @FXML
    private Button rinfo;

    @FXML
    private Button mstats;

    @FXML
    private Button login;

    @FXML
    private Button hth;

    @FXML
    private TextField username;

    @FXML
    void headtohead(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Head.fxml"));
		Scene scene=new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Hello There");
		Main.stage.show();
    }

    @FXML
    void matchstats(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Match.fxml"));
		Scene scene=new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Hello There");
		Main.stage.show();
    }

    @FXML
    void coachinfo(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Coach.fxml"));
		Scene scene=new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Hello There");
		Main.stage.show();
    }

    @FXML
    void sponsorinfo(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Sponsor.fxml"));
		Scene scene=new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Hello There");
		Main.stage.show();
    }

    @FXML
    void refereeinfo(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Referee.fxml"));
		Scene scene=new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Hello There");
		Main.stage.show();
    }

    @FXML
    void playerinfo(ActionEvent event) throws IOException{
    	Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Player.fxml"));
		Scene scene=new Scene(parent);
		Main.stage.setScene(scene);
		Main.stage.setTitle("Hello There");
		Main.stage.show();
    }

    @FXML
    void lin(ActionEvent event) throws IOException{
    	if(username.getText().equals("Rogerthat")&&password.getText().equals("sabr")){
			Parent parent = FXMLLoader.load(getClass().getResource("/com/iiitd/Admin.fxml"));
			Scene scene=new Scene(parent);
			Main.stage.setScene(scene);
			Main.stage.setTitle("Hello There");
			Main.stage.show();
//			flag=1;
		}
    	else{
    		System.out.println("Sorry, Admin Entry only");
    		username.setText("");
			password.setText("");
    	}
    }

}
