package edu.umn.cs.csci3081w.project.model;

/**
 * Interface for stop observer.
 */
public interface StopObserver {

  /**
   * Display information.
   */
  public void displayInfo();

  /**
   * Set concrete stop subject.
   *
   * @param concreteStopSubject concrete stop subject
   */
  public void setConcreteStopSubject(ConcreteStopSubject concreteStopSubject);
}
