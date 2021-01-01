package edu.umn.cs.csci3081w.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for stop subject.
 */
public abstract class StopSubject {

  /**
   * List of StopObservers.
   */
  protected List<StopObserver> stopObservers;

  /**
   * Create a stop subject and initialize observers to be empty.
   *
   */
  public StopSubject() {
    stopObservers = new ArrayList<StopObserver>();
  }

  /**
   * Register the stop observer.
   *
   * @param stopObserver stop observer
   */
  public abstract void registerStopObserver(StopObserver stopObserver);

  /**
   * Notify the stop observers.
   */
  public abstract void notifyStopObservers();

  /**
   * Get the stop observers.
   *
   * @return list of stop observers
   */
  public abstract List<StopObserver> getStopObservers();
}
