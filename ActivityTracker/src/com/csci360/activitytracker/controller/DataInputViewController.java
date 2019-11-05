package com.csci360.activitytracker.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import com.csci360.activitytracker.MainApp;
import com.csci360.activitytracker.settings;
//TODO Generate time and push to view.
public class DataInputViewController implements Initializable  {
	
	@FXML
	private AnchorPane complete;
	@FXML
	private AnchorPane com;
	@FXML 
	private ImageView image;
	@FXML
	private Button ok;
	@FXML
    private Spinner<Integer> hour;
	@FXML
    private Spinner<Integer> min;
    @FXML
    private Spinner<Integer> age;
    @FXML
    private Spinner <Integer>weight;
    
	@FXML
	private Label timeLabel;
	private settings sett;
	@FXML
    private Parent root;
	@FXML
    private Parent roo;
	@FXML
    private Stage stage;
	@FXML
    private boolean okClicked = false;
    
	
	  public void setSetting() { 
		  this.sett = sett;
	  
	  if(true) {
		  //hour
		 timeLabel.setText(hour.getValue().toString());
		 //min
		 timeLabel.setText(min.getValue().toString());
		 //age
		 timeLabel.setText(age.getValue().toString());
		 //weight
		 timeLabel.setText(weight.getValue().toString());
		 } }
	 
       
    public boolean isOkClicked() {
        return okClicked;
    }
	
	  @FXML 
	  private void handleOk() throws IOException{
		 int newH=hour.getValue();
		 int newM=min.getValue();
		 int newA=age.getValue();
		 int newW=weight.getValue();
	  okClicked = true;
	  FXMLLoader root = new FXMLLoader();
	    stage = (Stage) ok.getScene().getWindow();
	    
      //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
      root.setLocation(MainApp.class.getResource("view/TappedView.fxml"));
      
      com = (AnchorPane) root.load();
      Scene scene = new Scene(com);
	    
	    stage.setScene(scene);
	    
	    stage.show();
	  
	  }
	 
    
    
    
    
	@FXML
	private void handleAction() throws IOException {
	    System.out.println("You clicked me!");
	    //switch scene
		
	    stage = (Stage) image.getScene().getWindow();
	    FXMLLoader roo = new FXMLLoader();
	   
        //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
        roo.setLocation(MainApp.class.getResource("view/TappedView.fxml"));
        
        complete = (AnchorPane) roo.load();
        Scene scen = new Scene(complete);
	    
	    stage.setScene(scen);
	    stage.show();
	    
	     
	    
	 }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		 SpinnerValueFactory<Integer> valueHour = //
	                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 1);
	            this.hour.setValueFactory(valueHour);
	     SpinnerValueFactory<Integer> valueMin = //
	                new SpinnerValueFactory.IntegerSpinnerValueFactory(00, 59, 00);
	            this.min.setValueFactory(valueMin);
	            
	     SpinnerValueFactory<Integer> valueAge = //
	                new SpinnerValueFactory.IntegerSpinnerValueFactory(9, 98, 12);
	            this.age.setValueFactory(valueAge);
	                
	     SpinnerValueFactory<Integer> valueWeight = //
	                new SpinnerValueFactory.IntegerSpinnerValueFactory(98, 400, 130);
	            this.weight.setValueFactory(valueWeight);
	            
	}

}
