package com.csci360.activitytracker.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.Scanner;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import com.csci360.activitytracker.MainApp;
import com.csci360.activitytracker.settings;
//TODO Generate time and push to view.
public class CaloriesInputViewController implements Initializable  {

	@FXML
	private AnchorPane complete;

	@FXML
	private AnchorPane com;

	@FXML 
	private ImageView image;

	@FXML
	public Button ok=new Button();

	@FXML 
	public Spinner<Integer> caloriesSpinner;

	@FXML
	private Parent root;

	@FXML
	private Parent roo;

	@FXML
	private Stage stage;

	@FXML
	public boolean okClicked=true;

	/**
	 * The ok button was clicked
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}




	/**
	 * When the ok button is clicked, it saves the input and the interface changes
	 * @throws IOException
	 */
	@FXML 
	public void handleOk(ActionEvent event) throws IOException{

		int caloriesGoal = caloriesSpinner.getValue();
		System.out.println(caloriesGoal);

		FXMLLoader root = new FXMLLoader();
		stage = (Stage) ok.getScene().getWindow();

		root.setLocation(MainApp.class.getResource("view/StepsView.fxml"));

		com = (AnchorPane) root.load();
		Scene scene = new Scene(com);
		StepsViewController display=root.getController();


		stage.setScene(scene);

		stage.show();

	}


	/**
	 * When the back arrow image is clicked a new interface appears
	 * @throws IOException
	 */
	@FXML
	private void handleAction(MouseEvent event) throws IOException {
		//switch scene
		isOkClicked();

		stage = (Stage) image.getScene().getWindow();
		FXMLLoader roo = new FXMLLoader();

		roo.setLocation(MainApp.class.getResource("view/CaloriesView.fxml"));

		complete = (AnchorPane) roo.load();
		Scene scen = new Scene(complete);

		stage.setScene(scen);
		stage.show();


	}


	public void setSpinner() {
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		SpinnerValueFactory<Integer> caloriesClick =  new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, 100, 100);
		this.caloriesSpinner.setValueFactory(caloriesClick);

	}

}
