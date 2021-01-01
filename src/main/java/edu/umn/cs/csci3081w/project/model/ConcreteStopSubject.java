package edu.umn.cs.csci3081w.project.model;

import edu.umn.cs.csci3081w.project.webserver.MyWebServerSession;
import java.util.List;

/**
 * Class for concrete stop subject data.
 */
public class ConcreteStopSubject extends StopSubject {
  private MyWebServerSession session;

  /**
   * Create a concrete stop subject.
   *
   * @param session parameter to communicate with the visualization module
   */
  public ConcreteStopSubject(MyWebServerSession session) {
    super();
    this.session = session;
  }

  /**
   * Register the stop as the observer.
   *
   * @param stopObserver stop that is going to become the only observer
   */
  public void registerStopObserver(StopObserver stopObserver) {
    stopObservers.clear();
    stopObserver.setConcreteStopSubject(this);
    stopObservers.add(stopObserver);
  }

  /**
   * Notify the observers that they should display new info.
   */
  public void notifyStopObservers() {
    for (StopObserver stopObserver : stopObservers) {
      stopObserver.displayInfo();
    }
  }

  /**
   * Get current session.
   *
   * @return current session
   */
  public MyWebServerSession getSession() {
    return session;
  }

  /**
   * Get stop observers.
   * @return list of stop observers
   */
  public List<StopObserver> getStopObservers() {
    return stopObservers;
  }
}
