package com.csci360.activitytracker.controller;

import com.csci360.activitytracker.MainApp;
import com.csci360.activitytracker.model.Goal;
import com.csci360.activitytracker.model.Steps;
import com.csci360.activitytracker.simulator.HumanSimulationThread;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

//TODO Generate steps and push to view. Program arc to show goals.

public class StepsViewController implements Initializable {

  @FXML
  private AnchorPane complete;
  @FXML
  private ImageView image;
  @FXML
  ProgressBar stepsBar;
  @FXML
  private Label stepsText;

  private Parent root;
  private Stage stage;

  private HumanSimulationThread dailyActivities = HumanSimulationThread.getInstance();
  private Steps step = new Steps();
  private Goal stepsGoal = new Goal(0, step.getTotal());

  /**
   * Set the steps view goal.
   *
   * @param goal
   */
  public void setGoal(int goal) {
    this.stepsGoal.setGoal(goal);
  }


  /**
   * Transfer goal from StepsInputView to StepView.
   *
   * @param goal
   */
  public void displayGoalChangeInput(int goal) {

    setGoal(goal);
    double stepsProgress = (double) step.getTotal() / stepsGoal.getGoal();
    System.out.println(stepsProgress);

    stepsText.setText(step.getTotal() + " / " + stepsGoal.getGoal() + " steps");
    stepsBar.setProgress(stepsProgress);
  }


  @FXML
  private void onGoalClicked(MouseEvent event) throws IOException {
    FXMLLoader root = new FXMLLoader();
    stage = (Stage) image.getScene().getWindow();
    root.setLocation(MainApp.class.getResource("view/StepsInput.fxml"));
    complete = root.load();
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


  public void stepsUpdater() {

    final Timeline stepsUpdater = new Timeline(
        new KeyFrame(Duration.seconds(0),
            actionEvent -> {
              step.incrementTotal(dailyActivities.getSteps());
              stepsText.setText(Integer.toString(step.getTotal()));
            }
        ),
        new KeyFrame(Duration.seconds(1))
    );
    stepsUpdater.setCycleCount(Animation.INDEFINITE);
    stepsUpdater.play();
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    stepsUpdater();
  }

}
