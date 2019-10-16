package com.csci360.activitytracker.controller;

import com.csci360.activitytracker.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//TODO Generate time and push to view.
public class MainViewController implements Initializable  {

	private MainApp mainApp;
	
	@FXML
	private AnchorPane complete;
	@FXML 
	private Label timeLabel;
	@FXML
	private ImageView image;
    private Parent root;
    private Stage stage;

	@FXML
	private void handleAction() throws IOException {
	    System.out.println("You clicked me!");
	    //switch scene
	    stage = (Stage) timeLabel.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TappedView.fxml"));
    
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	 }
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}

}
