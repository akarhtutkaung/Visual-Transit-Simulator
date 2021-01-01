package edu.umn.cs.csci3081w.project.webserver;

import com.google.gson.JsonObject;

/**
 * Abstract class of MyWebServerCommand which executes
 * the commands that is given from client.
 */
public abstract class MyWebServerCommand {

  /**
   * Execute the necessary data.
   *
   * @param session current MyWebServerSession
   * @param command command from client
   * @param state MyWebServerSessionState state
   */
  public abstract void execute(MyWebServerSession session, JsonObject command,
                               MyWebServerSessionState state);
}
