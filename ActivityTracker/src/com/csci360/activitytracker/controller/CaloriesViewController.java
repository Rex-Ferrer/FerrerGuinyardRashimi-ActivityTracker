package com.csci360.activitytracker.controller;
//

import com.csci360.activitytracker.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//TODO  Generate steps and push to view. Program arc to show goals.
public class CaloriesViewController implements Initializable  {
	
	@FXML
	private AnchorPane complete;
	@FXML 
	private ImageView image;
	private Parent root;
    private Stage stage;
    
    @FXML
    private ProgressBar caloriesBar;
    @FXML
    private Label caloriesText;
    
    private Integer goal;

    private Integer calories;
    /**When the '+' is clicked, presents the goal input view.
     * @param event
     * @throws IOException
     */
    @FXML
  		private void handleInput(MouseEvent event) throws IOException {
  			FXMLLoader root = new FXMLLoader();
  		    stage = (Stage) image.getScene().getWindow(); 
  	        root.setLocation(MainApp.class.getResource("view/CaloriesInput.fxml"));     
  	        complete = (AnchorPane) root.load();
  	        Scene scene = new Scene(complete);	    
  		    stage.setScene(scene);       	      
  		    stage.show();
  		 	         
  		}

  //Receive message from scene 1
    public void transferMessage(int message) {
        //Display the message
  	  
  	  calories = 300;
        setGoal(message);
        double total = (double) calories/message;
        System.out.println(total);
       caloriesText.setText(calories + " / " + message );
        caloriesBar.setProgress(total);
    }
    

    public void setGoal(int goal){
  	    this.goal = goal;
  	    System.out.println(goal);
  	}
    
	/**When image is clicked, presents the sleep view.
	 * @throws IOException
	 */
	@FXML
	private void handleAction() throws IOException {
	  //switch scene
	    
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) image.getScene().getWindow();
        //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
        root.setLocation(MainApp.class.getResource("view/SleepView.fxml"));
        
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);
	    
	    stage.setScene(scene);
	    
	    stage.show();
	    
	    
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
