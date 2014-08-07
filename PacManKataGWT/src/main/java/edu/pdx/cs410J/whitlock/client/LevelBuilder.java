package edu.pdx.cs410J.whitlock.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LevelBuilder implements Serializable {


  private List<String> lines = new ArrayList<>();

  public void addLine(String line) {
    lines.add(line);
  }

  public Level create() {
    int boardWidth = 0;
    char[][] grid = new char[lines.size()][lines.get(0).length()];
    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);

      if (i == 0){
        boardWidth = line.length();

      } else if (line.length() != boardWidth){
        throw new IllegalStateException("Error at line :" + i + 1 + " expected width: " +
          boardWidth + " given width:" + line.length());
      }

      for (int j = 0; j < line.length(); j++) {
        grid[i][j] = line.charAt(j);
      }
    }

    return new Level(grid);
  }
}
