package com.csci360.activitytracker.simulator;

import java.util.concurrent.TimeUnit;

import com.csci360.activitytracker.simulator.model.BodyState;
import com.csci360.activitytracker.simulator.model.Person;

//Singleton Thread
public class HumanSimulationThread {

  private static HumanSimulationThread humanSimulationThread;
  private BodyState currentBodyState;
  private Person person = new Person();


  public HumanSimulationThread() {
  }

  private void runSimulation() {
   //Person person = new Person();
	  System.out.println("Starting run....");
	  person = Person.getInstance();

    for (BodyState bodyState : person.getSchedule().getActivities()) {
      currentBodyState = bodyState;
      //System.out.println("Incrementing steps by " + currentBodyState.getStepSpeed());
      //System.out.println("Current heart rate is " + currentBodyState.getHeartRate());
      //System.out.println("Calorie Burn Rate is " + currentBodyState.getCalorieBurnRate());
      //System.out.println("--------------------------------------------------------------------");
      try {
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Single state completed.");
    }
    
  }

  public void startSimulation() {
    Runnable task = new Runnable() {
      @Override
      public void run() {
        System.out.println("Starting....");
        runSimulation();
        System.out.println("Simulation completed");
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
  
  public Person getPerson() {
	  
	  return this.person;
  }
}