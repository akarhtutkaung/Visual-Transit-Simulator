package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.umn.cs.csci3081w.project.model.BusData;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.RouteData;
import edu.umn.cs.csci3081w.project.model.StopData;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyWebServerTest {
  /**
   * Setup deterministic operations before each test runs.
   */
  @BeforeEach
  public void setUp() {
    PassengerFactory.DETERMINISTIC = true;
    PassengerFactory.DETERMINISTIC_NAMES_COUNT = 0;
    PassengerFactory.DETERMINISTIC_DESTINATION_COUNT = 0;
    RandomPassengerGenerator.DETERMINISTIC = true;
  }

  /**
   * Testing update bus with bus inside MyWebServer.
   */
  @Test
  public void updateBusOldTest() {
    MyWebServer myWebServerSpy = new MyWebServer();
    List<BusData> busses = new ArrayList<BusData>();
    BusData testBusData = new BusData();
    testBusData.setId("1000");
    testBusData.setNumPassengers(10);
    busses.add(testBusData);
    myWebServerSpy.busses = busses;
    BusData tempBusData = new BusData();
    tempBusData.setId("1000");
    tempBusData.setNumPassengers(5);
    myWebServerSpy.updateBus(tempBusData, false);
    assertEquals(5, myWebServerSpy.busses.get(0).getNumPassengers());
  }

  /**
   * Testing update bus with no bus inside MyWebServer.
   */
  @Test
  public void updateBusNewTest() {
    MyWebServer myWebServerSpy = new MyWebServer();
    BusData tempBusData = new BusData();
    tempBusData.setId("1000");
    tempBusData.setNumPassengers(5);
    myWebServerSpy.updateBus(tempBusData, false);
    assertEquals("1000", myWebServerSpy.busses.get(0).getId());
    assertEquals(5, myWebServerSpy.busses.get(0).getNumPassengers());
  }

  /**
   * Testing remove from updateBus.
   */
  @Test
  public void updateBusRemoveTest() {
    MyWebServer myWebServerSpy = new MyWebServer();
    List<BusData> busses = new ArrayList<BusData>();
    BusData testBusData1 = new BusData();
    testBusData1.setId("1000");
    testBusData1.setNumPassengers(10);
    BusData testBusData2 = new BusData();
    testBusData2.setId("1001");
    testBusData2.setNumPassengers(10);
    busses.add(testBusData1);
    busses.add(testBusData2);
    myWebServerSpy.busses = busses;
    BusData tempBusData = new BusData();
    tempBusData.setId("1000");
    myWebServerSpy.updateBus(tempBusData, true);
    assertEquals(testBusData2, myWebServerSpy.busses.get(0));
  }

  /**
   * Testing update route with route inside MyWebServer.
   */
  @Test
  public void updateRouteOldTest() {
    MyWebServer myWebServerSpy = new MyWebServer();
    List<RouteData> routes = new ArrayList<RouteData>();
    RouteData testRouteData = new RouteData();
    RouteData tempRouteData = new RouteData();
    List<StopData> stops = new ArrayList<StopData>();
    List<StopData> tempStops = new ArrayList<StopData>();
    StopData stopD1 = new StopData();
    StopData stopD2 = new StopData();
    stopD1.setId("1");
    stopD1.setNumPeople(10);
    stopD1.setId("2");
    stopD1.setNumPeople(5);
    stops.add(stopD1);
    stops.add(stopD2);
    tempStops.add(stopD2);
    tempRouteData.setId("R1");
    tempRouteData.setStops(tempStops);
    testRouteData.setId("R1");
    testRouteData.setStops(stops);
    routes.add(testRouteData);
    myWebServerSpy.routes = routes;
    myWebServerSpy.updateRoute(tempRouteData, false);
    assertEquals(1, myWebServerSpy.routes.get(0).getStops().size());
  }

  /**
   * Testing update route without route inside MyWebServer.
   */
  @Test
  public void updateRouteNewTest() {
    MyWebServer myWebServerSpy = new MyWebServer();
    RouteData tempRouteData = new RouteData();
    List<StopData> tempStops = new ArrayList<StopData>();
    StopData stopD1 = new StopData();
    stopD1.setId("1");
    stopD1.setNumPeople(10);
    tempStops.add(stopD1);
    tempRouteData.setId("R1");
    tempRouteData.setStops(tempStops);
    myWebServerSpy.updateRoute(tempRouteData, false);
    assertEquals(1, myWebServerSpy.routes.size());
  }

  /**
   * Testing update route to remove route inside MyWebServer.
   */
  @Test
  public void updateRouteRemoveTest() {
    MyWebServer myWebServerSpy = new MyWebServer();
    List<RouteData> routes = new ArrayList<RouteData>();
    RouteData testRouteData1 = new RouteData();
    RouteData testRouteData2 = new RouteData();
    RouteData tempRouteData = new RouteData();
    List<StopData> stops = new ArrayList<StopData>();
    List<StopData> tempStops = new ArrayList<StopData>();
    StopData stopD1 = new StopData();
    StopData stopD2 = new StopData();
    stopD1.setId("1");
    stopD1.setNumPeople(10);
    stopD1.setId("2");
    stopD1.setNumPeople(5);
    stops.add(stopD1);
    stops.add(stopD2);
    tempStops.add(stopD2);
    tempRouteData.setId("R1");
    tempRouteData.setStops(tempStops);
    testRouteData1.setId("R1");
    testRouteData1.setStops(stops);
    testRouteData2.setId("R2");
    testRouteData2.setStops(stops);
    routes.add(testRouteData1);
    routes.add(testRouteData2);
    myWebServerSpy.routes = routes;
    myWebServerSpy.updateRoute(tempRouteData, true);
    assertEquals(1, myWebServerSpy.routes.size());
  }

}
