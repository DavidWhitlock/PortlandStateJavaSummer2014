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

    if (number >= 500) {
      sb.append("D");
      romanNumeralFor(number - 500, sb);

    } else if (number >= 400) {
      sb.append("CD");
      romanNumeralFor(number - 400, sb);

    } else if (number >= 100) {
      sb.append("C");
      romanNumeralFor(number - 100, sb);

    } else if (number >= 90) {
      sb.append("XC");
      romanNumeralFor(number - 90, sb);

    } else if (number >= 50) {
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