package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * JUnit tests for the RomanNumerals class.  These tests extend <code>InvokeMainTestCase</code>
 * which allows them to easily invoke the <code>main</code> method of <code>RomanNumerals</code>.
 * They also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>matchers
 * for more readable assertion statements.
 */
public class RomanNumeralsTest {

  @Test
  public void romanNumeralFor1IsI() {
    assertThat(RomanNumerals.romanNumeralFor(1), equalTo("I"));
  }

  @Test
  public void romanNumeralFor2IsII() {
    assertThat(RomanNumerals.romanNumeralFor(2), equalTo("II"));
  }

  @Test
  public void romanNumeralFor3IsIII() {
    assertThat(RomanNumerals.romanNumeralFor(3), equalTo("III"));
  }

}
