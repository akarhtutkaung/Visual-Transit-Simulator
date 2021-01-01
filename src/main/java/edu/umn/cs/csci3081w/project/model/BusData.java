package edu.umn.cs.csci3081w.project.model;

import com.google.gson.JsonObject;

/**
 * This is the class to get/set data of the bus.
 */
public class BusData {
  private String id;
  private Position position;
  private int numPassengers;
  private int capacity;
  private JsonObject color;

  /**
   * Get the color of the bus.
   *
   * @return color of the bus
   */
  public JsonObject getColor() {
    return color;
  }

  /**
   * Set the color of the bus.
   *
   * @param color color of the bus
   */
  public void setColor(JsonObject color) {
    this.color = color;
  }

  /**
   * Stores details of a bus.
   *
   * @param id bus id
   * @param pos position of the bus
   * @param pass number of passengers
   * @param cap capacity of bus to be created
   */
  public BusData(String id, Position pos, int pass, int cap) {
    this.id = id;
    this.position = pos;
    this.numPassengers = pass;
    this.capacity = cap;
    this.color = new JsonObject();
    setBusColor(128, 0, 0, 255);
  }

  /**
   * Constructor of the bus data.
   */
  public BusData() {
    this.position = new Position();
    this.color = new JsonObject();
    setBusColor(128, 0, 0, 255);
  }

  /**
   * Get id of the bus.
   *
   * @return id of the bus
   */
  public String getId() {
    return id;
  }

  /**
   * Set id of the bus.
   *
   * @param id of the bus
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get position of the bus.
   *
   * @return position of the bus
   */
  public Position getPosition() {
    return position;
  }

  /**
   * Set position of the bus.
   *
   * @param position of the bus
   */
  public void setPosition(Position position) {
    this.position = position;
  }

  /**
   * Get number of passengers on bus.
   *
   * @return number of passenger on bus
   */
  public int getNumPassengers() {
    return numPassengers;
  }

  /**
   * Set number of passengers on bus.
   *
   * @param numPassengers number of passengers on bus
   */
  public void setNumPassengers(int numPassengers) {
    this.numPassengers = numPassengers;
  }

  /**
   * Get passenger capacity of the bus.
   *
   * @return amount of passenger the bus can fit.
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Set passenger capacity of the bus.
   *
   * @param capacity amount of passenger the bus can fit.
   */
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  /**
   * Set the color of the bus.
   *
   * @param red decimal code for red
   * @param green decimal code for green
   * @param blue decimal code for blue
   * @param alpha decimal code for alpha
   */
  public void setBusColor(int red, int green, int blue, int alpha) {
    color.addProperty("red", red);
    color.addProperty("green", green);
    color.addProperty("blue", blue);
    color.addProperty("alpha", alpha);
  }
}
