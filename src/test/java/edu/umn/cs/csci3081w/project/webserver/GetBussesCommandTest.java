package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.Bus;
import edu.umn.cs.csci3081w.project.model.BusData;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.Position;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.Stop;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;


public class GetBussesCommandTest {
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
   * Test command for get busses command.
   */
  @Test
  public void testGetBussesCommand() {
    MyWebServer myWS = mock(MyWebServer.class);
    List<BusData> busses = new ArrayList<BusData>();
    BusData testBusData = new BusData("0", new Position(44.972392, -93.243774), 0, 30);
    busses.add(testBusData);
    myWS.busses = busses;

    GetBussesCommand sc = new GetBussesCommand(myWS);
    MyWebServerSession session = mock(MyWebServerSession.class);
    MyWebServerSessionState state = mock(MyWebServerSessionState.class);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "getBusses");
    sc.execute(session, commandFromClient, state);

    ArgumentCaptor<JsonObject> messageCaptor = ArgumentCaptor.forClass(JsonObject.class);
    verify(session).sendJson(messageCaptor.capture());
    JsonObject commandToClient = messageCaptor.getValue();
    JsonArray cmpArr = new JsonArray();

    JsonObject s = new JsonObject();
    s.addProperty("id", "0");
    s.addProperty("numPassengers", 0.0);
    s.addProperty("capacity", 30.0);
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("x", 44.972392);
    jsonObject.addProperty("y", -93.243774);
    s.add("position", jsonObject);
    JsonObject color = new JsonObject();
    color.addProperty("red", 128);
    color.addProperty("green", 0);
    color.addProperty("blue", 0);
    color.addProperty("alpha", 255);
    s.add("color", color);
    cmpArr.add(s);

    assertEquals(cmpArr, commandToClient.get("busses").getAsJsonArray());
  }
}
