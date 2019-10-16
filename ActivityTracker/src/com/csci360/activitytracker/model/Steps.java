package com.csci360.activitytracker.model;

public class Steps extends HealthData{

  public Steps(){}

  public Steps(int initSteps){
    this.incrementTotal(initSteps);
  }

  @Override
  public String toString() {
    //TODO Fix me
    return null;
  }
}
