package edu.pdx.cs410J.seananddave;

import java.util.ArrayList;
import java.util.List;

public class LevelBuilder {


  private List<String> lines = new ArrayList<>();

  public void addLine(String line) {
    lines.add(line);
  }

  public Level create() {
    char[][] grid = new char[lines.size()][lines.get(0).length()];
    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);
      for (int j = 0; j < line.length(); j++) {
        grid[i][j] = line.charAt(j);
      }
    }

    return new Level(grid);
  }
}
