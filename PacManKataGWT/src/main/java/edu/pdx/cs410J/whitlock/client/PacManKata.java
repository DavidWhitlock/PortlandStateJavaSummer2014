package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * A basic GWT class that makes sure that we can send an airline back from the server
 */
public class PacManKata implements EntryPoint {
  @Override
  public void onModuleLoad() {
    final PacManServiceAsync service = GWT.create( PacManService.class );
      RootPanel rootPanel = RootPanel.get();
      rootPanel.add(new PacManGame(service));
  }
}
