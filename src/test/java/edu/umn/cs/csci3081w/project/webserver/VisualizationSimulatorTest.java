package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import edu.umn.cs.csci3081w.project.model.BusData;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.RouteData;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class VisualizationSimulatorTest {

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
   * Testing for start method.
   */
  @Test
  public void startTest() {
    MyWebServer webI = new MyWebServer();
    ConfigManager configM = new ConfigManager();
    MyWebServerSession session = mock(MyWebServerSession.class);
    configM.readConfig("src/main/resources/configTest.txt");
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(2);
    mySim.start(timeBetweenBusses, 1);
    for (int i = 0; i < configM.getRoutes().size(); i++) {
      assertEquals(webI.routes.get(i).getStops(),
          configM.getRoutes().get(i).getRouteData().getStops());
      assertEquals(webI.routes.get(i).getId(),
          configM.getRoutes().get(i).getRouteData().getId());
    }
  }

  /**
   * Testing for update.
   */
  @Test
  public void updateTest() {
    MyWebServer webI = spy(MyWebServer.class);
    ConfigManager configM = new ConfigManager();
    MyWebServerSession session = mock(MyWebServerSession.class);
    configM.readConfig("src/main/resources/configTest.txt");
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(5);
    mySim.start(timeBetweenBusses, 2);
    mySim.setConcreteBusCreator(LocalDateTime.now());
    mySim.update();
    ArgumentCaptor<BusData> messageCaptorB1 =
        ArgumentCaptor.forClass(BusData.class);
    ArgumentCaptor<Boolean> messageCaptorB2 =
        ArgumentCaptor.forClass(Boolean.class);
    verify(webI).updateBus(messageCaptorB1.capture(),
        messageCaptorB2.capture());       // verify for bus
    ArgumentCaptor<RouteData> messageCaptorR1 =
        ArgumentCaptor.forClass(RouteData.class);
    ArgumentCaptor<Boolean> messageCaptorR2 =
        ArgumentCaptor.forClass(Boolean.class);
    verify(webI, times(configM.getRoutes().size() * 2))
        .updateRoute(messageCaptorR1.capture(), messageCaptorR2.capture()); // verify for route
    List<RouteData> routes = (messageCaptorR1.getAllValues());
    BusData busD = messageCaptorB1.getValue();
    assertEquals(webI.busses.get(0).getPosition(), busD.getPosition());
    assertEquals(webI.routes.get(0).getStops(), routes.get(0).getStops());
  }

  /**
   * Testing for update with bus complete trip.
   */
  @Test
  public void updateTripCompleteTest() {
    MyWebServer webI = spy(MyWebServer.class);
    ConfigManager configM = new ConfigManager();
    MyWebServerSession session = mock(MyWebServerSession.class);
    configM.readConfig("src/main/resources/configTest.txt");
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(5);
    mySim.start(timeBetweenBusses, 2);
    mySim.setConcreteBusCreator(LocalDateTime.now());
    int ti = 4;
    for (int i = 0; i < ti; i++) {
      mySim.update();
    }
    ArgumentCaptor<RouteData> messageCaptorR1 = ArgumentCaptor.forClass(RouteData.class);
    ArgumentCaptor<Boolean> messageCaptorR2 = ArgumentCaptor.forClass(Boolean.class);
    verify(webI, times(configM.getRoutes().size() * (ti + 1)))
        .updateRoute(messageCaptorR1.capture(), messageCaptorR2.capture()); // verify for route
    List<RouteData> routes = (messageCaptorR1.getAllValues());
    assertEquals(webI.routes.get(0).getStops(), routes.get(0).getStops());
    assertTrue(webI.busses.size() == 0);
  }

  /**
   * Testing for update while paused.
   */
  @Test
  public void updateTestPaused() {
    MyWebServer webI = mock(MyWebServer.class);
    ConfigManager configM = new ConfigManager();
    MyWebServerSession session = mock(MyWebServerSession.class);
    configM.readConfig("src/main/resources/configTest.txt");
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(5);
    mySim.start(timeBetweenBusses, 2);
    mySim.setConcreteBusCreator(LocalDateTime.now());
    mySim.togglePause();
    mySim.update();
    assertEquals(0, mySim.getSimulationTimeElapsed());
  }

  /**
   * Testing for pause to resume.
   */
  @Test
  public void pauseToResumeTest() {
    MyWebServer webI = mock(MyWebServer.class);
    ConfigManager configM = mock(ConfigManager.class);
    MyWebServerSession session = mock(MyWebServerSession.class);
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    mySim.togglePause();
    mySim.togglePause();
    assertEquals(false, mySim.getPause());
  }

  /**
   * Testing for addBusObserver with valid bus id.
   */
  @Test
  public void addBusObserverValidTest() {
    MyWebServer webI = mock(MyWebServer.class);
    ConfigManager configM = new ConfigManager();
    MyWebServerSession session = mock(MyWebServerSession.class);
    configM.readConfig("src/main/resources/configTest.txt");
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(5);
    mySim.start(timeBetweenBusses, 2);
    mySim.setConcreteBusCreator(LocalDateTime.now());
    mySim.update();
    mySim.addBusObserver("1000");
    assertEquals(1, mySim.getBusObserverSize());
  }

  /**
   * Testing for addBusObserver with invalid bus id.
   */
  @Test
  public void addBusObserverInvalidTest() {
    MyWebServer webI = mock(MyWebServer.class);
    ConfigManager configM = new ConfigManager();
    MyWebServerSession session = mock(MyWebServerSession.class);
    configM.readConfig("src/main/resources/configTest.txt");
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(5);
    mySim.start(timeBetweenBusses, 2);
    mySim.setConcreteBusCreator(LocalDateTime.now());
    mySim.update();
    mySim.addBusObserver("10000");
    assertEquals(0, mySim.getBusObserverSize());
  }

  /**
   * Testing for addStopObserver with valid stop id.
   */
  @Test
  public void addStopObserverValidTest() {
    MyWebServer webI = mock(MyWebServer.class);
    ConfigManager configM = new ConfigManager();
    MyWebServerSession session = mock(MyWebServerSession.class);
    configM.readConfig("src/main/resources/configTest.txt");
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(5);
    mySim.start(timeBetweenBusses, 2);
    mySim.setConcreteBusCreator(LocalDateTime.now());
    mySim.update();
    mySim.addStopObserver("10");
    assertEquals(1, mySim.getStopObserverSize());
  }

  /**
   * Testing for addStopObserver with invalid stop id.
   */
  @Test
  public void addStopObserverInvalidTest() {
    MyWebServer webI = mock(MyWebServer.class);
    ConfigManager configM = new ConfigManager();
    MyWebServerSession session = mock(MyWebServerSession.class);
    configM.readConfig("src/main/resources/configTest.txt");
    VisualizationSimulator mySim = new VisualizationSimulator(webI, configM, session);
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(5);
    mySim.start(timeBetweenBusses, 2);
    mySim.setConcreteBusCreator(LocalDateTime.now());
    mySim.update();
    mySim.addStopObserver("50");
    assertEquals(0, mySim.getStopObserverSize());
  }
}
