package edu.pdx.cs410J.whitlock;

import edu.pdx.cs410J.InvokeMainTestCase;
import org.junit.Ignore;
import org.junit.Test;

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

    MainMethodResult result = invokeStudentMain(oneThousandArguments);
    assertThat(result.getExitCode(), equalTo(0));

  }

  @Ignore
  @Test
  public void whenGpaIsNotDoublePrintErrorMessage() {

  }

  @Ignore
  @Test
  public void whenGpaIsLessThanZeroPrintErrorMessage() {

  }

  @Ignore
  @Test
  public void whenGpaIsGreaterThanFourPrintErrorMessage() {

  }

}
