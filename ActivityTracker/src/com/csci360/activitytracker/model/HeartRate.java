package com.csci360.activitytracker.model;

import jdk.nashorn.internal.objects.annotations.Property;

public class HeartRate {
  final private int RESTING_HEART_RATE = 80;
  private int currentHeartRate;

  public HeartRate(){
    this.currentHeartRate = RESTING_HEART_RATE;
  }

  public HeartRate(int initHeartRate){
    this.currentHeartRate = initHeartRate;
  }

  public void setCurrentHeartRate(int currentHeartRate) {
    this.currentHeartRate = currentHeartRate;
  }

  public int getCurrentHeartRate(){
    return this.currentHeartRate;
  }

  public void incrementCurrentHeartRate(int amount) {
    this.currentHeartRate += amount;
  }

  public void decrementCurrentHeartRate(int amount){
    this.currentHeartRate -= amount;
  }
}
