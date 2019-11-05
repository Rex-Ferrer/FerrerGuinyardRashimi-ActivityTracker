package com.csci360.activitytracker.simulator.model;

public class FirstStage implements NonRem {

  private final double heartRate = 70.0;
  private final int stepSpeed = 0;
  private final int calorieBurnRate = 0;

  public double getHeartRate() {
    return this.heartRate;
  }

  public int getStepSpeed() {
    return this.stepSpeed;
  }

  public int getCalorieBurnRate() {
    return this.calorieBurnRate;
  }
}
