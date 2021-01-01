package edu.umn.cs.csci3081w.project.model;

/**
 * Bus observer interface.
 */
public interface BusObserver {
  /**
   * Display information.
   */
  public void displayInfo();

  /**
   * Set concrete bus subject.
   * @param concreteBusSubject concrete bus subject
   */
  public void setConcreteBusSubject(ConcreteBusSubject concreteBusSubject);
}
