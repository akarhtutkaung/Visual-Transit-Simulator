package edu.umn.cs.csci3081w.project.model;

import java.io.PrintStream;

/**
 * This is the class for passenger data.
 */
public class Passenger {
  private static int COUNT;
  private String name;
  private int destinationStopId;
  private int waitAtStop;
  private int timeOnBus;
  private int id;

  /**
   * Constructor for passenger.
   *
   * @param name name of passenger
   * @param destinationStopId destination stop id
   */
  public Passenger(int destinationStopId, String name) {
    this.name = name;
    this.destinationStopId = destinationStopId;
    this.waitAtStop = 0;
    this.timeOnBus = 0;
    this.id = Passenger.COUNT;
    Passenger.COUNT++;
  }

  /**
   * Updates time variables for passenger.
   */
  public void pasUpdate() {
    if (isOnBus()) {
      timeOnBus++;
    } else {
      waitAtStop++;
    }
  }

  /**
   * Passenger on the bus.
   */
  public void getOnBus() {
    timeOnBus = 1;
  }

  /**
   * Get total wait time.
   *
   * @return total wait time including at stop plus bus
   */
  public int getTotalWait() {
    return waitAtStop + timeOnBus;
  }

  /**
   * Check if on the bus.
   *
   * @return if on the bus
   */
  public boolean isOnBus() {
    return timeOnBus > 0;
  }

  /**
   * Get the destination.
   *
   * @return id of destination
   */
  public int getDestination() {
    return destinationStopId;
  }

  /**
   * Get name of the passenger.
   *
   * @return name of the passenger
   */
  public String getName() {
    return name;
  }

  /**
   * Report statistics for passenger.
   *
   * @param out stream for printing
   */
  public void report(PrintStream out) {
    out.println("####Passenger Info Start####");
    out.println("Name: " + name);
    out.println("Destination: " + destinationStopId);
    out.println("Total wait: " + getTotalWait());
    out.println("Wait at stop: " + waitAtStop);
    out.println("Time on bus: " + timeOnBus);
    out.println("####Passenger Info End####");
  }

}
