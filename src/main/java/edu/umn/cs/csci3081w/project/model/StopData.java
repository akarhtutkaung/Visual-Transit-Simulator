package edu.umn.cs.csci3081w.project.model;

/**
 * This is the class to set/get information of the stop.
 */
public class StopData {
  private String id;
  private Position position;
  private int numPeople;

  /**
   * Stop data constructor.
   *
   * @param id stop id
   * @param numPeople Number of people
   * @param position stop position
   */
  public StopData(String id, Position position, int numPeople) {
    this.id = id;
    this.position = position;
    this.numPeople = numPeople;
  }

  /**
   * Default stop data constructor.
   */
  public StopData() {
    this.id = "";
    this.position = new Position();
    this.numPeople = 0;
  }

  /**
   * Get id of the stop.
   *
   * @return id of the stop
   */
  public String getId() {
    return id;
  }

  /**
   * Set id of the stop.
   *
   * @param id id of the stop
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * Get position of the stop.
   *
   * @return position of the stop
   */
  public Position getPosition() {
    return position;
  }

  /**
   * Set position of the stop.
   *
   * @param position position of the stop
   */
  public void setPosition(Position position) {
    this.position = position;
  }

  /**
   * Get total number of people at the stop.
   *
   * @return total number of people at the stop.
   */
  public int getNumPeople() {
    return numPeople;
  }

  /**
   * Set total number of people at the stop.
   *
   * @param numPeople total number of people at the stop
   */
  public void setNumPeople(int numPeople) {
    this.numPeople = numPeople;
  }
}
