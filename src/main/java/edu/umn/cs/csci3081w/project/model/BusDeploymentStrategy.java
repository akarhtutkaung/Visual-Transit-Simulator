package edu.umn.cs.csci3081w.project.model;

/**
 * Interface for bus deployment strategy.
 */
public interface BusDeploymentStrategy {
  /**
   * Get next bus.
   *
   * @param name name of the bus
   * @param outbound outbound route of the bus
   * @param inbound inbound route of the bus
   * @param speed speed of the bus
   * @return Bus with given informations
   */
  public Bus getNextBus(String name, Route outbound, Route inbound, double speed);
}
