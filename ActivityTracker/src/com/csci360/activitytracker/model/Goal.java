package com.csci360.activitytracker.model;

public class Goal {

  private int goal;
  private int current;
  private boolean goalMet;

  Goal(int goal, int current) {
    this.goal = goal;
    this.current = current;
    this.goalMet = goal == current;
  }

  public int getCurrent() {
    return this.current;
  }

  public void setCurrent(int current) {
    this.current = current;
  }

  public void incrementGoal(int increment) {
    this.current += increment;
    this.goalMet = this.current == this.goal;
  }

  public int getGoal() {
    return this.goal;
  }

  public void setGoal(int goal) {
    this.goal = goal;
  }

  public boolean isGoalMet() {
    return this.goalMet;
  }

  public void reset() {
    this.setCurrent(0);
    this.goalMet = false;
  }
}
