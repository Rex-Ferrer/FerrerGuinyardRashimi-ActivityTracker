package com.csci360.activitytracker.simulator.model.resting;

public class Standing implements RestingState {

  private final double heartRate = 80.0;
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
