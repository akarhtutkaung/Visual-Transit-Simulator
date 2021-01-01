package edu.umn.cs.csci3081w.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class to generate passenger.
 */
public abstract class PassengerGenerator {
  private List<Double> probs;
  private List<Stop> stops;

  /**
   * Constructor for Abstract class.
   *
   * @param stops list of stops
   * @param l list of probabilities
   */
  public PassengerGenerator(List<Double> l, List<Stop> stops) {
    this.probs = new ArrayList<>();
    this.stops = new ArrayList<>();
    for (Double prob : l) {
      this.probs.add(prob);
    }
    for (Stop s : stops) {
      this.stops.add(s);
    }
  }

  /**
   * Generate the passengers.
   *
   * @return number of generated passengers.
   */
  public abstract int generatePassengers();

  /**
   * Get list of probability.
   *
   * @return list of probability
   */
  public List<Double> getProbs() {
    return probs;
  }

  /**
   * Set probability.
   *
   * @param probs list of probability to set
   */
  public void setProbs(List<Double> probs) {
    this.probs = probs;
  }

  /**
   * Get list of stops.
   *
   * @return list of stops
   */
  public List<Stop> getStops() {
    return stops;
  }

  /**
   * Set stops.
   *
   * @param stops list of stops to set
   */
  public void setStops(List<Stop> stops) {
    this.stops = stops;
  }
}