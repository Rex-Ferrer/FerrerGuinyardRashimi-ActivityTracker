package com.csci360.activitytracker.controller;

import com.csci360.activitytracker.MainApp;
import com.csci360.activitytracker.simulator.HumanSimulationThread;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

//TODO Generate steps and push to view. Program arc to show goals.
public class SleepViewController implements Initializable  {
	@FXML
	private AnchorPane complete;
	@FXML 
	private ImageView image;
    private Parent root;
    private Stage stage;
	private HumanSimulationThread dailyActivities;
	
	 @FXML
	  ProgressBar totalSleep;
	 
	 @FXML
	  ProgressBar deepSleep;
	 
	 @FXML
	  ProgressBar lightSleep;
	
	@FXML
	private Label sleepText;

	@FXML
	private void handleAction() throws IOException {
	  //switch scene
	    
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) image.getScene().getWindow();
        //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
        root.setLocation(MainApp.class.getResource("view/MainView.fxml"));
        
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);
	    
	    stage.setScene(scene);
	    
	    
	    
	    
	    stage.show();
	    
	    
	    
	    
	}
	
	
	final Timeline daa = new Timeline(
			  
			  new KeyFrame(Duration.seconds(0), 
					  new EventHandler<ActionEvent>() {
			  int increm=0;
			  @Override public void handle(ActionEvent actionEvent) {
			  
				  
			  if(increm<360) {

				  int random = (int )(Math.random() * 60 + 1);

				  increm=increm+random;
			  }
			  
			  sleepText.setText(String.valueOf(increm));
			  int hours = increm / 60; //since both are ints, you get an int
			  int minutes = increm % 60;
			  sleepText.setText(String.format("%d hrs %02d mins", hours, minutes));
			  double time = increm;
			  totalSleep.setProgress(time/1000.0);
			  lightSleep.setProgress(time/2000.0);
			  deepSleep.setProgress(time/4000.0);
}}
			  
			  ), new KeyFrame(Duration.seconds(1)) );

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		daa.setCycleCount(Animation.INDEFINITE); daa.play();

	}

}
