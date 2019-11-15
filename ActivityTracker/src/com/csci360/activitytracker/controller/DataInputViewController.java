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
public class DataInputViewController implements Initializable  {
	
	@FXML
	private AnchorPane complete;
	@FXML
	private AnchorPane com;
	@FXML 
	private ImageView image;
	@FXML
	public Button ok=new Button();
	// @FXML
	/*
	 * public TextField hour;
	 * 
	 * @FXML public TextField min;
	 */
	  @FXML public Spinner<Integer> hour;
	  
	  @FXML public Spinner<Integer> min;
	 
    @FXML
    private Spinner<Integer> age;
    @FXML
    private Spinner <Integer>weight;
    
	@FXML
	private Label timeLabel;
	settings sett;
	@FXML
    private Parent root;
	@FXML
    private Parent roo;
	Integer y;
	@FXML
    private Stage stage;
	@FXML
    public boolean okClicked=true ;
	public String Hours ="tell me y,y,yyy";
	private String Minutes;
	public String rr;
	/*
	 * public void setHours(String Hours) { this.Hours=Hours; }
	 * 
	 * public String getHours() { return Hours; }
	 */

    public Integer ok() {
    	Scanner scan=new Scanner(System.in);
    	int n= scan.nextInt();
    	
    	//this.sett = new settings();
    	//Integer u=Integer.parseInt(hour.getValue().toString());
		 //sett.setMin(this.min.getValue().toString());
		 //System.out.println("\n ok button:" + sett.getHours());System.out.println("ok button for min:" + sett.getMin());
    	 return Integer.parseInt(hour.toString());
    }
	
	 void foo(DataInputViewController test) {test.okClicked=true;}
       boolean fooo(boolean test) {return true;}
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
		  this.sett = new settings();
		  //sett.setHours(this.hour.getValue().toString());
			 //sett.setMin(this.min.getValue().toString());
			//this doesnt work returns null System.out.println("\n ok button:" + sett.getHours());System.out.println("ok button for min:" + sett.getMin());
	    	 
			//This returns the right thing System.out.println("end: "+this.hour.getValue().toString());
		 // System.out.print("NewEnd: "+sett.getHours());
		 
		  boolean v= false;
		  v=fooo(v);
		 
		  //okClicked = true;
		  v =isOkClicked();
		  System.out.print("read "+v);
	 	  FXMLLoader root = new FXMLLoader();
	    stage = (Stage) ok.getScene().getWindow();
	    
      //root = FXMLLoader.load(getClass().getResource("view/TappedView.fxml"));
      root.setLocation(MainApp.class.getResource("view/UserTapped.fxml"));
      
      com = (AnchorPane) root.load();
      Scene scene = new Scene(com);
	    
	    stage.setScene(scene);
	    
	    stage.show();
	    
	  }
	 
   

    
    
   /**
    * When the back arrow image is clicked a new interface appears
    * @throws IOException
    */
	@FXML
	private void handleAction(MouseEvent event) throws IOException {
	    System.out.println("You clicked me!");
	    //switch scene
	    isOkClicked();
		  System.out.print("read lim "+isOkClicked());
	    stage = (Stage) image.getScene().getWindow();
	    FXMLLoader roo = new FXMLLoader();
	   
       roo.setLocation(MainApp.class.getResource("view/TappedView.fxml"));
        
        complete = (AnchorPane) roo.load();
        Scene scen = new Scene(complete);
	    
	    stage.setScene(scen);
	    stage.show();
	    
	     
	    
	 }
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		  SpinnerValueFactory<Integer> hourClick =  new
		  SpinnerValueFactory.IntegerSpinnerValueFactory(1, 12, 1);
		  this.hour.setValueFactory(hourClick);
		  
		  SpinnerValueFactory<Integer> minClick =  new
		  SpinnerValueFactory.IntegerSpinnerValueFactory(00, 59, 00);
		  this.min.setValueFactory(minClick);
		  
		 
	     SpinnerValueFactory<Integer> valueAge = //
	                new SpinnerValueFactory.IntegerSpinnerValueFactory(9, 98, 12);
	            this.age.setValueFactory(valueAge);
	                
	     SpinnerValueFactory<Integer> valueWeight = //
	                new SpinnerValueFactory.IntegerSpinnerValueFactory(98, 400, 130);
	            this.weight.setValueFactory(valueWeight);
	            
	}

}
