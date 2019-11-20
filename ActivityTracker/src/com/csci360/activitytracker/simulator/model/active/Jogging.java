package com.csci360.activitytracker.simulator.model.active;

public class Jogging implements MovingState {

  private final double heartRate;
  private final int stepSpeed = 3; //per second
  private final int calorieBurnRate = 0;

  public Jogging(int age) {
    this.heartRate = (220 - age) * .40;
  }

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
