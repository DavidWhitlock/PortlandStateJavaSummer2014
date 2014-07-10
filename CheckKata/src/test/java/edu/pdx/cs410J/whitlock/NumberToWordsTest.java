package edu.pdx.cs410J.whitlock;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class NumberToWordsTest {

  @Test
  public void number1IsOne() {
    assertThat(NumberToWords.numberToWords(1.00), equalTo("one dollar"));
  }
  @Test
  public void number2IsTwo(){
	  assertThat(NumberToWords.numberToWords(2.00),equalTo("two dollars"));
  }

}
