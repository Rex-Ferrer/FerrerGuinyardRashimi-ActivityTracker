package com.csci360.activitytracker.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import com.csci360.activitytracker.MainApp;
import com.csci360.activitytracker.settings;
//TODO Generate time and push to view. Generate data and push to view.

public class TappedViewController implements Initializable  {
	
	@FXML
	private AnchorPane complete;
	@FXML 
	private Label hour;
	@FXML 
	private Label min;
	@FXML
	private Label date;
	@FXML
	private ImageView settings;
    private Parent root;
    private Stage stage;
    private settings sett;
    private DataInputViewController dataa;

    
    Calendar calendar = GregorianCalendar.getInstance();
    final Timeline digitalTime = new Timeline(
    	      new KeyFrame(Duration.seconds(0),
    	        new EventHandler<ActionEvent>() {
    	          @Override public void handle(ActionEvent actionEvent) {
    	            Calendar calendar = GregorianCalendar.getInstance();
    	            String hourString   = pad(2, '0', calendar.get(Calendar.HOUR)   == 0 ? "12" : calendar.get(Calendar.HOUR) + "");
    	            String minuteString = pad(2, '0', calendar.get(Calendar.MINUTE) + "");
    	            hour.setText(hourString  );
    	            min.setText( minuteString );  
    	            
    	          }
    	        }
    	      ),
    	      new KeyFrame(Duration.seconds(1))
    	    );
    
    final Timeline datee = new Timeline(
  	      new KeyFrame(Duration.seconds(0),
  	        new EventHandler<ActionEvent>() {
  	          @Override public void handle(ActionEvent actionEvent) {
  	            Calendar calendar            = GregorianCalendar.getInstance();
  	          String month[] = { "Jan", "Feb", "Mar", "Apr", 
                      "May", "Jun", "Jul", "Aug", 
                      "Sep", "Oct", "Nov", "Dec" }; 
  	          String week[]= {"Sat", " Sun", "Mon","Tue","Wed","Thur", "Fri"};
  	          String date1   =week[calendar.get(Calendar.DAY_OF_WEEK)]+" " + month[calendar.get(Calendar.MONTH)]+" "+
  	          calendar.get(Calendar.DATE) +" "+
  	           calendar.get(Calendar.YEAR);
  	            int year= calendar.get(Calendar.DAY_OF_YEAR);
  	            date.setText(date1);  
  	          }
  	        }
  	      ),
  	      new KeyFrame(Duration.seconds(1))
  	    );
    
   
    
    private String pad(int fieldWidth, char padChar, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < fieldWidth; i++) {
          sb.append(padChar);
        }
        sb.append(s);
        return sb.toString();
      }
    
	@FXML
	private void handleAction() throws IOException {
	    System.out.println("Next!");
	     //switch scene
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) hour.getScene().getWindow();
        root.setLocation(MainApp.class.getResource("view/StepsView.fxml"));    
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);    
	    stage.setScene(scene);   
	    stage.show();
	}

	@FXML
	private void handleSettings() throws IOException {
		System.out.println("Clicked settings!");  
		FXMLLoader root = new FXMLLoader();
	    stage = (Stage) settings.getScene().getWindow(); 
        root.setLocation(MainApp.class.getResource("view/DataInputView.fxml"));     
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);	    
	    stage.setScene(scene);       	      
	    stage.show();
	    
	   
        
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		digitalTime.setCycleCount(Animation.INDEFINITE);
		digitalTime.play();
		datee.setCycleCount(Animation.INDEFINITE);
		datee.play();
		
	}

}
