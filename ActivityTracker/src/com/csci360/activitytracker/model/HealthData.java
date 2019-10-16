package com.csci360.activitytracker.model;

public abstract class HealthData {
  private int total = 0;

  public int getTotal(){
    return this.total;
  }

  public void incrementTotal(){
    this.total++;
  }

  public void incrementTotal(int amount){
    this.total += amount;
  }

  public void reset(){
    this.total = 0;
  }

  @Override
  public abstract String toString();
}
