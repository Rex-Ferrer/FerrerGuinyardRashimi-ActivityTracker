package com.csci360.activitytracker.controller;
//import com.csci360.activitytracker.view.TappedView.fxml;
import com.csci360.activitytracker.MainApp;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
//import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import javafx.util.Duration;
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
//TODO Generate time and push to view.
public class MainViewController implements Initializable  {

	@FXML
	private AnchorPane complete;
	@FXML 
	private Label timeLabel;
	@FXML
	private ImageView image;
    private Parent root;
    private Stage stage;
   

 // determine the starting time.
    Calendar calendar = GregorianCalendar.getInstance();
     
    final Timeline digitalTime = new Timeline(
    	      new KeyFrame(Duration.seconds(0),
    	        new EventHandler<ActionEvent>() {
    	          @Override public void handle(ActionEvent actionEvent) {
    	            Calendar calendar            = GregorianCalendar.getInstance();
    	            String hourString   = pad(2, '0', calendar.get(Calendar.HOUR)   == 0 ? "12" : calendar.get(Calendar.HOUR) + "");
    	            String minuteString = pad(2, '0', calendar.get(Calendar.MINUTE) + "");
    	            String secondString = pad(2, '0', calendar.get(Calendar.SECOND) + "");
    	            //String ampmString   = calendar.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
    	           //timeLabel.setText(hourString + ":" + minuteString + " " + ampmString);
    	            timeLabel.setText(hourString + ":" + minuteString );
    	            
    	          }
    	        }
    	      ),
    	      new KeyFrame(Duration.seconds(1))
    	    );
	private MainApp mainApp;
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
		
	    System.out.println("You clicked me!");
	    //switch scene
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) timeLabel.getScene().getWindow();
        //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
        root.setLocation(MainApp.class.getResource("view/TappedView.fxml"));
        
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);
	    
	    stage.setScene(scene);
	    
	    
	    
	    
	    stage.show();
		 // Show the scene containing the MainView layout.
		
		
	 }
	


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		digitalTime.setCycleCount(Animation.INDEFINITE);
		digitalTime.play();
	}

//}


	/*
	 * public void setMainApp(MainApp mainApp) { this.mainApp = mainApp; }
	 */

}
