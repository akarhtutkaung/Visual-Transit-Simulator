package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umn.cs.csci3081w.project.model.Route;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ConfigManagerTest {

  /**
   * Testing for reading config file.
   */
  @Test
  public void readConfigTest() {
    ConfigManager configM = new ConfigManager();
    configM.readConfig("src/main/resources/configTest.txt");
    List<Route> routes = configM.getRoutes();
    assertEquals(2, routes.size());
    assertEquals(" Campus Connector  East Bound", routes.get(0).getName());
    assertEquals(2, routes.get(0).getStops().size());
    assertEquals(" Campus Connector  West Bound", routes.get(1).getName());
    assertEquals(2, routes.get(1).getStops().size());
  }
}
