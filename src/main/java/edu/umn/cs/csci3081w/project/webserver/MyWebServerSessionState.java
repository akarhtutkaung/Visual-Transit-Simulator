package edu.umn.cs.csci3081w.project.webserver;

import java.util.HashMap;
import java.util.Map;

/**
 * MyWebServerSessionState class.
 */
public class MyWebServerSessionState {

  private Map<String, MyWebServerCommand> commands;

  /**
   * Default constructor of MyWebServerSessionState.
   */
  public MyWebServerSessionState() {
    this.commands = new HashMap<String, MyWebServerCommand>();
  }

  /**
   * Get commands.
   *
   * @return Map of commands
   */
  public Map<String, MyWebServerCommand> getCommands() {
    return commands;
  }
}
