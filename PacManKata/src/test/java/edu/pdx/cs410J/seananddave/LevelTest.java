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

    assertThat(pacman.getDirection(), equalTo(Direction.Right));
  }

  // Validate that the grid is a rectangle

  // Validate that there is only one PacMan on the Level
}
