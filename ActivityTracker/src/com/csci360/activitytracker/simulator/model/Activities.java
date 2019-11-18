package com.csci360.activitytracker.simulator.model;

import java.util.ArrayDeque;
import java.util.Deque;

// Composite Design Pattern
public class Activities {

  private Deque<BodyState> activities;
  private BodyState currentBodyState;

  public Activities(int defaultAge) {
    this.activities = new ArrayDeque<>();

    this.addActivity(new Sitting());
    this.addActivity(new Standing());

    // Commence Exercising
    this.addActivity(new Walking());
    this.addActivity(new Jogging(defaultAge));
    this.addActivity(new Running(defaultAge));
    this.addActivity(new Jogging(defaultAge));
    this.addActivity(new Walking());
    this.addActivity(new Standing());
    this.addActivity(new Sitting());
    // End of Excercising

    // Random Activity
    this.addActivity(new Walking());
    this.addActivity(new Sitting());
    this.addActivity(new Walking());
    this.addActivity(new Sitting());
    this.addActivity(new Walking());
    this.addActivity(new Sitting());

    // Lays down and goes to sleep
    this.addActivity(new FirstStage());
    this.addActivity(new SecondStage());
    this.addActivity(new SecondStage());
    this.addActivity(new ThirdStage());
    this.addActivity(new Rem());

    // Wakes Up
    this.addActivity(new Sitting());
//    this.activities.addActivity();

  }

  public BodyState getCurrentBodyState() {
    return this.currentBodyState;
  }

  public Deque<BodyState> getActivities() {
    return this.activities;
  }

  public void addActivity(BodyState bodyState) {
    this.activities.add(bodyState);
  }
}