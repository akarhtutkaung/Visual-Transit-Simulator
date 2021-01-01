package edu.umn.cs.csci3081w.project.webserver;

import java.io.FileWriter;

/**
 * OneFile class which just use 1 file for all the cases.
 */
public class OneFile {
  private static OneFile instance;
  private static FileWriter csv;

  private OneFile() {
    try {
      csv = new FileWriter("doc/log.csv");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Get instance.
   * @return instance
   */
  public static OneFile getInstance() {
    if (instance == null) {
      instance = new OneFile();
    }
    return instance;
  }

  /**
   * Create new instance.
   */
  public static void createNewInstance() {
    instance = new OneFile();
  }

  /**
   * Save bus data into csv file.
   *
   * @param time simulation time elapsed
   * @param id ID of the bus
   * @param positionX position X of the bus
   * @param positionY position Y of the bus
   * @param numPass amount of passengers on the bus
   * @param capacity max capacity of the bus
   */
  public void saveBus(int time, String id, double positionX,
                      double positionY, long numPass, int capacity) {
    try {
      csv.append("Bus");
      csv.append(",");
      csv.append(String.valueOf(time));
      csv.append(",");
      csv.append(id);
      csv.append(",");
      csv.append(String.valueOf(positionX));
      csv.append(",");
      csv.append(String.valueOf(positionY));
      csv.append(",");
      csv.append(String.valueOf(numPass));
      csv.append(",");
      csv.append(String.valueOf(capacity));
      csv.append("\n");
      csv.flush();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Save stop data into csv file.
   *
   * @param time simulation time elapsed
   * @param id ID of the stop
   * @param positionX position X of the stop
   * @param positionY position Y of the stop
   * @param numPass number of passengers at the stop
   */
  public void saveStop(int time, int id, double positionX, double positionY, long numPass) {
    try {
      csv.append("STOP");
      csv.append(",");
      csv.append(String.valueOf(time));
      csv.append(",");
      csv.append(String.valueOf(id));
      csv.append(",");
      csv.append(String.valueOf(positionX));
      csv.append(",");
      csv.append(String.valueOf(positionY));
      csv.append(",");
      csv.append(String.valueOf(numPass));
      csv.append("\n");
      csv.flush();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

