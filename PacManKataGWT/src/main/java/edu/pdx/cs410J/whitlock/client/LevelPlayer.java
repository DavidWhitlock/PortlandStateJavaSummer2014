package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;

public class LevelPlayer extends DockPanel {
  private TextArea textArea;

  public LevelPlayer() {
    add(createTextArea(), CENTER);
  }

  private IsWidget createTextArea() {
    textArea = new TextArea();
    textArea.setReadOnly(true);
    return textArea;
  }

  public void displayLevel(Level level) {
    StringBuilder sb = new StringBuilder();
    level.drawTo(sb);

    textArea.setVisibleLines(level.getNumberOfRows());
    textArea.setCharacterWidth(level.getNumberOfColumns());
    textArea.setText(sb.toString());

  }
}
