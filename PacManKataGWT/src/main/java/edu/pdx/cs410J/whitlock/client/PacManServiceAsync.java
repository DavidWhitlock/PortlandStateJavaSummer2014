package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import edu.pdx.cs410J.AbstractAirline;

/**
 * The client-side interface to the ping service
 */
public interface PacManServiceAsync {

  /**
   * Return the current date/time on the server
   */
  void ping(AsyncCallback<AbstractAirline> async);

  void createLevel(LevelBuilder builder, AsyncCallback<Level> callback);

  void moveForward(AsyncCallback<Level> asyncCallback);

  void setDirection(Direction direction, AsyncCallback<Level> callback);
}
