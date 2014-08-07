package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TextArea;

public class LevelPlayer extends DockPanel {
  private TextArea textArea;
  private Direction currentDirection;
  private PacManServiceAsync service;

  public LevelPlayer(PacManServiceAsync service) {
    this.service = service;
    add(createTextArea(), CENTER);
  }

  private IsWidget createTextArea() {
    textArea = new TextArea();
    textArea.setReadOnly(true);
    textArea.setFocus(true);

    textArea.addKeyPressHandler(new KeyPressHandler() {
      @Override
      public void onKeyPress(KeyPressEvent event) {
        char key = event.getCharCode();
        Direction direction = getDirectionFromChar(key);
        if (direction != currentDirection) {
          changeDirection(direction);

        } else {
          moveForward();
        }

      }
    });

    return textArea;
  }

  private void moveForward() {
    service.moveForward(displayLevel());

  }

  private AsyncCallback<Level> displayLevel() {
    return new AsyncCallback<Level>() {
      @Override
      public void onFailure(Throwable throwable) {
        Window.alert(throwable.getMessage());
      }

      @Override
      public void onSuccess(Level level) {
        displayLevel(level);
      }
    };
  }

  private void changeDirection(Direction direction) {
    service.setDirection(direction, displayLevel());
  }

  private Direction getDirectionFromChar(char key) {
    switch (key) {
      case 'h':
        return Direction.LEFT;
      case 'j':
        return Direction.UP;
      case 'k':
        return Direction.DOWN;
      case 'l':
        return Direction.RIGHT;
      default:
        return null;
    }
  }

  public void displayLevel(Level level) {
    StringBuilder sb = new StringBuilder();
    level.drawTo(sb);

    textArea.setVisibleLines(level.getNumberOfRows());
    textArea.setCharacterWidth(level.getNumberOfColumns());
    textArea.setText(sb.toString());

    currentDirection = level.getPacMan().getDirection();

  }
}
