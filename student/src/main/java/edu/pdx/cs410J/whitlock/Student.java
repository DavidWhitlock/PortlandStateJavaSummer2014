package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.lang.Human;

import java.util.ArrayList;
                                                                                    
/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {

  static final String USAGE = "usage: java edu.pdx.cs410J.whitlock.Student name gender gpa class*";
  static final String INVALID_GPA = "GPA must be a number between 0.0 and 4.0";
  static final String INVALID_GENDER = "Invalid gender";

  /**
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The student's name                                                      
   * @param classes                                                                 
   *        The names of the classes the student is taking.  A student              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The student's grade point average                                       
   * @param gender                                                                  
   *        The student's gender ("male" or "female", case insensitive)             
   */                                                                               
  public Student(String name, ArrayList classes, double gpa, String gender) {
    super(name);
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
    return null;
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
      String errorMessage = INVALID_GPA;
      printUsageAndExit(errorMessage);

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