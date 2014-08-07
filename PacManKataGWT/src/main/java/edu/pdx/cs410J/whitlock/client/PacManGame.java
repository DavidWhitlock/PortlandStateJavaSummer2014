package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.ui.DeckPanel;

public class PacManGame extends DeckPanel {

  static final int LEVEL_EDITOR_INDEX = 0;
  static final int LEVEL_PLAYER_INDEX = 1;
  private final LevelPlayer player;

  public PacManGame(PacManServiceAsync service) {
    add(new LevelEditor(this, service));
    player = new LevelPlayer();
    add(player);

    showWidget(LEVEL_EDITOR_INDEX);
  }

  public void playGame(Level level) {
    player.displayLevel(level);
    showWidget(LEVEL_PLAYER_INDEX);
  }
}
