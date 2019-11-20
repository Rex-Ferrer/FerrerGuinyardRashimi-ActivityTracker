package com.csci360.activitytracker.simulator;

import com.csci360.activitytracker.simulator.model.BodyState;
import com.csci360.activitytracker.simulator.model.Person;

//Singleton Thread
public class HumanSimulationThread extends Thread {

  private static HumanSimulationThread humanSimulationThread;
  private BodyState currentBodyState;
  private Person person;

  private HumanSimulationThread() {
  }

  public synchronized HumanSimulationThread getInstance() {
    if (humanSimulationThread == null) {
      humanSimulationThread = new HumanSimulationThread();
    }
    return humanSimulationThread;
  }

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

  public BodyState getCurrentBodyState() {
    return this.currentBodyState;
  }
}