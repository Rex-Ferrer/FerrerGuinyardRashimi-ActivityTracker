package com.csci360.activitytracker.model;

public class Sleep {

  private int deep = 0;
  private int light = 0;
  private int total = 0;

  Sleep() {
  }

  public void incrementDeep(int increment) {
    this.deep += increment;
    this.total += increment;
  }

  public void incrementLight(int increment) {
    this.light += increment;
    this.total += increment;
  }

  public int getDeep() {
    return this.deep;
  }

  public int getLight() {
    return this.light;
  }

  public int getTotal() {
    return this.total;
  }
}