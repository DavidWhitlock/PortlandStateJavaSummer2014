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

}
