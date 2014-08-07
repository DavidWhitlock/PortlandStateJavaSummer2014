package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.ui.DeckPanel;

public class PacManGame extends DeckPanel {

  static final int LEVEL_EDITOR_INDEX = 0;

  public PacManGame(PacManServiceAsync service) {
    add(new LevelEditor(service));
    showWidget(LEVEL_EDITOR_INDEX);
  }
}
