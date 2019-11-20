package com.csci360.activitytracker.simulator;

import com.csci360.activitytracker.simulator.model.BodyState;
import com.csci360.activitytracker.simulator.model.Person;

//Singleton Thread
public class HumanSimulationThread {

  private static HumanSimulationThread humanSimulationThread;
  private BodyState currentBodyState;
  private Person person;


  private HumanSimulationThread() {
  }

  private void runSimulation() {
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

  public void startSimulation() {
    Runnable task = new Runnable() {
      @Override
      public void run() {
        runSimulation();
      }
    };

    Thread backgroundThread = new Thread(task);
    backgroundThread.setDaemon(true);
    backgroundThread.start();
  }

  public synchronized HumanSimulationThread getInstance() {
    if (humanSimulationThread == null) {
      humanSimulationThread = new HumanSimulationThread();
    }
    return humanSimulationThread;
  }

  private void setCurrentBodyState() {
    this.currentBodyState = person.getSchedule().getCurrentBodyState();
  }

  public BodyState getCurrentBodyState() {
    return this.currentBodyState;
  }
}