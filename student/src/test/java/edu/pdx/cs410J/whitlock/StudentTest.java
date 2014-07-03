package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Test;

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
    assertThat(result.getErr(), result.getExitCode(), equalTo(0));
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
  public void zeroClassesIsValid() {
    assertThatArgumentsAreValid("name", "male", "3.45");
  }

  @Test
  public void exampleFromAssignment() {
    MainMethodResult result = invokeStudentMain("Dave", "male", "3.64", "Algorithms", "Operating Systems", "Java");
    assertThat(result.getExitCode(), equalTo(0));
    assertThat(result.getOut(), containsString("Dave has a GPA of 3.64 and is taking 3 classes: Algorithms, Operating Systems, and Java. He says \"This class is too much work\"."));
  }

}
