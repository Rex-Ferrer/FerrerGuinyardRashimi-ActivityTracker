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
    private TextField time;
	@FXML
    private TextField date;
    @FXML
    private TextField age;
    @FXML
    private TextField weight;
    @FXML
    private TextField height;
    @FXML
    private TextField stepgoal;
    @FXML
    private TextField gender;
	@FXML
	private Label timeLabel;
	private settings sett;
    private Parent root;
    private Parent roo;
    private Stage stage;
    private boolean okClicked = false;
    
    public void setSetting(settings sett) {
        this.sett = sett;

        time.setText(sett.getTime());
        date.setText(sett.getDate());
        age.setText(Integer.toString(sett.getAge()));
       weight.setText(Integer.toString(sett.getWeight()));
       height.setText(Integer.toString(sett.getHeight()));
       stepgoal.setText(Integer.toString(sett.getstepGoal()));
       gender.setText(sett.getGender());
    }
    
 
    
    public boolean isOkClicked() {
        return okClicked;
    }
	
	  @FXML 
	  private void handleOk() {
	  
	 sett.setTime(time.getText());
	 sett.setDate(date.getText());
	 sett.setAge(Integer.parseInt(age.getText()));
	 sett.setHeight(Integer.parseInt(height.getText()));
	 sett.setGender(gender.getText()); 
	 sett.setWeight(Integer.parseInt(weight.getText()));
	 sett.setstepGoal(Integer.parseInt(stepgoal.getText()));
	  
	  
	  okClicked = true;
	  
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
	    
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) ok.getScene().getWindow();
        //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
        root.setLocation(MainApp.class.getResource("view/TappedView.fxml"));
        
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);
	    
	    stage.setScene(scene);
	    
	    stage.show();
	    
	    
	    
	 }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
