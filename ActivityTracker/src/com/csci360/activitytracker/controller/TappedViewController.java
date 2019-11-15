package com.csci360.activitytracker.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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
import javafx.scene.text.Text;
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

    public String checkTime(int t){
        String time1;
        if (t < 10){
            time1 = ("0"+t);
            }
        else{
            time1 = (""+t);
            }
        return time1;
    }
    /**
     * Produces the time in the format: Hours and minutes
     * @throws IOException 
     */
    public void DigitalClock(settings set) throws IOException {
    	
    	 Timeline digitalTime = null;
    	 //Timeline d=null;
        dataa=new DataInputViewController();
        sett=new settings();
        dataa.okClicked=false;
         digitalTime = new Timeline(

        	      new KeyFrame(Duration.seconds(0),

        	        new EventHandler<ActionEvent>() {

        	          @Override public void handle(ActionEvent actionEvent) {
        	        	  
        	        	  if(dataa.okClicked ==false) {
        	        		  //System.out.println("edhwgaiusvbdjklaz"+dataa.isOkClicked());
        	            Calendar calendar = GregorianCalendar.getInstance();

        	           String hourString = pad(2, '0', calendar.get(Calendar.HOUR)   == 0 ? "12" : calendar.get(Calendar.HOUR) + "");

        	           String minuteString= pad(2, '0', calendar.get(Calendar.MINUTE) + "");
        	            //System.out.println("notclicked");
        	            hour.setText(hourString );
        	            min.setText(minuteString );
        	        	  }
        	            else  {
        	            	System.out.println("iobj "+dataa.isOkClicked());
        	            	//System.out.println("\n ok button:" + dataa.ok());System.out.println("ok button for min:" + dataa.sett.getMin());
        	            	//set.setHours(dataa.hour.getValue().toString());
        	            	//set.setMin(dataa.min.getValue().toString());
        	            	//System.out.println("jjj"+);
        	            	
String hourString="7";
          	            //String hourString   = pad(2, '0', (Integer.parseInt(sett.getHours
          	            	//	()))== 0 ? "12" : (Integer.parseInt(sett.getHours())) + "");

          	            String minuteString = checkTime(dataa.min.getValue());

          	          System.out.println("youclicked");
        	            hour.setText(hourString );
        	            min.setText(minuteString );}
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
    public void Date() {
    final Timeline datee = new Timeline(
  	      new KeyFrame(Duration.seconds(0),
  	        new EventHandler<ActionEvent>() {
  	          @Override public void handle(ActionEvent actionEvent) {
  	            Calendar calendar = GregorianCalendar.getInstance();
  	          String month[] = { "Jan", "Feb", "Mar", "Apr", 
                      "May", "Jun", "Jul", "Aug", 
                      "Sep", "Oct", "Nov", "Dec" }; 
  	          String week[]= {"Sat", " Sun", "Mon","Tue","Wed","Thur", "Fri"};
  	          String date1   =week[calendar.get(Calendar.DAY_OF_WEEK)]+" " + month[calendar.get(Calendar.MONTH)]+" "+
  	          calendar.get(Calendar.DATE) +" "+
  	           calendar.get(Calendar.YEAR);
  	            date.setText(date1);  
  	          }
  	        }
  	      ),
  	      new KeyFrame(Duration.seconds(1))
  	    );
    datee.setCycleCount(Animation.INDEFINITE);
	datee.play();
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
	    System.out.println("Next!");
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
		System.out.println("Clicked settings!");  
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
	    System.out.println("Next!");
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

	/**
	 * Start clock and date
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			DigitalClock(null) ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date();
		

	}

}
