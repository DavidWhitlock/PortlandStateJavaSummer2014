package edu.pdx.cs410J.whitlock;

/**
 * This class is represents a <code>RomanNumerals</code>.
 */                                                                                 
public class RomanNumerals {
  public static String romanNumeralFor(int number) {
    StringBuilder sb = new StringBuilder();

    romanNumeralFor(number, sb);

    return sb.toString();
  }

  private static void romanNumeralFor(int number, StringBuilder sb) {

    if (number >= 50) {
      sb.append("L");
      romanNumeralFor(number - 50, sb);

    } else if (number >= 40) {
      sb.append("XL");
      romanNumeralFor(number - 40, sb);

    } else if (number >= 10) {
      sb.append("X");
      romanNumeralFor(number - 10, sb);

    } else if (number == 9) {
      sb.append("IX");

    } else if (number >= 5) {
      sb.append("V");
      romanNumeralFor(number - 5, sb);

    } else if (number == 4) {
      sb.append("IV");

    } else {
      assert number < 4;
      for (int i = 1; i <= number; i++) {
        sb.append("I");
      }
    }

  }


}