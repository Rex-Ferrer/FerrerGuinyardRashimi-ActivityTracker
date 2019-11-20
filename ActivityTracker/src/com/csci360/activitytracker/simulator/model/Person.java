package com.csci360.activitytracker.simulator.model;

// Singleton Design Pattern
public class Person {

  private static Person person;
  private Activities schedule;
  private int defaultAge = 21;

  private Person() {
    this.schedule = new Activities(getDefaultAge());
  }

  public synchronized Person getInstance() {
    if (person == null) {
      person = new Person();
    }
    return person;
  }

  public Activities getSchedule() {
    return this.schedule;
  }

  public int getDefaultAge() {
    return defaultAge;
  }
}