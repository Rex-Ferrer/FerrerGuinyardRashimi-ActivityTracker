package com.csci360.activitytracker.simulator.model;

import java.util.Deque;

public class Person {

  private BodyState currentBodyState;
  private Deque<BodyState> activites;

  public BodyState getCurrentBodyState() {
    return this.currentBodyState;
  }

  public Deque<BodyState> getActivites() {
    return this.activites;
  }

  public void addActivity(BodyState bodyState) {
    this.activites.add(bodyState);
  }

}
