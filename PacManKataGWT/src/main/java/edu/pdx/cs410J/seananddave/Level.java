package edu.pdx.cs410J.seananddave;

import static edu.pdx.cs410J.seananddave.Direction.RIGHT;

/**
 * This class is represents a <code>Level</code>.
 */                                                                                 
public class Level{

  private final char[][] grid;
  private final PacMan pacman;
  private int numberOfDotsEaten;

  public Level(char[][] grid) {
    this.grid = grid;
    this.pacman = findPacManOnGrid();
    fillEmptySpacesWithDots();
  }

  private void fillEmptySpacesWithDots() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (cellIsEmpty(i, j)) {
          grid[i][j] = '.';
        }
      }
    }
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
        return RIGHT;
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

  public void movePacManForward() {
    PacMan pacMan = getPacMan();
    PacMan.Position currentPosition = pacMan.getPosition();
    int newX = currentPosition.getXCoordinate();
    int newY = currentPosition.getYCoordinate();

    switch (pacMan.getDirection()) {
      case RIGHT:
        newY = newY + 1;
        break;
      case LEFT:
        newY = newY - 1;
        break;
      case UP:
        newX = newX - 1;
        break;
      case DOWN:
        newX = newX + 1;
        break;
      default:
        throw new IllegalStateException("Unknown direction: " + pacMan.getDirection());
    }

    if (canPacManMoveTo(newX, newY)) {
      pacMan.setXCoordinate(newX);
      pacMan.setYCoordinate(newY);

      if (cellContainsDot(newX, newY)) {
        this.numberOfDotsEaten++;
      }

      clearCell(currentPosition);
      drawPacMan(newX, newY);
    }

  }

  private boolean cellContainsDot(int x, int y) {
    return this.grid[x][y] == '.';
  }

  private void drawPacMan(int x, int y) {
    this.grid[x][y] = getPacManDirectionChar(this.pacman.getDirection());

  }

  private char getPacManDirectionChar(Direction direction) {
    switch (direction) {
      case UP:
        return 'V';
      case DOWN:
        return '^';
      case LEFT:
        return '>';
      case RIGHT:
        return '<';
      default:
        throw new IllegalStateException("Unknown direction: " + direction);
    }
  }

  private void clearCell(PacMan.Position position) {
    this.grid[position.getXCoordinate()][position.getYCoordinate()] = ' ';
  }

  private boolean canPacManMoveTo(int x, int y) {
    return cellIsEmpty(x, y) || cellContainsDot(x, y);
  }

  private boolean cellIsEmpty(int x, int y) {
    return grid[x][y] == ' ';
  }

  public void drawTo(StringBuilder drawing) {
    drawPacMan(pacman.getPosition().getXCoordinate(), pacman.getPosition().getYCoordinate());

    for (char[] row : grid) {
      drawing.append(row);
      drawing.append("\n");
    }
  }

  public int getNumberOfDotsEaten() {
    return this.numberOfDotsEaten;
  }
}