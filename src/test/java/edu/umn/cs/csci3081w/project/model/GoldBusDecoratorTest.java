package edu.umn.cs.csci3081w.project.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

public class GoldBusDecoratorTest {

  /**
   * Testing for decorator if the outgoing route is complete
   * and incoming not complete.
   * OCINC: Outgoing Complete Incoming Not Complete.
   */
  @Test
  public void decoratorOcincTest() {
    Bus testBus = TestUtils.createBus();
    testBus.update();
    testBus.update();
    testBus.update();
    GoldBusDecorator gb = new GoldBusDecorator(testBus);
    gb.decorate();
    JsonObject color = testBus.getBusData().getColor();
    assertEquals(255, color.get("red").getAsInt());
    assertEquals(215, color.get("green").getAsInt());
    assertEquals(0, color.get("blue").getAsInt());
    assertEquals(255, color.get("alpha").getAsInt());
  }

  /**
   * Testing for decorator if the outgoing route is incomplete
   * as well as incoming route.
   * ONCINC: Outgoing Not Complete Incoming Not Complete.
   */
  @Test
  public void decoratorOncincTest() {
    Bus testBus = TestUtils.createBus();
    testBus.update();
    GoldBusDecorator gb = new GoldBusDecorator(testBus);
    gb.decorate();
    JsonObject color = testBus.getBusData().getColor();
    assertEquals(128, color.get("red").getAsInt());
    assertEquals(0, color.get("green").getAsInt());
    assertEquals(0, color.get("blue").getAsInt());
    assertEquals(255, color.get("alpha").getAsInt());
  }
}
