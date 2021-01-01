package edu.umn.cs.csci3081w.project.model;

import java.io.PrintStream;

/**
 * Abstract class for bus decorator.
 */
public abstract class BusDecorator extends Bus {

  /**
   * Bus information.
   */
  protected Bus bus;

  /**
   * Constructor for bus decorator.
   *
   * @param bus bus information
   */
  public BusDecorator(Bus bus) {
    super("", bus.getOutgoingRoute(), null, -1, -1);
    this.bus = bus;
  }

  /**
   * Get the bus data.
   * @return bus data
   */
  @Override
  public BusData getBusData() {
    return bus.getBusData();
  }

  /**
   * Check whether the trip is complete or not.
   *
   * @return trip completed or not
   */
  @Override
  public boolean isTripComplete() {
    return bus.isTripComplete();
  }

  /**
   * Report data.
   *
   * @param out stream for printing
   */
  @Override
  public void report(PrintStream out) {
    bus.report(out);
  }

  /**
   * Update data.
   */
  @Override
  public void update() {
    bus.update();
    decorate();
  }

  /**
   * Display information of the bus.
   */
  @Override
  public void displayInfo() {
    bus.displayInfo();
  }

  /**
   * Set concrete bus subject.
   *
   * @param concreteBusSubject concrete bus subject
   */
  @Override
  public void setConcreteBusSubject(ConcreteBusSubject concreteBusSubject) {
    bus.setConcreteBusSubject(concreteBusSubject);

  }

  /**
   * Abstract for decorate method.
   */
  public abstract void decorate();

  /**
   * Get name of the bus.
   *
   * @return name of the bus
   */
  @Override
  public String getName() {
    return bus.getName();
  }

  /**
   * Get speed of the bus.
   *
   * @return speed of the bus
   */
  @Override
  public double getSpeed() {
    return bus.getSpeed();
  }

  /**
   * Get incoming route of the bus.
   *
   * @return incoming route
   */
  @Override
  public Route getIncomingRoute() {
    return bus.getIncomingRoute();
  }

  /**
   * Get outgoing route of the bus.
   *
   * @return outgoing route
   */
  @Override
  public Route getOutgoingRoute() {
    return bus.getOutgoingRoute();
  }

  /**
   * Get capacity of the bus.
   *
   * @return capacity of the bus
   */
  @Override
  public int getCapacity() {
    return bus.getCapacity();
  }

  /**
   * Get number of passengers on the bus.
   *
   * @return number of passengers
   */
  @Override
  public long getNumPassengers() {
    return bus.getNumPassengers();
  }

  /**
   * Get next stop of the bus.
   *
   * @return next stop
   */
  @Override
  public Stop getNextStop() {
    return bus.getNextStop();
  }

  /**
   * Update bus data.
   */
  @Override
  public void updateBusData() {
    bus.updateBusData();
  }

  /**
   * Move the bus.
   *
   * @return is the bus moved or not
   */
  @Override
  public boolean move() {
    return bus.move();
  }

  /**
   * Load the passengers into bus.
   *
   * @param newPassenger information of passenger
   * @return is the passengers loaded or not
   */
  @Override
  public boolean loadPassenger(Passenger newPassenger) {
    return bus.loadPassenger(newPassenger);
  }
}
