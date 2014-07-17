package edu.pdx.cs410J.whitlock;

/**
 * This class is represents a <code>RomanNumerals</code>.
 */                                                                                 
public class RomanNumerals {
  public static String romanNumeralFor(int number) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= number; i++) {
      sb.append("I");
    }

    return sb.toString();
  }
}