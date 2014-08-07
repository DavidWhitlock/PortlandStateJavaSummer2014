package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import edu.pdx.cs410J.AbstractAirline;

/**
 * A GWT remote service that returns a dummy airline
 */
@RemoteServiceRelativePath("pacman")
public interface PacManService extends RemoteService {

  /**
   * Returns the current date and time on the server
   */
  public AbstractAirline ping();

  Level createLevel(LevelBuilder builder);
}
