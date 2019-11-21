package com.csci360.activitytracker.controller;

import com.csci360.activitytracker.MainApp;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
//TODO Generate time and push to view. Generate data and push to view.

public class TappedViewController implements Initializable  {
	
	@FXML
	private AnchorPane complete;
	@FXML 
	private Label hour;
	@FXML 
	private Label min;
	@FXML
	private Label bpm;
	@FXML
	private Label steps;
	//private Steps step = new Steps();
	@FXML
	private Label calories;
	@FXML
	private Label date;
	@FXML
	private ImageView settings;
    private Parent root;
    private Stage stage;

  /**
     * Produces the time in the format: Hours and minutes
     * @throws IOException 
     */
  public void DigitalClock() throws IOException {

    Timeline digitalTime = new Timeline(

        	      new KeyFrame(Duration.seconds(0),

        	        new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent actionEvent) {
                      Calendar calendar = GregorianCalendar.getInstance();
        	           String hourString = pad(2, '0', calendar.get(Calendar.HOUR)   == 0 ? "12" : calendar.get(Calendar.HOUR) + "");
                      String minuteString = pad(2, '0', calendar.get(Calendar.MINUTE) + "");
        	            hour.setText(hourString );
                      min.setText(minuteString);
        	            
        	          }

        	        }

        	      ),

        	      new KeyFrame(Duration.seconds(1))

        	    );
    	
      	digitalTime.setCycleCount(Animation.INDEFINITE);
  		
  		digitalTime.play();
      }
    /**
     * Produces the date in the following format
     * week ,month, date, year
     */

    private void initClock() {

      Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E MMM dd yyyy ");
        date.setText(LocalDateTime.now().format(formatter));
      }), new KeyFrame(Duration.seconds(1)));
      clock.setCycleCount(Animation.INDEFINITE);
      clock.play();
    }
    
    /**
     * Formats the time 
     * @param fieldWidth
     * @param padChar
     * @param s
     * @return
     */
    private String pad(int fieldWidth, char padChar, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < fieldWidth; i++) {
          sb.append(padChar);
        }
        sb.append(s);
        return sb.toString();
      }
    /**
     * When the user clicks either the feet or somewhere close to the hour in time, a 
     * new interface will open up
     * @throws IOException
     */
	@FXML
  private void handleAction(MouseEvent event) throws IOException {
	     //switch scene
	    stage = (Stage) hour.getScene().getWindow();
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) hour.getScene().getWindow();
        root.setLocation(MainApp.class.getResource("view/StepsView.fxml"));    
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);    
	    stage.setScene(scene);   
	    stage.show();
	}

	
	/**
	 * When the user clicks the settings image a new interface opens
	 * @throws IOException
	 */
	@FXML
	private void handleSettings(MouseEvent event) throws IOException {
		FXMLLoader root = new FXMLLoader();
	    stage = (Stage) settings.getScene().getWindow(); 
        root.setLocation(MainApp.class.getResource("view/DataInputView.fxml"));     
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);	    
	    stage.setScene(scene);       	      
	    stage.show();
	 	         
	}
	/**
	 * When the user clicks the fire image a new interface opens
	 * @throws IOException
	 */
	@FXML
  private void handlecal(MouseEvent event) throws IOException {
	     //switch scene
	    stage = (Stage) hour.getScene().getWindow();
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) hour.getScene().getWindow();
        root.setLocation(MainApp.class.getResource("view/CaloriesView.fxml"));    
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);    
	    stage.setScene(scene);   
	    stage.show();
	}
	final Timeline stuff = new Timeline(
			  
			  new KeyFrame(Duration.seconds(0), 
					  new EventHandler<ActionEvent>() {
			  int incremStep=1000;
			  int incremCal=100;
			  
			  @Override public void handle(ActionEvent actionEvent) {
			  
			  if(incremStep<10000000) {
				  incremStep=incremStep+1000;
			  }
			  if(incremCal<10000000) {
				  incremCal=incremCal+100;
			  }
			  steps.setText(String.valueOf(incremStep)); 
			  calories.setText(String.valueOf(incremCal)); }}
			  ), new KeyFrame(Duration.seconds(3)) );
	
	final Timeline heart = new Timeline(
			  
			  new KeyFrame(Duration.seconds(0), 
					  new EventHandler<ActionEvent>() {
			  int increm=80;
			  @Override public void handle(ActionEvent actionEvent) {
			  
			  if(increm<120) {
				  increm=increm+1;
			  }
			  
			  bpm.setText(String.valueOf(increm)+" bpm"); }}
			  
			  ), new KeyFrame(Duration.seconds(2)) );	  	          
	
	/**
	 * Start clock and date
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stuff.setCycleCount(Animation.INDEFINITE); stuff.play();
		//call.setCycleCount(Animation.INDEFINITE); call.play();
		heart.setCycleCount(Animation.INDEFINITE); heart.play();
		try {
      DigitalClock();

      initClock();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
