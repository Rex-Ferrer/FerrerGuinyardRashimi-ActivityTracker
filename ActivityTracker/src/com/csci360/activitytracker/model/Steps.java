package com.csci360.activitytracker.model;

public class Steps extends HealthData{

  private int currentSteps = 0;
  private Goal goal;

  public Steps() {
    this.goal = new Goal(0, this.currentSteps);
  }

  public Steps(int initSteps){
    this.incrementTotal(initSteps);
    this.goal = new Goal(0, this.currentSteps);
  }

  @Override
  public String toString() {
    //TODO Fix me
    return null;
  }
}
