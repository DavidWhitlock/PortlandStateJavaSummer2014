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
    assertThat(RomanNumerals.romanNumeralFor(4), equalTo("IV"));
    assertThat(RomanNumerals.romanNumeralFor(5), equalTo("V"));
    assertThat(RomanNumerals.romanNumeralFor(6), equalTo("VI"));
    assertThat(RomanNumerals.romanNumeralFor(7), equalTo("VII"));
    assertThat(RomanNumerals.romanNumeralFor(8), equalTo("VIII"));
    assertThat(RomanNumerals.romanNumeralFor(9), equalTo("IX"));
    assertThat(RomanNumerals.romanNumeralFor(10), equalTo("X"));
  }

}
