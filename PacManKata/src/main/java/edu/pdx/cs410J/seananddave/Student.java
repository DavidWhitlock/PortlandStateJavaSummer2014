package edu.pdx.cs410J.seananddave;

import edu.pdx.cs410J.lang.Human;

import java.util.ArrayList;
                                                                                    
/**                                                                                 
 * This class is represents a <code>Student</code>.                                 
 */                                                                                 
public class Student extends Human {                                                
                                                                                    
  /**                                                                               
   * Creates a new <code>Student</code>                                             
   *                                                                                
   * @param name                                                                    
   *        The PacManKata's name                                                      
   * @param classes                                                                 
   *        The names of the classes the PacManKata is taking.  A PacManKata              
   *        may take zero or more classes.                                          
   * @param gpa                                                                     
   *        The PacManKata's grade point average                                       
   * @param gender                                                                  
   *        The PacManKata's gender ("male" or "female", case insensitive)             
   */                                                                               
  public Student(String name, ArrayList classes, double gpa, String gender) {

  }

  /**                                                                               
   * All PacManKatas say "This class is too much work"                                 
   */
  @Override
  public String says() {                                                            

  }
                                                                                    
  /**                                                                               
   * Returns a <code>String</code> that describes this                              
   * <code>Student</code>.                                                          
   */                                                                               
  public String toString() {

  }

  /**
   * Main program that parses the command line, creates a
   * <code>Student</code>, and prints a description of the PacManKata to
   * standard out by invoking its <code>toString</code> method.
   */
  public static void main(String[] args) {

  }
}