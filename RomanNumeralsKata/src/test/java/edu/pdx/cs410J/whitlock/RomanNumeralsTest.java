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
  public void romanNumeralsFrom1To10() {
    assertThat(RomanNumerals.romanNumeralFor(1), equalTo("I"));
    assertThat(RomanNumerals.romanNumeralFor(2), equalTo("II"));
    assertThat(RomanNumerals.romanNumeralFor(3), equalTo("III"));
  }

}
