package edu.umn.cs.csci3081w.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class to get/set id and stop of the route.
 */
public class RouteData {
  private String id;
  private List<StopData> stops;

  /**
   * Constructor of route data.
   */
  public RouteData() {
    this.id = "";
    this.stops = new ArrayList<StopData>();
  }

  /**
   * Get id of route.
   *
   * @return id of route
   */
  public String getId() {
    return id;
  }

  /**
   * Set id of route.
   *
   * @param id of route
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get list of stops.
   *
   * @return list of stops
   */
  public List<StopData> getStops() {
    return stops;
  }

  /**
   * Set list of stops.
   *
   * @param stops list of stops
   */
  public void setStops(List<StopData> stops) {
    this.stops = stops;
  }
}
