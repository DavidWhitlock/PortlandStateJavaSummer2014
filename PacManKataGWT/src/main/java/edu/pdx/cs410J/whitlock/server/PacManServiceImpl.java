package edu.pdx.cs410J.whitlock.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.whitlock.client.Airline;
import edu.pdx.cs410J.whitlock.client.Flight;
import edu.pdx.cs410J.whitlock.client.PacManService;

/**
 * The server-side implementation of the Airline service
 */
public class PacManServiceImpl extends RemoteServiceServlet implements PacManService
{
    @Override
    public AbstractAirline ping()
    {
        Airline airline = new Airline();
        airline.addFlight( new Flight() );
        return airline;
    }
}
