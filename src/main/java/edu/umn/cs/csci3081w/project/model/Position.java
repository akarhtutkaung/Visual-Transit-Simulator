package edu.umn.cs.csci3081w.project.model;

/**
 * Position class which set/get the current position of bus/stop.
 */
public class Position {

  private double xcoordLoc;
  private double ycoordLoc;

  /**
   * Constructor for the position.
   *
   * @param xcoordLoc x coordinate
   * @param ycoordLoc y coordinate
   */
  public Position(double xcoordLoc, double ycoordLoc) {
    this.xcoordLoc = xcoordLoc;
    this.ycoordLoc = ycoordLoc;
  }

  /**
   * Default constructor for the position.
   */
  public Position() {
    this.xcoordLoc = 0.0;
    this.ycoordLoc = 0.0;
  }

  /**
   * Get the x coordinate.
   *
   * @return x coordinate
   */
  public double getXcoordLoc() {
    return xcoordLoc;
  }

  /**
   * Set the x coordinate.
   *
   * @param xcoordLoc x coordinate
   */
  public void setXcoordLoc(double xcoordLoc) {
    this.xcoordLoc = xcoordLoc;
  }

  /**
   * Get the y coordinate.
   *
   * @return y coordinate
   */
  public double getYcoordLoc() {
    return ycoordLoc;
  }

  /**
   * Set the y coordinate.
   *
   * @param ycoordLoc y coordinate
   */
  public void setYcoordLoc(double ycoordLoc) {
    this.ycoordLoc = ycoordLoc;
  }

}
