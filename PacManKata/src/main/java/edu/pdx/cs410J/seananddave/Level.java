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
    PacMan pacman = null;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        char c = grid[i][j];
        if (isPacMan(c)) {
          if (pacman == null) {
            pacman = new PacMan(i, j, getPacManDirection(c));

          } else {
            throw new IllegalStateException("Can only have one PacMan on a Level");
          }
        }
      }
    }

    if (pacman != null) {
      return pacman;

    } else {
      throw new IllegalStateException("No PacMan on Level");
    }
  }

  private boolean isPacMan(char c) {
    return getPacManDirection(c) != null;
  }

  static Direction getPacManDirection(char c) {
    switch(c) {
      case '<':
        return Direction.RIGHT;
      case '>':
        return Direction.LEFT;
      case 'V':
        return Direction.UP;
      case '^':
        return Direction.DOWN;
      default:
        return null;
    }
  }

  public PacMan getPacMan() {
    return this.pacman;
  }
}