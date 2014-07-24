package edu.pdx.cs410J.seananddave;

/**
 * This class is represents a <code>Level</code>.
 */                                                                                 
public class Level{

  private final char[][] grid;
  private final PacMan pacman;

  public Level(char[][] grid) {
    this.grid = grid;
    this.pacman = findPacManOnGrid();
  }

  private PacMan findPacManOnGrid() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        char c = grid[i][j];
        if (isPacMan(c)) {
          return new PacMan(i, j, getPacManDirection(c));
        }
      }
    }

    throw new IllegalStateException("No PacMan on Level");
  }

  private boolean isPacMan(char c) {
    return getPacManDirection(c) != null;
  }

  private Direction getPacManDirection(char c) {
    switch(c) {
      case '<':
        return Direction.Right;
      default:
        return null;
    }
  }

  public PacMan getPacMan() {
    return this.pacman;
  }
}