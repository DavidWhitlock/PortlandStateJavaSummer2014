package edu.pdx.cs410J.whitlock.client;

import com.google.gwt.user.client.ui.*;

public class LevelEditor extends DockPanel {

  public LevelEditor() {
    add(createRowAndColumnPanel(), NORTH);
  }

  private IsWidget createRowAndColumnPanel() {

    VerticalPanel panel = new VerticalPanel();
    createTextBoxWithLabel("Number of Rows", panel);
    createTextBoxWithLabel("Number of Columns", panel);

    return panel;
  }

  private TextBox createTextBoxWithLabel(String labelString, VerticalPanel parent) {
    Label label = new Label(labelString);
    TextBox textBox = new TextBox();
    textBox.setVisibleLength(3);
    textBox.setMaxLength(3);

    HorizontalPanel panel = new HorizontalPanel();
    panel.add(label);
    panel.add(textBox);
    parent.add(panel);

    return textBox;
  }

}
