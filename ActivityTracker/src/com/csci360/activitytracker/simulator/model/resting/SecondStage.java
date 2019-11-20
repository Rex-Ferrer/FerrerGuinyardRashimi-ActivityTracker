package com.csci360.activitytracker.simulator.model.resting;

public class SecondStage implements NonRem {

  private final double heartRate = 60.0;
  private final int stepSpeed = 0;
  private final int calorieBurnRate = 0;
  private final int duration = 20;

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
