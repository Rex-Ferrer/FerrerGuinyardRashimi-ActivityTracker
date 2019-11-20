package com.csci360.activitytracker.controller;
//

import com.csci360.activitytracker.MainApp;
import com.csci360.activitytracker.model.Calories;
import com.csci360.activitytracker.simulator.HumanSimulationThread;

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
	private HumanSimulationThread dailyActivities;
    @FXML
    private ProgressBar caloriesBar;
    @FXML
    private Label caloriesText;
    
    private Integer userGoal;

    private Integer calories;
    /**When the '+' is clicked, presents the goal input view.
     * @param event
     * @throws IOException
     */
    @FXML
  		private void onGoalClicked(MouseEvent event) throws IOException {
  			FXMLLoader root = new FXMLLoader();
  		    stage = (Stage) image.getScene().getWindow(); 
  	        root.setLocation(MainApp.class.getResource("view/CaloriesInput.fxml"));     
  	        complete = (AnchorPane) root.load();
  	        Scene scene = new Scene(complete);	    
  		    stage.setScene(scene);       	      
  		    stage.show();
  		 	         
  		}

  //Receive message from scene 1
    public void displayGoalChangeInput(int goal) {
        //Display the message
  	  
  	  calories = 300;
        setGoal(goal);
        double total = (double) calories/goal;
        System.out.println(total);
       caloriesText.setText(calories + " / " + goal + " calories burned" );
        caloriesBar.setProgress(total);
    }
    

    public void setGoal(int goal){
  	    this.userGoal = goal;
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
