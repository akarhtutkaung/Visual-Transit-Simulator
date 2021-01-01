package edu.umn.cs.csci3081w.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for bus subject.
 */
public abstract class BusSubject {

  /**
   * List of bus observers.
   */
  protected List<BusObserver> busObservers;

  /**
   * Create a bus subject and initialize observers to be empty.
   *
   */
  public BusSubject() {
    busObservers = new ArrayList<BusObserver>();
  }

  /**
   * Register the bus observer.
   *
   * @param busObserver bus observer
   */
  public abstract void registerBusObserver(BusObserver busObserver);

  /**
   * Notify the bus observer.
   */
  public abstract void notifyBusObservers();

  /**
   * Get the bus observers.
   *
   * @return list of bus observers
   */
  public abstract List<BusObserver> getBusObservers();
}
