package edu.umn.cs.csci3081w.project.webserver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.umn.cs.csci3081w.project.model.PassengerFactory;
import edu.umn.cs.csci3081w.project.model.Position;
import edu.umn.cs.csci3081w.project.model.RandomPassengerGenerator;
import edu.umn.cs.csci3081w.project.model.RouteData;
import edu.umn.cs.csci3081w.project.model.StopData;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class GetRoutesCommandTest {
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
   * Test command for get routes command.
   */
  @Test
  public void testGetBussesCommand() {
    MyWebServer myWS = mock(MyWebServer.class);
    List<RouteData> routes = new ArrayList<RouteData>();
    RouteData testRouteData = new RouteData();
    List<StopData> stops = new ArrayList<StopData>();
    StopData stopData = new StopData("0", new Position(44.972392, -93.243774), 5);
    stops.add(stopData);

    testRouteData.setId("R1");
    testRouteData.setStops(stops);
    routes.add(testRouteData);
    myWS.routes = routes;

    GetRoutesCommand sc = new GetRoutesCommand(myWS);
    MyWebServerSession session = mock(MyWebServerSession.class);
    MyWebServerSessionState state = mock(MyWebServerSessionState.class);
    JsonObject commandFromClient = new JsonObject();
    commandFromClient.addProperty("command", "getRoutes");
    sc.execute(session, commandFromClient, state);

    ArgumentCaptor<JsonObject> messageCaptor = ArgumentCaptor.forClass(JsonObject.class);
    verify(session).sendJson(messageCaptor.capture());
    JsonObject commandToClient = messageCaptor.getValue();
    JsonArray cmpArr = new JsonArray();

    JsonObject r = new JsonObject();
    r.addProperty("id", "R1");
    JsonArray stopArray = new JsonArray();
    JsonObject stopStruct = new JsonObject();
    stopStruct.addProperty("id", "0");
    stopStruct.addProperty("numPeople", 5);
    JsonObject jsonObj = new JsonObject();
    jsonObj.addProperty("x", 44.972392);
    jsonObj.addProperty("y", -93.243774);
    stopStruct.add("position", jsonObj);
    stopArray.add(stopStruct);

    r.add("stops", stopArray);
    cmpArr.add(r);

    assertEquals(cmpArr, commandToClient.get("routes").getAsJsonArray());
  }
}
