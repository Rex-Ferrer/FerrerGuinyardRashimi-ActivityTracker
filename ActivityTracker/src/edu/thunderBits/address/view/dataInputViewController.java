package edu.thunderBits.address.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//TODO Generate time and push to view.
public class dataInputViewController implements Initializable  {
	
	@FXML
	private AnchorPane complete;
	@FXML 
	private ImageView image;
    private Parent root;
    private Stage stage;

	@FXML
	private void handleAction() throws IOException {
	    System.out.println("You clicked me!");
	    //switch scene
	    stage = (Stage) image.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("tappedView.fxml"));
    
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	 }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
