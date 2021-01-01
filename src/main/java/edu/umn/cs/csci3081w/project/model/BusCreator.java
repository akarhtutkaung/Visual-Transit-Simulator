package edu.umn.cs.csci3081w.project.model;

/**
 * This is the class to create a bus.
 */
public abstract class BusCreator {

  /**
   * Create bus.
   *
   * @param name name of the bus
   * @param outbound outbound route of the bus
   * @param inbound inbound route of the bus
   * @param speed speed of the bus
   * @return Bus with given data
   */
  public abstract Bus createBus(String name, Route outbound, Route inbound, double speed);

}
