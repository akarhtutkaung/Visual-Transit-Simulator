package edu.umn.cs.csci3081w.project.webserver;

import com.google.gson.JsonObject;

/**
 * ListenStopCommand class which get the listen stop command
 * and mark the stop as an observer.
 */
public class ListenStopCommand extends MyWebServerCommand {
  private VisualizationSimulator visSim;

  /**
   * Constructor of ListenStopCommand.
   *
   * @param visSim simulation object
   */
  public ListenStopCommand(VisualizationSimulator visSim) {
    this.visSim = visSim;
  }

  /**
   * Mark the stop as an observer.
   *
   * @param session object representing the simulation session
   * @param command object containing the original command
   * @param state object containing the state of the web server
   */
  @Override
  public void execute(MyWebServerSession session, JsonObject command,
                      MyWebServerSessionState state) {
    String id = command.get("id").getAsString();
    visSim.addStopObserver(id);
  }
}