package com.csci360.activitytracker.simulator;

import com.csci360.activitytracker.simulator.model.BodyState;
import com.csci360.activitytracker.simulator.model.Person;

public class HumanSimulationThread extends Thread {

  BodyState currentBodyState;
  private Person person;

  public void run() {
    person = person.getInstance();

    for (BodyState bodyState : person.getSchedule().getActivities()) {
      currentBodyState = bodyState;

      try {
        wait(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void setCurrentBodyState() {
    this.currentBodyState = person.getSchedule().getCurrentBodyState();
  }
}