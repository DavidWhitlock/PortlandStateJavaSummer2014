package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Human;

import java.util.List;

/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  static final String USAGE = "usage: java edu.pdx.cs410J.whitlock.Student name gender gpa class*";
  static final String INVALID_GPA = "GPA must be a number between 0.0 and 4.0";
  static final String INVALID_GENDER = "Invalid gender";
  private final double gpa;
  private final List<String> classes;

  /**
   * Creates a new <code>Student</code>
   *  @param name
   *        The student's name
   * @param gender
   *        The student's gender ("male" or "female", case insensitive)
   * @param gpa
 *        The student's grade point average
   * @param classes
   *        The names of the classes the student is taking.  A student
   *        may take zero or more classes.
   */
  public Student(String name, String gender, double gpa, List<String> classes) {
    super(name);
    this.gpa = gpa;
    this.classes = classes;
  }

  /**                                                                               
   * All students say "This class is too much work"                                 
   */
  @Override
  public String says() {                                                            
    return null;
  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {
    return this.name + " has a GPA of " + this.gpa + " and is taking " + formatClasses();
  }

  private String formatClasses() {
    StringBuilder sb = new StringBuilder();
    sb.append(this.classes.size());

    if (this.classes.size() == 1) {
      sb.append(" class");

    } else {
      sb.append(" classes");
    }

    if (this.classes.size() > 0) {
      sb.append(": ");
      sb.append(this.classes.get(0));
    }

    sb.append(".");

    return sb.toString();
  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the student to
   * standard out by invoking its <code>toString</code> method.
   *
   * @param args Command line arguments
   */
  public static void main(String[] args) {
    if (args.length < 6) {
      printUsageAndExit("Not enough command line arguments");
    }

    String gender = validateGender(args[1]);
    double gpa = validateGpa(args[2]);

    System.exit(0);
  }

  /**
   * Validates that a gpa is a validate double.  If <code>arg</code> is not a valid double, the
   * program exits
   *
   * @param arg The string to parse
   * @return The parsed value of the double
   */
  private static double validateGpa(String arg) {
    double gpa;
    try {
      gpa = Double.parseDouble(arg);

    } catch (NumberFormatException ex) {
      printUsageAndExit(INVALID_GPA);
      throw new AssertionError("Should never get here");
    }

    if (gpa < 0.0 || gpa > 4.0) {
      printUsageAndExit(INVALID_GPA);
      throw new AssertionError("Should never get here");
    }

    return gpa;
  }

  private static void printUsageAndExit(String errorMessage) {
    System.err.println(errorMessage);
    System.err.println();
    System.err.println(USAGE);

    System.exit(1);
  }

  private static String validateGender(String gender) {
    if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) {
      printUsageAndExit(INVALID_GENDER);
    }

    return gender;
  }
}