package com.csci360.activitytracker.model;

public class Calories extends HealthData {

  private int currentCalories = 0;
  private Goal goal;

  public Calories() {
    this.goal = new Goal(0, this.currentCalories);
  }

  public Calories(int initCalories){
    this.incrementTotal(initCalories);
    this.goal = new Goal(0, this.currentCalories);
  }

  @Override
  public String toString() {
    //TODO Fix me
    return null;
  }
}
