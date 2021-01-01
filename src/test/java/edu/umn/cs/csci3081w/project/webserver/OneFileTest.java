package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OneFileTest {

  /**
   * Testing for getInstance method.
   * Checking if both instances are same or not.
   */
  @Test
  public void getInstanceTest() {
    OneFile oneFile1 = OneFile.getInstance();
    OneFile oneFile2 = OneFile.getInstance();
    assertTrue(oneFile1 == oneFile2);
  }
}
