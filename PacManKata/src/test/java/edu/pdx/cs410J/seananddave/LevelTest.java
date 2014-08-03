package edu.pdx.cs410J.seananddave;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * JUnit tests for the Level class.  These tests extend <code>InvokeMainTestCase</code>
 * which allows them to easily invoke the <code>main</code> method of <code>Level</code>.
 * They also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>matchers
 * for more readable assertion statements.
 */
public class LevelTest extends InvokeMainTestCase
{

  @Test
  public void pacmanFacesRight(){
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+-+");
    lb.addLine("|<|");
    lb.addLine("+-+");

    Level alevel = lb.create();

    PacMan pacman = alevel.getPacMan();

    assertThat(pacman.getDirection(), equalTo(Direction.RIGHT));
  }

  @Test
  public void lessThanPacManIsRight() {
    assertThat(Level.getPacManDirection('<'), equalTo(Direction.RIGHT));
  }

  @Test
  public void greaterThanPacManIsLeft() {
    assertThat(Level.getPacManDirection('>'), equalTo(Direction.LEFT));
  }

  @Test
  public void veeIsPacManIsUp() {
    assertThat(Level.getPacManDirection('V'), equalTo(Direction.UP));
  }

  @Test
  public void carretIsPacManIsUp() {
    assertThat(Level.getPacManDirection('^'), equalTo(Direction.DOWN));
  }


  @Test(expected = IllegalStateException.class)
  public void nonRectangleLevelThrowsIllegalStateException() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+--+");
    lb.addLine("|<|");
    lb.addLine("+-+");

    lb.create();
  }

  @Test(expected = IllegalStateException.class)
  public void noPacManOnLevelThrowsIllegalStateException() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+--+");
    lb.addLine("|  |");
    lb.addLine("+--+");

    lb.create();
  }

  @Test(expected = IllegalStateException.class)
  public void twoPacMenOnLevelThrowsIllegalStateException() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+--+");
    lb.addLine("|<^|");
    lb.addLine("+--+");

    lb.create();
  }

  @Test
  public void pacManCannotMoveRight() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+-+");
    lb.addLine("|<|");
    lb.addLine("+-+");

    Level level = lb.create();

    PacMan pacman = level.getPacMan();
    PacMan.Position originalPosition = pacman.getPosition();
    assertThat(originalPosition.getXCoordinate(), equalTo(1));
    assertThat(originalPosition.getYCoordinate(), equalTo(1));

    level.movePacManForward();

    assertThat(originalPosition, equalTo(pacman.getPosition()));
  }

  @Test
  public void pacManCanMoveRight() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+--+");
    lb.addLine("|< |");
    lb.addLine("+--+");

    Level level = lb.create();

    PacMan pacman = level.getPacMan();
    PacMan.Position originalPosition = pacman.getPosition();
    assertThat(originalPosition.getXCoordinate(), equalTo(1));
    assertThat(originalPosition.getYCoordinate(), equalTo(1));

    level.movePacManForward();

    PacMan.Position newPosition = pacman.getPosition();
    assertThat(newPosition.getXCoordinate(), equalTo(1));
    assertThat(newPosition.getYCoordinate(), equalTo(2));
  }

  @Test
  public void pacManCanMoveLeft() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+--+");
    lb.addLine("| >|");
    lb.addLine("+--+");

    Level level = lb.create();

    PacMan pacman = level.getPacMan();
    PacMan.Position originalPosition = pacman.getPosition();
    assertThat(originalPosition.getXCoordinate(), equalTo(1));
    assertThat(originalPosition.getYCoordinate(), equalTo(2));

    level.movePacManForward();

    PacMan.Position newPosition = pacman.getPosition();
    assertThat(newPosition.getXCoordinate(), equalTo(1));
    assertThat(newPosition.getYCoordinate(), equalTo(1));
  }

  @Test
  public void pacManCanMoveUp() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+--+");
    lb.addLine("+  +");
    lb.addLine("|V |");
    lb.addLine("+--+");

    Level level = lb.create();

    PacMan pacman = level.getPacMan();
    PacMan.Position originalPosition = pacman.getPosition();
    assertThat(originalPosition.getXCoordinate(), equalTo(2));
    assertThat(originalPosition.getYCoordinate(), equalTo(1));

    level.movePacManForward();

    PacMan.Position newPosition = pacman.getPosition();
    assertThat(newPosition.getXCoordinate(), equalTo(1));
    assertThat(newPosition.getYCoordinate(), equalTo(1));
  }

  @Test
  public void pacManCanMoveDown() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+--+");
    lb.addLine("+^ +");
    lb.addLine("|  |");
    lb.addLine("+--+");

    Level level = lb.create();

    PacMan pacman = level.getPacMan();
    PacMan.Position originalPosition = pacman.getPosition();
    assertThat(originalPosition.getXCoordinate(), equalTo(1));
    assertThat(originalPosition.getYCoordinate(), equalTo(1));

    level.movePacManForward();

    PacMan.Position newPosition = pacman.getPosition();
    assertThat(newPosition.getXCoordinate(), equalTo(2));
    assertThat(newPosition.getYCoordinate(), equalTo(1));
  }

  @Test
  public void pacManCannotMoveLeftUpOrDown() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+-+");
    lb.addLine("|>|");
    lb.addLine("+-+");

    Level level = lb.create();

    PacMan pacman = level.getPacMan();
    PacMan.Position originalPosition = pacman.getPosition();
    assertThat(originalPosition.getXCoordinate(), equalTo(1));
    assertThat(originalPosition.getYCoordinate(), equalTo(1));

    level.movePacManForward();
    assertThat(originalPosition, equalTo(pacman.getPosition()));

    pacman.setDirection(Direction.UP);
    level.movePacManForward();
    assertThat(originalPosition, equalTo(pacman.getPosition()));

    pacman.setDirection(Direction.DOWN);
    level.movePacManForward();
    assertThat(originalPosition, equalTo(pacman.getPosition()));
  }

  @Test
  public void emptySpacesOnLevelAreFilledWithDots() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+---+");
    lb.addLine("| > |");
    lb.addLine("+---+");

    Level level = lb.create();

    String[] lines = getDrawnLevel(level);

    assertThat(lines.length, equalTo(3));
    assertThat(lines[0], equalTo("+---+"));
    assertThat(lines[1], equalTo("|.>.|"));
    assertThat(lines[2], equalTo("+---+"));
  }

  private String[] getDrawnLevel(Level level) {
    StringBuilder drawing = new StringBuilder();
    level.drawTo(drawing);
    return drawing.toString().split("\n");
  }

  @Test
  public void pacManLeavesBehindAnEmptySpace() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+---+");
    lb.addLine("| > |");
    lb.addLine("+---+");

    Level level = lb.create();
    level.movePacManForward();

    PacMan.Position newPosition = level.getPacMan().getPosition();
    assertThat(newPosition.getXCoordinate(), equalTo(1));
    assertThat(newPosition.getYCoordinate(), equalTo(1));

    String[] lines = getDrawnLevel(level);

    assertThat(lines.length, equalTo(3));
    assertThat(lines[0], equalTo("+---+"));
    assertThat(lines[1], equalTo("|> .|"));
    assertThat(lines[2], equalTo("+---+"));
  }

  @Test
  public void pacManGetsAPointWhenHeEatsADot() {
    LevelBuilder lb = new LevelBuilder();
    lb.addLine("+---+");
    lb.addLine("|.> |");
    lb.addLine("+---+");

    Level level = lb.create();
    assertThat(level.getNumberOfDotsEaten(), equalTo(0));

    level.movePacManForward();

    assertThat(level.getNumberOfDotsEaten(), equalTo(1));
  }

}
