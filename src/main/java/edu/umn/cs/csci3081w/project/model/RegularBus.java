package edu.umn.cs.csci3081w.project.model;

/**
 * Regular bus class which has same with normal features with other bus
 * except with maximum capacity of 60 people on board.
 */
public class RegularBus extends Bus {

  /**
   * Constructor for the small bus.
   *
   * @param name     Name of the bus
   * @param outbound Outbound of the bus
   * @param inbound  Inbound of the bus
   * @param speed    Speed of the bus
   */
  public RegularBus(String name, Route outbound, Route inbound, double speed) {
    super(name, outbound, inbound, 60, speed);
  }
}
