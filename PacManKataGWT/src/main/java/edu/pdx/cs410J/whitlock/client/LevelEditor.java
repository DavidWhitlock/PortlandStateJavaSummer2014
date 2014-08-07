package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.ui.*;

public class LevelEditor extends DockPanel {

  public LevelEditor() {
    int initialNumberOfRows = 5;
    int initialNumberOfColumns = 5;
    add(createRowAndColumnPanel(initialNumberOfRows, initialNumberOfColumns), NORTH);
    add(createTextArea(initialNumberOfRows, initialNumberOfColumns), CENTER);
  }

  private IsWidget createTextArea(int initialNumberOfRows, int initialNumberOfColumns) {
    TextArea textArea = new TextArea();
    textArea.setVisibleLines(initialNumberOfRows);
    textArea.setCharacterWidth(initialNumberOfColumns);
    return textArea;
  }

  private IsWidget createRowAndColumnPanel(int initialNumberOfRows, int initialNumberOfColumns) {

    VerticalPanel panel = new VerticalPanel();
    createTextBoxWithLabel("Number of Rows", initialNumberOfRows, panel);
    createTextBoxWithLabel("Number of Columns", initialNumberOfColumns, panel);

    return panel;
  }

  private TextBox createTextBoxWithLabel(String labelString, int initialValue, VerticalPanel parent) {
    Label label = new Label(labelString);
    TextBox textBox = new TextBox();
    textBox.setVisibleLength(3);
    textBox.setMaxLength(3);
    textBox.setText(String.valueOf(initialValue));

    HorizontalPanel panel = new HorizontalPanel();
    panel.add(label);
    panel.add(textBox);
    parent.add(panel);

    return textBox;
  }

}
