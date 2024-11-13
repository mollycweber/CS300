//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    Course Enrollment implementing dropCourse, addWaitlist, and addOneStudent
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
// Online Sources: 
// Chat GPT: helped me create psuedocode to implement the dropCourse Method.
//
///////////////////////////////////////////////////////////////////////////////



/**
 * TODO add a short description of this class here
 * 
 * @author TODO add your name here
 *
 */

public class CourseEnrollment {

  /**
   * Create an empty new list String[][] with a given capacity. The list should be empty, meaning
   * that it must contain null references only. For instance if the capacity of the list to create
   * is 4, the returned array must contain 4 null references.
   * 
   * @param capacity maximum number of students to be stored in the list. We assume that capacity is
   *                 greater than zero.
   * @return the created list which contains null references only
   */
  public static String[][] createEmptyList(int capacity) {
    // TODO complete the implementation of this method
    String[][] capacityList = new String[capacity][];
    return capacityList; 
  }

  /**
   * Prints the list of all the students enrolled in the course, with respect to the following
   * format.
   * 
   * Maximum capacity: enrollment_capacity<BR>
   * Number of enrolled students: size<BR>
   * 1. name (email, campusId)<BR>
   * 2. name (email, campusId)<BR>
   * ...
   * 
   * Every entry must be in a newline. Each of the students records is printed in the format:
   * "order. name (email, campusId)"
   * 
   * where order represents index+1 of the student records in roster (orders are in the range
   * 1..size and NOT in the range 0..size-1), name, email, and campusId represent the name, email
   * address, and campusId of the enrolled student.
   * 
   * We assume all inputs are valid.
   * 
   * @param roster an oversize two-dimensional of strings storing student records. When roster[i] is
   *               not null, it references a one-dimensional array of strings whose length is
   *               exactly three, and where roster[i][0], roster[i][1], and roster[i][2]
   *               respectively represent the name, email address, and campus Id of the student
   *               record stored at index i.
   * @param size   the number of student records stored in roster.
   */
  public static void printRoster(String[][] roster, int size) {
    // TODO complete the implementation of this method
    
	System.out.println("\nMaximum capacity: " + roster.length);
    System.out.println("Number of enrolled students: " + size);

    int order = 0;
    
    for (int i = 0; i < size; i++)
      if (roster[i] != null) {
        order = order + 1;
        String name = roster[i][0];
        String email = roster[i][1];
        String studentID = roster[i][2];
        String rosterString = order + ". " + name + " (" + email + ", " + studentID + ")";
        
        System.out.println(rosterString);
        
      };
        
      
  }

  /**
   * Prints the list of all the students in the waitlist the course, with respect to the following
   * format.
   * 
   * Waitlist capacity: waitlist_capacity<BR>
   * 1. name (email, campusId)<BR>
   * 2. name (email, campusId)<BR>
   * ...
   * 
   * Every entry must be in a newline. Each of the students records is printed in the format:
   * "order. name (email, campusId)"
   * 
   * where order starts at 1 for the student stored at index 0, name, email, and campusId represent
   * the name, email address, and campusId of the waitlisted student.
   * 
   * We assume all inputs are valid.
   * 
   * @param waitlist a perfect size non-compact two-dimensional of strings storing student records.
   *                 When waitlist[i] is not null, it references a one-dimensional array of strings
   *                 whose length is exactly three, and where waitlist[i][0], waitlist[i][1], and
   *                 waitlist[i][2] respectively represent the name, email address, and campus Id of
   *                 the student record stored at index i.
   */
  public static void printWaitlist(String[][] waitlist) {
    // TODO complete the implementation of this method
    // [HINT] The waitlist is non-compact perfect size array. This means that it can contain null
    // references at any position of the list.
    // Be sure to skip ALL the null references when traversing the array waitlist.
    int waitlistCapacity = waitlist.length;
    int order = 0;
    System.out.println("Waitlist capacity: " + waitlistCapacity);
    for (int i = 0; i < waitlistCapacity; i++)
      if (waitlist[i] != null) {
        order++;
        String name = waitlist[i][0];
        String email = waitlist[i][1];
        String studentID = waitlist[i][2];
        
        System.out.println(order + ". " + name + " (" + email + ", " + studentID + ")");
      };
  }


  /**
   * Returns the index of the student record having an exact match with campusId. The search is made
   * in a two-dimensional oversize array. We assume that campusId values are unique.
   * 
   * @param campusId a 10-digits string. We assume that the format of campusID is valid.
   * @param list     an oversize two-dimensional array of strings storing student records. When list[i] is
   *                 not null, it references a one-dimensional array of strings whose length is
   *                 exactly three, and where list[i][0], list[i][1], and list[i][2] respectively
   *                 represent the name, email address, and campus Id of the student record stored
   *                 at index i. We assume that (1) list is not null, (2) its length is greater than
   *                 zero, and (3) it stores valid/correct student records. We also assume that when
   *                 i is greater or equal to size, list[i] is null.
   * @param size     the number of student records stored in list.
   * @return the index of the record containing an exact match with campusId, and -1 if no match
   *         found.
   */
  public static int indexOf(String campusId, String[][] list, int size) {
    // TODO complete the implementation of this method

    for (int i = 0; i < list.length; i++) {
    // if list[i] not null
      if (list[i] != null) {

        String studentId = list[i][2];

        if (studentId.equals(campusId)){

          return i;
        }
      }
    }

    return -1; // default return statement added to resolve compiler errors
  }

  /**
   * Returns the index of the student record having an exact match with campusId. The search is made
   * in a two-dimensional non-compact perfect size array. We assume that campusId values are unique.
   * 
   * @param campusId a 10-digits string. We assume that the format of campusID is valid.
   * @param list     a non-compact perfect-size two-dimensional of strings storing student records.
   *                 When list[i] is not null, it references a one-dimensional array of strings
   *                 whose length is exactly three, and where list[i][0], list[i][1], and list[i][2]
   *                 respectively represent the name, email address, and campus Id of the student
   *                 record stored at index i. We assume that (1) list is not null, (2) its length
   *                 is greater than zero, and (3) it stores valid/correct student records. We also
   *                 assume that null references can be at any position of the array list and NOT
   *                 necessary pushed to the back of the array.
   * @return the index of the record containing an exact match with campusId, and -1 if no match
   *         found.
   */
  public static int indexOf(String campusId, String[][] list) {
    // TODO complete the implementation of this method
    // [HINT] To avoid NullPointerExceptions, be sure to NOT use null references
    // ALL null references MUST be skipped while traversing the array list
    

    for (int i =0; i < list.length; i++) {
      if (list[i] != null) {
        String studentId = list[i][2];
    // compare list[2] to campusId argument: are they exactly matching?
        if (studentId.equals(campusId)){
          return i;
        }
      }
    }

    return -1;
  }
   

  // We assume the addWaitlist method is only called when the course reaches its enrollment capacity
  /**
   * Adds the student record {name, email, campusId} to the first available position in the
   * waitlist, meaning to the first null reference, if the course pre-requisites are satisfied, the
   * student record is not already in the waitlist, and there is a room to add the new student
   * record to the waitlist.
   * 
   * This method prints the following message is the student record is successfully added to the
   * waitlist:
   * 
   * "You are successfully added to the waitlist of this course."
   * 
   * This method prints the following error message if the pre-requisites of the course are not
   * satisfied:
   * 
   * "Error: You do not meet the prerequisite(s) for this course."
   * 
   * This method prints the following error message if a matching student record is already in the
   * list:
   * 
   * "Error: You are already in the waitlist of this course."
   * 
   * This method prints the following error message if the waitlist is full (meaning it does not
   * contain any null reference).
   * 
   * "Error: Course closed! Waitlist full."
   * 
   * @param name                  name of a student. We assume that name is not null and is not
   *                              blank.
   * @param email                 email address of the student to add. We assume that email ends
   *                              with "@wisc.edu"
   * @param campusId              10-digits campusId. We assume that campusId is valid
   * @param prerequisiteSatisfied boolean, evaluated to true if the prerequisite(s) for this course
   *                              are satisfied, false otherwise.
   * 
   * @param waitlist              a perfect size two-dimensional non-compact array storing an
   *                              ordered list of student records waiting to secure a spot in the
   *                              course. Every of the student records is a one-dimensional array of
   *                              strings whose length is exactly 3. A student record is represented
   *                              by the triplet {name, email, campusId}. This means that
   *                              roster[i][0], roster[i][1], and roster[i][2] represent the name,
   *                              email address, and campusId of the record stored at index i within
   *                              the roster array. Null references can be at any position in the
   *                              list array.
   * @return true if the student record was successfully added to the waitlist, and false otherwise.
   */
  public static boolean addWaitlist(String name, String email, String campusId,
      boolean prerequisiteSatisfied, String[][] waitlist) {
    // TODO complete the implementation of this method
    // Add implementation-level comments to highlight the major algorithmic steps to resolve this
    // method FIRST!
    
    int waitlistSize = 0;
        
    // if already on waitlist
    for (int i=0; i < waitlist.length; i++) {
      if (waitlist[i] != null) {
        waitlistSize++;
        if (waitlist[i][0] == name) {
          System.out.println("Error: You are already in the waitlist of this course.");
          return false;
        }
      }
    }
    
    // if prerecs not satisfied
    if (prerequisiteSatisfied = false) {
      System.out.println("Error: You do not meet the prerequisite(s) for this course.");
      return false;
    }
    
    // if wait is full
    if (waitlistSize >= waitlist.length) {
      System.out.println("Error: Course closed! Waitlist full.");
      return false;
    }
    
    // Will not add to waitlist if previous conditions met
    for (int i=0; i< waitlist.length; i++) {
      String[] tripletValue = {name, email, campusId};
      if (waitlist[i] == null) { 
        waitlist[i] = tripletValue;
      }
    }
  
    System.out.println("You are successfully added to the waitlist of this course.");
    
    // return true meaning one student has been successfully added to the waitlist
    return true;
  }


  /**
   * Enrolls one student given their name, email address and campusId in a specific course. The
   * course enrollment is defined by the course roster (a 2D oversize array) and a waitlist (a 2D
   * compact perfect size array).
   * 
   * 
   * If the student (1) has NOT been already enrolled in the course, (2) satisfies the course
   * pre-requisites and (3) the course roster did not reach each capacity, the student record {name,
   * email, campusId} is added to the end of the array roster, and the size of the roster is
   * incremented by one. In this case, the student is successfully enrolled in the course. The
   * method prints the exact following message and it returns the new size of the roster.
   * 
   * "You are successfully enrolled in this class."
   * 
   * In case there is a match with the student record in the waitlist, the student record must be
   * removed off the waitlist after it is successfully added to the roster. Note that the waitlist
   * is a non-compact perfect size 2D array, meaning that setting the reference of an element stored
   * at a given index to null, removes it off the array.
   * 
   * If the student is already enrolled in the course, no changes are made to the contents of the
   * course enrollment lists (roster and waitlist). The method returns the current size of the
   * roster, and prints the exact following message.
   * 
   * "Error: You are already enrolled in this class."
   * 
   * If the roster is full (reached its capacity), this method does not make any changes to the
   * contents of roster or the waitlist. The method prints the exact following message and it
   * returns the current size of the roster.
   * 
   * "The course is full. Please make another selection or try adding yourself to the waitlist."
   * 
   * If the pre-requisites of the course are NOT satisfied, no changes will be made to the course
   * enrollment lists (roster and waitlist). The method prints the exact following message and it
   * returns the current size of the roster.
   * 
   * "Error: You do not meet the prerequisite(s) for this course."
   * 
   * @param name                  name of a student. We assume that name is not null and is not
   *                              blank.
   * @param email                 email address of the student to add. We assume that email ends
   *                              with "@wisc.edu"
   * @param campusId              10-digits campusId. We assume that campusId is valid
   * @param prerequisiteSatisfied boolean, evaluated to true if the prerequisite(s) for this course
   *                              are satisfied, false otherwise.
   * @param roster                2D oversize array which stores the records of students enrolled in
   *                              the course. Every of the student records is a one-dimensional
   *                              array of strings whose length is exactly 3. A student record is
   *                              represented by the triplet {name, email, campusId}. This means
   *                              that roster[i][0], roster[i][1], and roster[i][2] represent the
   *                              name, email address, and campusId of the record stored at index i
   *                              within the roster array.
   * @param size                  the number of student records stored in roster
   * @param waitlist              2D non-compact perfect size arrays storing the records {name,
   *                              email, campusId} of students in the waitlist of this course.
   * @return the size of roster after successfully enrolling the student in the course, or the input
   *         size if the enrollment fails for any reason.
   */
  public static int enrollOneStudent(String name, String email, String campusId,
      boolean prerequisiteSatisfied, String[][] roster, int size, String[][] waitlist) {
    // TODO Implement this method with respect to the details provided in its javadoc header
    // This method is complex. We highly recommend to break it down into sub-problems.
    // Add implementation level comments highlighting the major algorithmic steps to resolve this
    // method.
    // Feel free to define private static helper methods to help implement this behavior.

//    boolean courseIsFull = true; // Assume the course is full
//    
//    for (int i = 0; i < roster.length; i++) {
//      if (roster[i] == null) {
//        courseIsFull = false; // If any slot is null, the course is not full
//        break;
//        }
//    }
    
    // check if name already in roster
    for (int i=0; i < roster.length; i++) {
      if (roster[i] != null) {
//        size++;
        if (roster[i][0].equals(name)) {
          System.out.println("Error: You are already enrolled in this class.");
          return size;
        }
      }
    }
    
    // if prerecs not satisfied
    if (!prerequisiteSatisfied) {
      System.out.println("Error: You do not meet the prerequisite(s) for this course.");
      return size;
    }
    
    // if course is full    
    if (size == roster.length) {
      System.out.println("The course is full. Please make another selection or try adding yourself "
          + "to the waitlist.");
      return size;
    }
    
    for (int i=0; i< roster.length; i++) {
      String[] tripletValue = {name, email, campusId};
      if (roster[i] == null) { 
        roster[i] = tripletValue;
        //print successfully enrolled statement
        System.out.println("You are successfully enrolled in this class");
        // increment size by 1
        size++;
        break;
      }
    }
    
    // if name in waitlist after being added to roster, remove student from waitlist
    for(int i=0; i < waitlist.length; i++) {
      if (waitlist[i] != null && waitlist[i][0] == name) {
        waitlist[i] = null; 
      }
    }
        
    return size; // default return statement added to resolve compiler errors
  }


  
    // TODO complete the implementation of this method
    // Add implementation-level comments to highlight the major algorithmic steps to resolve this
    // method FIRST!
    
    // convert 2d array to array list 
    /**
     * Removes the student record whose campusId matches the one provided as input off the roster list.
     * We assume that all the inputs are valid and correctly formatted. We also assume that campusIds are unique.
     *
     * The roster array is an ordered oversize array. This means that a successful removal operation
     * must involve a shift operation if the element to be removed is in the range 0..size-2. This
     * means that this method must preserve the order of precedence of the student records stored in
     * the roster array. The size of roster must be decremented by one after successfully removing the
     * student record off the roster.
     *
     * This method prints the following message if the course was successfully dropped.
     *
     * "You just dropped the course. This action cannot be revoked."
     *
     * This method does not make any changes to the contents of the roster array and prints the
     * following message if there is no student record matching the input campusId:
     *
     * "Error: You are not enrolled in the course!"
     *
     * @param campusId 10-digits campusId. We assume that campusId is valid
     * @param roster   2D oversize array storing students records. Every of the student records is a
     *                 one-dimensional array of strings whose length is exactly 3. A student record is
     *                 represented by the triplet {name, email, campusId}. This means that
     *                 roster[i][0], roster[i][1], and roster[i][2] represent the name, email address,
     *                 and campusId of the record stored at index i within the roster array.
     * @param size     number of student records stored in roster
     * @return the size of the roster after the student record was successfully removed, or the same
     *         input size if the drop operation fails for any reason.
     */
  public static int dropCourse(String campusId, String[][] roster, int size) {
        // finding the student and campusId match
      
      
    int matchIdx = -1;
    for (int i = 0; i < size; i++) {
      String idxCampusId = roster[i][2];
      if (roster[i] != null && idxCampusId.equals(campusId)) {
        matchIdx = i;
        break;
      }
    }
      
    // After we have confirmed that the student IS enrolled in the class
    if (matchIdx != -1) {
      // Shift elements to remove the student record
      for (int i = matchIdx; i < size - 1; i++) {
        roster[i] = roster[i + 1];
      }

      roster[size - 1] = null;

      size--;

      System.out.println("You just dropped the course. This action cannot be revoked.");
      } else { 
        System.out.println("Error: You are not enrolled in the course!");
        }

    return size;
  }
}
