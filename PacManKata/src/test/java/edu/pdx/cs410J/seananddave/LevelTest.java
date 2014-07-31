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
  public void pacManCantMoveRight() {
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

}
