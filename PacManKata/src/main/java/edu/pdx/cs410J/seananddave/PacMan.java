package edu.pdx.cs410J.seananddave;

public class PacMan {
  private final Direction direction;
  private int xCoordinate;
  private int yCoordinate;

  public PacMan(int xCoordinate, int yCoordinate, Direction direction) {
    this.direction = direction;
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }

  public Direction getDirection() {
    return this.direction;
  }

  public Position getPosition() {
    return new Position(xCoordinate, yCoordinate);
  }

  class Position {
    private final int xCoordinate;
    private final int yCoordinate;

    public Position(int xCoordinate, int yCoordinate) {
      this.xCoordinate = xCoordinate;
      this.yCoordinate = yCoordinate;
    }

    public int getXCoordinate() {
      return this.xCoordinate;
    }

    public int getYCoordinate() {
      return this.yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Position position = (Position) o;

      return xCoordinate == position.xCoordinate && yCoordinate == position.yCoordinate;

    }

    @Override
    public int hashCode() {
      int result = xCoordinate;
      result = 31 * result + yCoordinate;
      return result;
    }
  }
}
