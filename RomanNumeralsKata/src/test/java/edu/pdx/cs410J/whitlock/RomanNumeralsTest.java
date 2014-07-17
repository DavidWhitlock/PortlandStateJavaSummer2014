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

  @Test
  public void romanNumeralsFrom11To20() {
    assertThat(RomanNumerals.romanNumeralFor(11), equalTo("XI"));
    assertThat(RomanNumerals.romanNumeralFor(12), equalTo("XII"));
    assertThat(RomanNumerals.romanNumeralFor(13), equalTo("XIII"));
    assertThat(RomanNumerals.romanNumeralFor(14), equalTo("XIV"));
    assertThat(RomanNumerals.romanNumeralFor(15), equalTo("XV"));
    assertThat(RomanNumerals.romanNumeralFor(16), equalTo("XVI"));
    assertThat(RomanNumerals.romanNumeralFor(17), equalTo("XVII"));
    assertThat(RomanNumerals.romanNumeralFor(18), equalTo("XVIII"));
    assertThat(RomanNumerals.romanNumeralFor(19), equalTo("XIX"));
    assertThat(RomanNumerals.romanNumeralFor(20), equalTo("XX"));
  }

  @Test
  public void romanNumeralsFor30And40And50() {
    assertThat(RomanNumerals.romanNumeralFor(30), equalTo("XXX"));
    assertThat(RomanNumerals.romanNumeralFor(40), equalTo("XL"));
    assertThat(RomanNumerals.romanNumeralFor(47), equalTo("XLVII"));
    assertThat(RomanNumerals.romanNumeralFor(50), equalTo("L"));
    assertThat(RomanNumerals.romanNumeralFor(63), equalTo("LXIII"));
  }

  @Test
  public void romanNumeralsBetween50And100() {
    assertThat(RomanNumerals.romanNumeralFor(88), equalTo("LXXXVIII"));
    assertThat(RomanNumerals.romanNumeralFor(99), equalTo("XCIX"));
    assertThat(RomanNumerals.romanNumeralFor(100), equalTo("C"));
    assertThat(RomanNumerals.romanNumeralFor(247), equalTo("CCXLVII"));
  }

  @Test
  public void romanNumeralsAround500() {
    assertThat(RomanNumerals.romanNumeralFor(247), equalTo("CCXLVII"));
    assertThat(RomanNumerals.romanNumeralFor(492), equalTo("CDXCII"));
    assertThat(RomanNumerals.romanNumeralFor(500), equalTo("D"));

  }

}
