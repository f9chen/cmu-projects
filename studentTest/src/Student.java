/*
 * File: Student.java
 * ------------------
 * This file defines the Student class presented in lecture.
 */

/**
 * The Student class keeps track of the following pieces of data
 * about a student: the student's name, ID number, the number of
 * units the student has earned toward graduation, and whether
 * the student is paid up with respect to university bills.
 * All of this information is entirely private to the class.
 * Clients can obtain this information only by using the various
 * methods defined by the class.
 */

public class Student {

/**
 * Creates a new Student object with the specified name and ID.
 * @param name The student's name as a String
 * @param id The student's ID number as an int
 */
	public Student(String name, int id) {
		studentName = name;
		studentID = id;
	}

/**
 * Gets the name of this student.
 * @return The name of this student
 */
	public String getName() {
		return studentName;
	}

/**
 * Gets the ID number of this student.
 * @return The ID number of this student
 */
	public int getID() {
		return studentID;
	}

/**
 * Sets the number of units earned.
 * @param units The new number of units earned
 */
	public void setUnits(int units) {
		unitsEarned = units;
	}

/**
 * Gets the number of units earned.
 * @return The number of units this student has earned
 */
	public int getUnits() {
		return unitsEarned;
	}

/**
 * Sets whether the student is paid up.
 * @param flag The value true or false indicating paid-up status
 */
	public void setPaidUp(boolean flag) {
		paidUp = flag;
	}

/**
 * Returns whether the student is paid up.
 * @return Whether the student is paid up
 */
	public boolean isPaidUp() {
		return paidUp;
	}

/**
 * Creates a string identifying this student.
 * @return The string used to display this student
 */
	public String toString() {
		return studentName + " (#" + studentID + ")";
	}


/* Public constants */

/** The number of units required for graduation */
	public static final int UNITS_TO_GRADUATE = 180;

/* Private instance variables */

	private String studentName; /* The student's name          */
	private int studentID;      /* The student's ID number     */
	private int unitsEarned;    /* The number of units earned  */
	private boolean paidUp;     /* Whether student is paid up  */

}