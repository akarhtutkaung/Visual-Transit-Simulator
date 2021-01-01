package edu.umn.cs.csci3081w.project.webserver;

import com.google.gson.JsonObject;

/**
 * UpdateCommand which get the update command and update the program.
 */
public class UpdateCommand extends MyWebServerCommand {

  private VisualizationSimulator mySim;

  /**
   * Constructor of UpdateCommand.
   *
   * @param sim simulation object
   */
  public UpdateCommand(VisualizationSimulator sim) {
    this.mySim = sim;
  }

  /**
   * Updates the state of the simulation.
   *
   * @param session current simulation session
   * @param command the update simulation command content
   * @param state the state of the simulation session
   */
  @Override
  public void execute(MyWebServerSession session, JsonObject command,
                      MyWebServerSessionState state) {
    mySim.update();
  }

}
