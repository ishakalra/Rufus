package com.iiitd;


import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.*;


public class Main extends Application{
	static Stage stage;
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Parent root=FXMLLoader.load(getClass().getResource("/com/iiitd/Welcome.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("login screen");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
