package edu.umn.cs.csci3081w.project.webserver;

import com.google.gson.JsonObject;

/**
 * ListenBusCommand class which get the listen bus command
 * and mark the bus as an observer.
 */
public class ListenBusCommand extends MyWebServerCommand {
  private VisualizationSimulator visSim;

  /**
   * Constructor for ListenBusCommand.
   *
   * @param visSim VisualizationSimulator
   */
  public ListenBusCommand(VisualizationSimulator visSim) {
    this.visSim = visSim;
  }

  /**
   * Mark the bus as an observer.
   *
   * @param session object representing the simulation session
   * @param command object containing the original command
   * @param state object containing the state of the web server
   */
  @Override
  public void execute(MyWebServerSession session, JsonObject command,
                      MyWebServerSessionState state) {
    String id = command.get("id").getAsString();
    visSim.addBusObserver(id);
  }
}