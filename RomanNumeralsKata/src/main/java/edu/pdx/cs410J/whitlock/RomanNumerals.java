package edu.pdx.cs410J.whitlock;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is represents a <code>RomanNumerals</code>.
 */                                                                                 
public class RomanNumerals {
  public static String romanNumeralFor(int number) {
    StringBuilder sb = new StringBuilder();

    romanNumeralFor(number, sb);

    return sb.toString();
  }

  private static Map<Integer, String> numeralsForGreaterThan = new LinkedHashMap<>();

  static {
    numeralsForGreaterThan.put(500, "D");
    numeralsForGreaterThan.put(400, "CD");
    numeralsForGreaterThan.put(100, "C");
    numeralsForGreaterThan.put(90, "XC");
    numeralsForGreaterThan.put(50, "L");
    numeralsForGreaterThan.put(40, "XL");
    numeralsForGreaterThan.put(10, "X");
    numeralsForGreaterThan.put(9, "IX");
    numeralsForGreaterThan.put(5, "V");
    numeralsForGreaterThan.put(4, "IV");
    numeralsForGreaterThan.put(1, "I");
  }

  private static void romanNumeralFor(int number, StringBuilder sb) {

    for (int max : numeralsForGreaterThan.keySet()) {
      if (number >= max) {
        sb.append(numeralsForGreaterThan.get(max));
        romanNumeralFor(number - max, sb);
        break;
      }
    }

  }


}