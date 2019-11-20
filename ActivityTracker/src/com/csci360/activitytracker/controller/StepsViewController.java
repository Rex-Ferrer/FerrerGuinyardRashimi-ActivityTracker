package com.csci360.activitytracker.controller;

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

//TODO Generate steps and push to view. Program arc to show goals.
public class StepsViewController implements Initializable  {
	@FXML
	private AnchorPane complete;
	@FXML 
	private ImageView image;
    private Parent root;
    private Stage stage;
  @FXML
  ProgressBar stepsBar;
  @FXML
  private Label stepsText;

  
  @FXML
  private void openInput() throws IOException {
    // stepsTexts = new Label("here");
    showInputTextDialog();
    stepsBar.setProgress(0.0);
    //System.out.println(stepsText.getText());
  }


  private void showInputTextDialog() {

    TextInputDialog dialog = new TextInputDialog("10000");

    dialog.setTitle("Steps Goal");
    dialog.setHeaderText("Enter your steps goal:");
    dialog.setContentText("Number:");

    Optional<String> result = dialog.showAndWait();

    result.ifPresent(goal -> {
      this.stepsText.setText("0 / " + goal);
    });


  }


  @FXML
  private void handleInput(MouseEvent event) throws IOException {
    FXMLLoader root = new FXMLLoader();
    stage = (Stage) image.getScene().getWindow();
    root.setLocation(MainApp.class.getResource("view/StepsInput.fxml"));
    complete = (AnchorPane) root.load();
    Scene scene = new Scene(complete);
    stage.setScene(scene);
    stage.show();

  }
 
	  
	  
	@FXML
	private void handleAction() throws IOException {

    //switch scene
	    
	    FXMLLoader root = new FXMLLoader();
	    stage = (Stage) image.getScene().getWindow();
        //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
        root.setLocation(MainApp.class.getResource("view/CaloriesView.fxml"));
        
        complete = (AnchorPane) root.load();
        Scene scene = new Scene(complete);
	    
	    stage.setScene(scene);
	    
	    stage.show();


  }


	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}
