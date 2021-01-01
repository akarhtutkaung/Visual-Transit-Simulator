package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class StartCommandTest {
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
   * Test command for startCommand.
   */
  @Test
  public void testStartCommand() {
    VisualizationSimulator mySim = mock(VisualizationSimulator.class);
    StartCommand sc = new StartCommand(mySim);
    MyWebServerSession session = mock(MyWebServerSession.class);
    MyWebServerSessionState state = mock(MyWebServerSessionState.class);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "start");
    commandFromClient.addProperty("numTimeSteps", 25);
    JsonArray arr = new JsonArray();
    arr.add(2);
    commandFromClient.add("timeBetweenBusses", arr);
    sc.execute(session, commandFromClient, state);
    ArgumentCaptor<List> messageCaptor1 = ArgumentCaptor.forClass(List.class);
    ArgumentCaptor<Integer> messageCaptor2 = ArgumentCaptor.forClass(Integer.class);
    verify(mySim).start(messageCaptor1.capture(), messageCaptor2.capture());
    List<Integer> timeBetweenBusses = new ArrayList<Integer>();
    timeBetweenBusses.add(2);
    assertEquals(timeBetweenBusses, messageCaptor1.getValue());
    assertEquals(25, messageCaptor2.getValue());
  }
}
