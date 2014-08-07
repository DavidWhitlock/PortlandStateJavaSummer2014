package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class LevelEditor extends DockPanel {

  private TextBox numberOfRowsTextBox;
  private TextBox numberOfColumnsTextBox;
  private TextArea textArea;
  private PacManServiceAsync service;

  public LevelEditor(PacManServiceAsync service) {
    this.service = service;
    int initialNumberOfRows = 5;
    int initialNumberOfColumns = 5;
    add(createRowAndColumnPanel(initialNumberOfRows, initialNumberOfColumns), NORTH);
    add(createTextArea(initialNumberOfRows, initialNumberOfColumns), CENTER);
    add(createSaveAndPlayButton(), SOUTH);
  }

  private IsWidget createSaveAndPlayButton() {
    Button button = new Button("Save and Play");
    button.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent clickEvent) {
        saveLevelToServerAndPlayGame();
      }
    });
    return button;
  }

  private void saveLevelToServerAndPlayGame() {
    LevelBuilder builder = createLevelBuildFromTextArea();
    service.createLevel(builder, new AsyncCallback<Level>() {
      @Override
      public void onFailure(Throwable throwable) {
        Window.alert(throwable.getMessage());
      }

      @Override
      public void onSuccess(Level level) {
        StringBuilder sb = new StringBuilder();
        level.drawTo(sb);
        Window.alert(sb.toString());
      }
    });

  }

  private LevelBuilder createLevelBuildFromTextArea() {
    LevelBuilder builder = new LevelBuilder();

    String text = textArea.getText();
    String[] lines = text.split("\n");
    for (String line : lines) {
      builder.addLine(line);
    }
    return builder;
  }

  private IsWidget createTextArea(int initialNumberOfRows, int initialNumberOfColumns) {
    textArea = new TextArea();
    setTextAreaSize(initialNumberOfRows, initialNumberOfColumns);
    return textArea;
  }

  private IsWidget createRowAndColumnPanel(int initialNumberOfRows, int initialNumberOfColumns) {

    VerticalPanel panel = new VerticalPanel();
    numberOfRowsTextBox = createTextBoxWithLabel("Number of Rows", initialNumberOfRows, panel);
    numberOfColumnsTextBox = createTextBoxWithLabel("Number of Columns", initialNumberOfColumns, panel);

    return panel;
  }

  private TextBox createTextBoxWithLabel(String labelString, int initialValue, VerticalPanel parent) {
    Label label = new Label(labelString);

    TextBox textBox = new TextBox();
    textBox.setVisibleLength(3);
    textBox.setMaxLength(3);
    textBox.setText(String.valueOf(initialValue));
    textBox.addBlurHandler(new BlurHandler() {
      @Override
      public void onBlur(BlurEvent blurEvent) {
        updateSizeOfTextArea();
      }
    });

    HorizontalPanel panel = new HorizontalPanel();
    panel.add(label);
    panel.add(textBox);
    parent.add(panel);

    return textBox;
  }

  private void updateSizeOfTextArea() {
    int numberOfRows = getIntValueOfTextBox(numberOfRowsTextBox);
    int numberOfColumns = getIntValueOfTextBox(numberOfColumnsTextBox);

    setTextAreaSize(numberOfRows, numberOfColumns);
  }

  private void setTextAreaSize(int numberOfRows, int numberOfColumns) {
    textArea.setVisibleLines(numberOfRows);
    textArea.setCharacterWidth(numberOfColumns);
  }

  private int getIntValueOfTextBox(TextBox textBox) {
    String value = textBox.getValue();
    try {
      return Integer.parseInt(value);

    } catch (NumberFormatException ex) {
      Window.alert("Value \"" + value + "\" is not a valid number");
      textBox.setFocus(true);
      throw ex;
    }
  }

}
