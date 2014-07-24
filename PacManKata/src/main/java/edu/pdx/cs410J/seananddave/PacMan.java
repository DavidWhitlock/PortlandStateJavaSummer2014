package edu.pdx.cs410J.seananddave;

public class PacMan {
  private final Direction direction;

  public PacMan(int i, int j, Direction direction) {
    this.direction = direction;

  }

  public Direction getDirection() {
    return this.direction;
  }
}
