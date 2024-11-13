//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Course Enrollment Tester
// Course:   CS 300 Fall 2023
//
// Author:   Molly Weber
// Email:    mcweber@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    None
// Partner Email:   None
// Partner Lecturer's Name: None
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         None
// Online Sources:  None
//
///////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;

/**
 * This utility class implements unit tests to check the correctness of methods defined in the
 * CourseEnrollment class of the Course Enrollment System program.
 *
 */
public class CourseEnrollmentTester {


  /**
   * Ensures the correctness of the createEmptyList() method
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean createEmptyListTester() {
    String errMsg = "Bug detected: createEmptyList did not return the expected array.";
    // Create an empty list String[][] whose capacity is 5
    String[][] actual = CourseEnrollment.createEmptyList(5);
    String[][] expected = new String[5][];
    // same as expected = new String[][]{null, null, null, null, null}

    if (!Arrays.deepEquals(actual, expected)) {
      // Recommended: descriptive error messages to help locating the bug
      System.out.println(errMsg);
      System.out.println("Expected: " + Arrays.deepToString(expected));
      System.out.println("Actual: " + Arrays.deepToString(actual));
      return false;
    }


    // Try a different capacity: create an empty list String[][] whose capacity is 8
    actual = CourseEnrollment.createEmptyList(8);
    expected = new String[8][];
    // same as expected = new String[][]{null, null, null, null, null}

    if (!Arrays.deepEquals(actual, expected)) {
      // descriptive error messages to help locating the bug
      System.out.println(errMsg);
      System.out.println("Expected: " + Arrays.deepToString(expected));
      System.out.println("Actual: " + Arrays.deepToString(actual));
      return false;
    }

    return true; // expected behavior verified, no bugs detected!
  }

  /**
   * Ensures the correctness of the indexOf(String, String[][]) method
   * 
   * Expected behavior to be verified:<BR>
   * (+) Correct index returned for multiple cases (normal and edge cases)<BR>
   * (+) No changes made to the contents of the input list<BR>
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean indexOfPerfectSizeArrayTester() {
    // TODO complete the implementation of this method
    
    String[][] littleWomenArray = {
        {"Meg", "meg@wisc.edu", "0987654321"}, 
        {"Jo", "jo@wisc.edu", "9876543210"}, 
        {"Amy", "amy@wisc.edu", "8765432109"}, 
        {"Beth", "beth@wisc.edu", "7654321098"}, 
    };
    
    String[][] littleWomenCopy = new String[littleWomenArray.length][];
    for (int i = 0; i < littleWomenCopy.length; i++) {
        littleWomenCopy[i] = Arrays.copyOf(littleWomenArray[i], littleWomenArray[i].length);
    }
    // Define four test cases
    // (1) edge case: match found at index 0
    
    int megExpectedIndex = 0; 
    int megActualIndex = CourseEnrollment.indexOf("0987654321", littleWomenArray); 
    
    if (megExpectedIndex != megActualIndex) {
      System.out.println("Perfect Array Edge Case 1 failed :(");
      System.out.println("Expected Index: " + megExpectedIndex);
      System.out.println("Actual Index: " + megActualIndex);
      return false;
    }
    
    // (2) edge case: match found at index length-1 considering a full input array
    
    int bethExpectedIndex = 3; 
    int bethActualIndex = CourseEnrollment.indexOf("7654321098", littleWomenArray); 
    
    if (bethExpectedIndex != bethActualIndex) {
      System.out.println("Perfect Array Edge Case 2 failed :(");
      System.out.println("Expected Index: " + bethExpectedIndex);
      System.out.println("Actual Index: " + bethActualIndex);
      return false;

    }
    
    // (3) normal case: match found at the middle of the input array
    
    int joExpectedIndex = 1; 
    int joActualIndex = CourseEnrollment.indexOf("9876543210", littleWomenArray); 
    
    if (joExpectedIndex != joActualIndex) {
      System.out.println("Perfect Array Edge Case 3 failed :(");
      System.out.println("Expected Index: " + joExpectedIndex);
      System.out.println("Actual Index: " + joActualIndex);
      return false;
    }

    // (4) normal case: no match found, -1 should be returned
    
    int laurieExpectedIndex = -1; 
    int laurieActualIndex = CourseEnrollment.indexOf("5678901234", littleWomenArray); 
    
    if (laurieExpectedIndex != laurieActualIndex) {
      System.out.println("Perfect Array Edge Case 4 failed :(");
      System.out.println("Expected Index: " + laurieExpectedIndex);
      System.out.println("Actual Index: " + laurieActualIndex);
      return false;
    }

    // Test no changes made to the contents of the input list
    
    if (!Arrays.deepEquals(littleWomenArray, littleWomenCopy)) {
      System.out.println("Error: changes made to contents of original input list.");
      return false;
    }
   
    return true; // default return statement added to resolve compiler errors
  }

  /**
   * Ensures the correctness of the indexOf(String, String[][], int) method
   * 
   * Expected behavior to be verified:<BR>
   * (+) Correct index returned for multiple cases (normal and edge cases)<BR>
   * (+) No changes made to the contents of the input list<BR>
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean indexOfOversizeSizeArrayTester() {
    // TODO complete the implementation of this method

    // create oversized array 
    String[][] littleWomenArray = {
        {"Meg", "meg@wisc.edu", "0987654321"}, 
        {"Jo", "jo@wisc.edu", "9876543210"}, 
        {"Amy", "amy@wisc.edu", "8765432109"}, 
        null,         
        {"Beth", "beth@wisc.edu", "7654321098"},
        null, null, null
    };
    
    // create copy of original oversized array
    
    String[][] littleWomenCopy = new String[littleWomenArray.length][];
    for (int i = 0; i < littleWomenCopy.length; i++) {
      if (littleWomenArray[i] != null) {
        littleWomenCopy[i] = Arrays.copyOf(littleWomenArray[i], littleWomenArray[i].length);
      } else {
        littleWomenCopy[i] = null;
      }
    }
    
    // (1) edge case: match found at index 0
    
    int megExpectedIndex = 0; 
    int megActualIndex = CourseEnrollment.indexOf("0987654321", littleWomenArray); 
    
    if (megExpectedIndex != megActualIndex) {
      System.out.println("Oversized Array Edge Case 1 failed :(");
      System.out.println("Expected Index: " + megExpectedIndex);
      System.out.println("Actual Index: " + megActualIndex);
      return false;
    }
    
    // (2) edge case: match found at index size-1 considering an oversize array
    
    int bethExpectedIndex = 4; 
    int bethActualIndex = CourseEnrollment.indexOf("7654321098", littleWomenArray); 
    
    if (bethExpectedIndex != bethActualIndex) {
      System.out.println("Oversized Array Edge Case 2 failed :(");
      System.out.println("Expected Index: " + bethExpectedIndex);
      System.out.println("Actual Index: " + bethActualIndex);
      return false;

    }
    
    // (3) normal case: match found at the middle of the input array
    
    int joExpectedIndex = 1; 
    int joActualIndex = CourseEnrollment.indexOf("9876543210", littleWomenArray); 
    
    if (joExpectedIndex != joActualIndex) {
      System.out.println("Oversized Array Edge Case 3 failed :(");
      System.out.println("Expected Index: " + joExpectedIndex);
      System.out.println("Actual Index: " + joActualIndex);
      return false;
    }
    
    // (4) normal case: no match found, -1 should be returned
    
    int laurieExpectedIndex = -1; 
    int laurieActualIndex = CourseEnrollment.indexOf("5678901234", littleWomenArray); 
    
    if (laurieExpectedIndex != laurieActualIndex) {
      System.out.println("Oversized Array Edge Case 4 failed :(");
      System.out.println("Expected Index: " + laurieExpectedIndex);
      System.out.println("Actual Index: " + laurieActualIndex);
      return false;
    }

    // Test no changes made to the contents of the input list
    
    if (!Arrays.deepEquals(littleWomenArray, littleWomenCopy)) {
      System.out.println("Error: changes made to contents of original input list.");
      return false;
    }
    
    return true; // default return statement added to resolve compiler errors
  }

  // Helper method to compare actual and expected oversize roster arrays
  /**
   * Helper method defined to help verifying the actual roster and waitlist arrays with respect to
   * the expected ones
   * 
   * @param methodName     name of the method being tested
   * @param actualRoster   actual roster
   * @param expectedRoster expected roster
   * @param actualSize     actual roster size
   * @param expectedSize   expected roster size
   * 
   * @return true if expected behavior satisfied, false if any bug is detected
   */
  private static boolean assessDeepEqualOversizeArraysHelper(String methodName,
      String[][] actualRoster, String[][] expectedRoster, int actualSize, int expectedSize) {
    // error messages
    String errMsgBadSize =
        "Bug detected: Your " + methodName + "() method did not return the expected size.";
    String errMsgBadRoster = "Bug detected: The contents of the roster array was not as expected "
        + "after " + "your " + methodName + "() method returned.";

    // check roster size
    if (actualSize != expectedSize) {
      System.out.println(errMsgBadSize);
      System.out.println("Expected size: " + expectedSize + ". Actual size: " + actualSize);
      return false;
    }

    // compare roster contents
    if (!Arrays.deepEquals(actualRoster, expectedRoster)) {
      System.out.println(errMsgBadRoster);
      System.out.println("Expected Roster: " + Arrays.deepToString(expectedRoster));
      System.out.println("Actual Roster: " + Arrays.deepToString(actualRoster));
      return false;
    }

    return true; // expected behavior satisfied, no bugs detected
  }

  // Helper method to compare actual and expected oversize roster arrays
  /**
   * Helper method defined to help verifying the actual roster and waitlist arrays with respect to
   * the expected ones
   * 
   * @param methodName       name of the method being tested
   * @param actualWaitlist   actual waitlist
   * @param expectedWaitlist expected waitlist
   * 
   * @return true if expected behavior satisfied, false if any bug is detected
   */
  private static boolean assessDeepEqualPerfectSizeArraysHelper(String methodName,
    String[][] actualWaitlist, String[][] expectedWaitlist) {
    // error message
    String errMsgBadWaitlist =
        "Bug detected: The contents of the waitlist array was not as expected after " + "your "
            + methodName + "() method returned";

    // compare waitlist contents
    if (!Arrays.deepEquals(actualWaitlist, expectedWaitlist)) {
      System.out.println(errMsgBadWaitlist);
      System.out.println("Expected Waitlist: " + Arrays.deepToString(expectedWaitlist));
      System.out.println("Actual Waitlist: " + Arrays.deepToString(actualWaitlist));
      return false;
    }
    return true; // expected behavior satisfied, no bugs detected
  }

  /**
   * Ensures the correctness of the enrollOneStudent() method when called to enroll one student
   * record in the course. The course did not reach its capacity and the course pre-requisites are
   * satisfied.
   * 
   * Expected behavior to be verified:<BR>
   * (+) Student record correctly added to the end of the roster array<BR>
   * (+) No changes made to the waitlist array<BR>
   * (+) Correct size returned
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean enrollOneStudentTester() {
    // You do not need to make changes to this method
    // create a waitlist array. We can consider a normal case: not-empty and not-full waitlist)
    String[][] actualWaitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

    // No changes to the waitlist are expected
    String[][] expectedWaitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

    // This method considers three test cases:
    // (1) edge case: adding to an empty roster
    // (2) normal case: adding to the end of a non-empty roster
    // (3) edge case: after adding the student record, the roster is full

    // To avoid code redundancy, we defined a helper method named verifyCorrectBehaviorHelper() to
    // help verifying the expected behavior for each of the above test cases.

    // --------------------------------------------------------------------------
    // (1) edge case Enroll a student considering an empty roster oversize array
    // enroll one student satisfying prerequisites
    // Create an empty roster
    String[][] actualRoster = new String[3][];
    int actualSize = 0;


    actualSize = CourseEnrollment.enrollOneStudent("George", "george@wisc.edu", "9780563421", true,
      actualRoster, actualSize, actualWaitlist);

    String[][] expectedRoster =
      new String[][] {{"George", "george@wisc.edu", "9780563421"}, null, null};
    int expectedSize = 1;
    boolean resultCase1 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
      expectedRoster, actualSize, expectedSize);

    // --------------------------------------------------------------------------
    // (2) normal case: adding to the end of a non-empty roster
    actualRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};
    actualSize = 2;

    actualSize = CourseEnrollment.enrollOneStudent("Matt", "matt@wisc.edu", "9745632180", true,
        actualRoster, actualSize, actualWaitlist);

    expectedRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"}, null};
    expectedSize = 3;
    boolean resultCase2 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
      expectedRoster, actualSize, expectedSize);

    // --------------------------------------------------------------------------
    // (3) edge case: after adding the student record, the roster is full
    actualRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"}, null};
    actualSize = 3;


    actualSize = CourseEnrollment.enrollOneStudent("Lisa", "lisa@wisc.edu", "9784563211", true,
        actualRoster, actualSize, actualWaitlist);
    // expected roster and its size
    expectedRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
      
        {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"},
        {"Lisa", "lisa@wisc.edu", "9784563211"}};
    expectedSize = 4;
    boolean resultCase3 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
        expectedRoster, actualSize, expectedSize);

    boolean assessWaitlistContents = assessDeepEqualPerfectSizeArraysHelper("enrollOneStudent",
        actualWaitlist, expectedWaitlist);

    // test passes only if each of the defined test scenarios passes
    return resultCase1 && resultCase2 && resultCase3 && assessWaitlistContents;
  }


  /**
   * Ensures the correctness of the enrollOneStudent() method when called to enroll one student
   * record in the course. The student record is in the waitlist, course pre-requisites are
   * satisfied, and there is room in the roster to enroll the student in the course.
   * 
   * Expected behavior to be verified:<BR>
   * (+) Student record correctly added to the end of the roster array<BR>
   * (+) Matching student correctly record removed off the waitlist<BR>
   * (+) Correct size returned
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean enrollOneStudentMoveFromWaitlistTester() {
    // TODO complete the implementation of this method
    
    // Create empty roster array (with null values)
    String[][] actualRoster = CourseEnrollment.createEmptyList(5);
    // Count of actualRosterSize = 0, only null values
    int actualRosterSize = 0;
        
    // Create waitlist with a student to be removed from waitlist and added to Roster
    String[][] actualWaitlist = new String[][] {{"Molly", "molly@wisc.edu", "1234567890"}, null};
    
    // EnrollOneStudent returns size of roster
    actualRosterSize = CourseEnrollment.enrollOneStudent("Molly", "molly@wisc.edu", "1234567890", 
        true, actualRoster, actualRosterSize, actualWaitlist);
    
    // Expected roster and expected rosterSize after enrollment 
    String[][] expectedRoster = new String[][] {{"Molly", "molly@wisc.edu", "1234567890"}, null, 
        null, null, null};
    int expectedRosterSize = 1; 
    
    // Expected waitlist and waitlist size after enrollment; 
    String[][] expectedWaitlist = new String[][] {null, null};
    
    boolean rosterResult = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster, 
        expectedRoster, actualRosterSize, expectedRosterSize);
    boolean assessWaitlistContents = assessDeepEqualPerfectSizeArraysHelper(
        "enrollOneStudentMoveFromWaitlist", actualWaitlist, expectedWaitlist);
    
    return rosterResult && assessWaitlistContents; // default return statement added to resolve compiler errors
  }

  /**
   * Ensures the correctness of the dropCourse() method when called to remove an existing student
   * record from a course enrollment roster of the class.
   * 
   * Expected behavior to be verified:<BR>
   * (+) Matching student record correctly removed off the input roster array. Order of precedence
   * of the student records must be preserved.<BR>
   * (+) Correct size returned
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean successfulDropCourseTester() {
    // TODO complete the implementation of this method


    String[][] actualRoster = {{"John", "john@wisc.edu", "0987654321"}, {"George", 
        "george@wisc.edu", "9876054321"}, null, null};
    int actualRosterSize = 2; 
    
    actualRosterSize = CourseEnrollment.dropCourse("0987654321", actualRoster, actualRosterSize);
    
    String[][] expectedRoster = new String[][] {{"George", "george@wisc.edu", "9876054321"}, 
        null, null, null};
    int expectedRosterSize = 1; 
    
    boolean rosterResult = assessDeepEqualOversizeArraysHelper("dropCourse", actualRoster, 
        expectedRoster, actualRosterSize, expectedRosterSize);
    
    boolean assessRosterContents = assessDeepEqualPerfectSizeArraysHelper(
        "dropCourse", actualRoster, expectedRoster);
    
    return rosterResult && assessRosterContents; 
    
  }

  /**
   * Ensures the correctness of the dropCourse() method when called to remove a non-existing 
   * student record from a course enrollment roster of the class.
   * 
   * Expected behavior to be verified:<BR>
   * (+) No changes made to the input roster array: Fail to find a matching student record .<BR>
   * (+) Correct size returned (same size passed as input to the method)
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean unsuccessfulDropCourseTester() {
    // TODO complete the implementation of this method
    // create actual roster 
    String[][] actualRoster = new String[][] {{"John", "john@wisc.edu", "0987654321"}, {"George", 
        "george@wisc.edu", "9876054321"}, null, null};
    int actualRosterSize = 2; 
    
    // find actual Roster Size after "dropping" the course with dropCourse and nonexistent studnet
    actualRosterSize = CourseEnrollment.dropCourse("7654321098", actualRoster, actualRosterSize);
    
    // create expectedRoseter Array (no changes made)
    String[][] expectedRoster = new String[][] {{"John", "john@wisc.edu", "0987654321"},  
        {"George", "george@wisc.edu", "9876054321"}, null, null};
    int expectedRosterSize = 2; 
    
    boolean rosterResult = assessDeepEqualOversizeArraysHelper("dropCourse", actualRoster, 
        expectedRoster, actualRosterSize, expectedRosterSize);
    
    boolean assessRosterContents = assessDeepEqualPerfectSizeArraysHelper(
        "dropCourse", actualRoster, expectedRoster);
    
    return rosterResult && assessRosterContents;
    // 
    
//    return false; // default return statement added to resolve compiler errors
  }


  /**
   * Runs all the tester methods defined in this class.
   * 
   * @return true if no bugs are detected.
   */
  public static boolean runAllTests() {
    boolean createEmptyListTesterResult = createEmptyListTester();
    System.out
        .println("createEmptyListTester: " + (createEmptyListTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean indexOfOversizeSizeArrayTesterResult = indexOfOversizeSizeArrayTester();
    System.out.println("indexOfOversizeSizeArrayTester: "
        + (indexOfOversizeSizeArrayTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean indexOfPerfectSizeArrayTesterResult = indexOfPerfectSizeArrayTester();
    System.out.println("indexOfPerfectSizeArrayTester: "
        + (indexOfPerfectSizeArrayTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean enrollOneStudentTesterResult = enrollOneStudentTester();
    System.out
        .println("enrollOneStudentTester: " + (enrollOneStudentTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean enrollOneStudentMoveFromWaitlistTesterResult = enrollOneStudentMoveFromWaitlistTester();
    System.out.println("enrollOneStudentMoveFromWaitlistTester: "
        + (enrollOneStudentMoveFromWaitlistTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean successfulDropCourseTesterResult = successfulDropCourseTester();
    System.out.println(
        "successfulDropCourseTester: " + (successfulDropCourseTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean unsuccessfulDropCourseTesterResult = unsuccessfulDropCourseTester();
    System.out.println("unsuccessfulDropCourseTester: "
        + (unsuccessfulDropCourseTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");

    return createEmptyListTesterResult && indexOfOversizeSizeArrayTesterResult
        && indexOfPerfectSizeArrayTesterResult && enrollOneStudentTesterResult
        && enrollOneStudentMoveFromWaitlistTesterResult && successfulDropCourseTesterResult
        && unsuccessfulDropCourseTesterResult;
  }

  /**
   * Main method to run this tester class.
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("-----------------------------------------------");
    System.out.println("runAllTests: " + (runAllTests() ? "Pass" : "Failed!"));
  }

}
