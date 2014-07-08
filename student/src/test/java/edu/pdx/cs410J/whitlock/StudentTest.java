package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static edu.pdx.cs410J.whitlock.Student.Gender.FEMALE;
import static edu.pdx.cs410J.whitlock.Student.Gender.MALE;
import static edu.pdx.cs410J.whitlock.Student.INVALID_GENDER;
import static edu.pdx.cs410J.whitlock.Student.INVALID_GPA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.StringContains.containsString;

/**
 * JUnit tests for the Student class.  These tests extend <code>InvokeMainTestCase</code>
 * which allows them to easily invoke the <code>main</code> method of <code>Student</code>.
 * They also make use of the <a href="http://hamcrest.org/JavaHamcrest/">hamcrest</a>matchers
 * for more readable assertion statements.
 */
public class StudentTest extends InvokeMainTestCase
{

  @Test
  public void invokingMainWithNoArgumentsHasExitCodeOf1() {
    MainMethodResult result = invokeStudentMain();
    assertThat(result.getExitCode(), equalTo(1));
  }

  private MainMethodResult invokeStudentMain(String... args) {
    return invokeMain(Student.class, args);
  }

  @Test
  public void invokingMainWithNoArgumentsPrintsMissingArgumentsToStandardError() {
    String errorMessage = "Not enough command line arguments";
    assertThatStandardErrorContains(errorMessage);
  }

  private void assertThatStandardErrorContains(String errorMessage, String... args) {
    MainMethodResult result = invokeStudentMain(args);
    assertThat(result.getErr(), containsString(errorMessage));
    assertThat(result.getExitCode(), equalTo(1));
  }

  @Test
  public void oneCommandLineArgumentPrintsMissingArgumentsToStandardError() {
    String errorMessage = "Not enough command line arguments";
    assertThatStandardErrorContains(errorMessage, "fail");
  }

  @Test
  public void whenArgumentAreMissingUsageMessageIsPrintedToStandardError() {
    assertThatStandardErrorContains(Student.USAGE);
  }

  @Test
  public void whenThereAreOneThousandsArgumentsExitCodeIsZero() {
    String[] oneThousandArguments = new String[1000];
    for (int i = 0; i < 1000; i++) {
      oneThousandArguments[i] = String.valueOf(i);
    }

    oneThousandArguments[0] = "Name";
    oneThousandArguments[1] = "female";

    assertThatArgumentsAreValid(oneThousandArguments);
  }

  @Test
  public void nameWithNonAsciiCharactersIsValid() {
    assertThatArgumentsAreValid("H\u00E4ns", "male", "3", "4", "5", "6");
  }

  private void assertThatArgumentsAreValid(String... args) {
    MainMethodResult result = invokeStudentMain(args);
    assertThat(result.getExitCode(), equalTo(0));
  }

  @Test
  public void whenGenderIsMaleExitCodeIsZero() {
    assertThatArgumentsAreValid("name", "male", "3", "4", "5", "^");
  }

  @Test
  public void whenGenderIsFemaleExitCodeIsZero() {
    assertThatArgumentsAreValid("name", "female", "3", "4", "5", "^");
  }

  @Test
  public void caseInsensitiveMaleGenderIsValid() {
    assertThatArgumentsAreValid("name", "MaLe", "3", "4", "5", "6");
  }

  @Test
  public void caseInsensitiveFemaleGenderIsValid() {
    assertThatArgumentsAreValid("name", "FeMaLe", "3", "4", "5", "6");
  }

  @Test
  public void whenGenderIsNeitherMaleNorFemaleErrorMessageIsIssued() {
    String errorMessage = INVALID_GENDER;
    assertThatStandardErrorContains(errorMessage, "name", "invalid", "3", "4", "5", "^");
  }

  @Test
  public void whenGpaIsNotDoublePrintErrorMessage() {
    String errorMessage = INVALID_GPA;
    assertThatStandardErrorContains(errorMessage, "name", "female", "three-point-nine", "4", "5", "6");
  }

  @Test
  public void whenGpaIsLessThanZeroPrintErrorMessage() {
    String errorMessage = INVALID_GPA;
    assertThatStandardErrorContains(errorMessage, "name", "female", "-1.0", "4", "5", "6");
  }

  @Test
  public void whenGpaIsGreaterThanFourPrintErrorMessage() {
    String errorMessage = INVALID_GPA;
    assertThatStandardErrorContains(errorMessage, "name", "female", "5.0", "4", "5", "6");
  }

  @Test
  public void toStringContainsStudentName() {
    String name = "Name";
    Student student = new Student(name, MALE, 3.45, new ArrayList<String>());

    assertThat(student.toString(), containsString(name));
  }

  @Test
  public void toStringContainsGpa() {
    double gpa = 3.45;
    Student student = new Student("Name", MALE, gpa, new ArrayList<String>());

    assertThat(student.toString(), containsString(String.valueOf(gpa)));
  }

  @Test
  public void toStringContainsNameAndGpa() {
    Student student = new Student("Name", FEMALE, 3.45, new ArrayList<String>());

    assertThat(student.toString(), containsString("Name has a GPA of 3.45"));
  }

  @Test
  public void toStringWithZeroClasses() {
    Student student = new Student("Name", FEMALE, 3.45, new ArrayList<String>());

    assertThat(student.toString(), containsString("is taking 0 classes."));
  }

  @Test
  public void toStringWithOneClass() {
    Student student = new Student("Name", FEMALE, 3.45, Arrays.asList("Java"));

    assertThat(student.toString(), containsString("is taking 1 class: Java."));
  }

  @Test
  public void toStringWithTwoClasses() {
    Student student = new Student("Name", MALE, 3.45, Arrays.asList("Java", "Operating Systems"));

    assertThat(student.toString(), containsString("is taking 2 classes: Java and Operating Systems."));
  }

  @Test
  public void toStringWithThreeClasses() {
    Student student = new Student("Name", MALE, 3.45, Arrays.asList("Java", "Operating Systems", "Compilers"));

    assertThat(student.toString(), containsString("is taking 3 classes: Java, Operating Systems, and Compilers."));
  }

  @Test
  public void toStringWithFourClasses() {
    Student student = new Student("Name", MALE, 3.45, Arrays.asList("Java", "Operating Systems", "Compilers", "Poetry"));

    assertThat(student.toString(), containsString("is taking 4 classes: Java, Operating Systems, Compilers, and Poetry."));
  }

  @Test
  public void toStringWithFemaleStudentContainsShePronoun() {
    Student student = new Student("Name", FEMALE, 3.45, new ArrayList<String>());

    assertThat(student.toString(), containsString("She says"));
  }

  @Test
  public void toStringWithMaleStudentContainsHePronoun() {
    Student student = new Student("Name", MALE, 3.45, new ArrayList<String>());

    assertThat(student.toString(), containsString("He says"));
  }

  @Test
  public void allStudentsSayThisClassIsTooMuchWorkInToString() {
    Student student = new Student("Name", MALE, 3.45, new ArrayList<String>());

    assertThat(student.toString(), containsString("\"This class is too much work\"."));
  }

  @Ignore
  @Test
  public void commandLineExampleFromAssignment() {
    MainMethodResult result = invokeStudentMain("Dave", "male", "3.64", "Algorithms", "Operating Systems", "Java");

    assertThat(result.getExitCode(), equalTo(0));
    assertThat(result.getOut(), containsString("Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, " +
      "Operating Systems, and Java. He says \"This class is too much work\"."));
  }

}
