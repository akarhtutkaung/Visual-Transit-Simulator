package edu.umn.cs.csci3081w.project.webserver;

import edu.umn.cs.csci3081w.project.model.BusData;
import edu.umn.cs.csci3081w.project.model.RouteData;

/**
 * Interface for WebInterface which update bus and route.
 */
public interface WebInterface {

  /**
   * Update the bus.
   *
   * @param bus information of bus
   * @param deleted if bus should be delete or not
   */
  public void updateBus(BusData bus, boolean deleted);

  /**
   * Update the route.
   *
   * @param route information of the route
   * @param deleted if the route should be delete or not
   */
  public void updateRoute(RouteData route, boolean deleted);
}
