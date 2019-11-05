package com.csci360.activitytracker.simulator.model;

public class Running implements MovingState {

  private final double heartRate;
  private final int stepSpeed = 6; //per second
  private final int calorieBurnRate = 0;

  public Running(int age) {
    this.heartRate = (220 - age) * .60;
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
