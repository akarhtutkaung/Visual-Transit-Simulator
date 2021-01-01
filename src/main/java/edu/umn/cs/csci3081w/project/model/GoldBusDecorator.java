package edu.umn.cs.csci3081w.project.model;

/**
 * Class to decorate bus.
 */
public class GoldBusDecorator extends BusDecorator {

  /**
   * Constructor of the bus.
   *
   * @param bus Bus
   */
  public GoldBusDecorator(Bus bus) {
    super(bus);
  }

  /**
   * Decorate the bus.
   */
  @Override
  public void decorate() {
    if (bus.getOutgoingRoute().isAtEnd() && !bus.getIncomingRoute().isAtEnd()) {
      bus.getBusData().setBusColor(255, 215, 0, 255);
    }
  }
}
