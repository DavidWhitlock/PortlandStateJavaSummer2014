package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.whitlock.client.*;

/**
 * The server-side implementation of the Airline service
 */
public class PacManServiceImpl extends RemoteServiceServlet implements PacManService
{

  private Level level;

  @Override
    public AbstractAirline ping()
    {
        Airline airline = new Airline();
        airline.addFlight( new Flight() );
        return airline;
    }

  @Override
  public Level createLevel(LevelBuilder builder) {
    level = builder.create();
    return level;
  }

  @Override
  public Level moveForward() {
    level.movePacManForward();
    return level;
  }

  @Override
  public Level setDirection(Direction direction) {
    level.getPacMan().setDirection(direction);
    return level;
  }

  @Override
  protected void doUnexpectedFailure(Throwable e) {
    e.printStackTrace(System.err);
    super.doUnexpectedFailure(e);
  }
}
