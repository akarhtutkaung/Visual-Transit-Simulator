package edu.umn.cs.csci3081w.project.model;

/**
 * Large bus class which has same with normal features with other bus
 * except with maximum capacity of 90 people on board.
 */
public class LargeBus extends Bus {
  /**
   * Constructor for the small bus.
   *
   * @param name     Name of the bus
   * @param outbound Outbound of the bus
   * @param inbound  Inbound of the bus
   * @param speed    Speed of the bus
   */
  public LargeBus(String name, Route outbound, Route inbound, double speed) {
    super(name, outbound, inbound, 90, speed);
  }
}
