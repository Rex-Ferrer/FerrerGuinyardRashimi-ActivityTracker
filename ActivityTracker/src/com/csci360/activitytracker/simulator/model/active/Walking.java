package com.csci360.activitytracker.simulator.model.active;

public class Walking implements MovingState {

  private final double heartRate = 90.0;
  private final int stepSpeed = 1; // per second
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
