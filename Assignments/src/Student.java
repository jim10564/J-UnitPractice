import java.util.*;
/**
 * A class representing students for a simple BlueJ demo program.
 * Original BlueJ example
 * @author Michael Kölling (BlueJ)
 * @version 1.0, January 1999
 */
class Student
{
//    Add new members to the student class, these members are; age and gpa (choose proper types for the members)
//    Make sure to add the new members to the constructors (default and parameter constructors).
//    Add helper methods (get and set methods) for age and gpa.
//    Write a new method to check if the student can or cannot drive based on their age (can drive if the age is 16 or above).
//    Write tests for SID, age and gpa  (like the test you did for name in CW1).
//    Write number of tests to check the new methods with different cases (different age inputs).
//    Submit all files in the project’s folder.



    private int StudentAge;
    private double StudentGPA;
    private String SID; // student ID number
    private String name;



    // Create a student with default settings for detail information.
    Student()
    {

        SID = "(unknown ID)";
        name = "no name";
        StudentAge = -1;
        StudentGPA = -1;
        SID = " ";
    }
    // Create a student with given name, year of birth and student ID
    Student(String name, String studentID, int age, double gpa)
    {
        StudentAge = age;
        StudentGPA = gpa;
        SID = studentID;
        this.name = name;
    }

    public Student(int studentAge) {
        StudentAge = studentAge;
    }

    public void setStudentAge(int studentAge) {
        StudentAge = studentAge;
    }

    public void setStudentGPA(double studentGPA) {
        StudentGPA = studentGPA;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public int getStudentAge() {
        return StudentAge;
    }

    public double getStudentGPA() {
        return StudentGPA;
    }

    public String getSID() {
        return SID;
    }


    // Return the student ID of this student.
    public String getStudentID()
    {
        return SID;
    }
    // Set a new name for this person.
    public void setName(String name)
    {
        this.name = name;
    }
    // Return the name of this person.
    public String getName()
    {
        return name;
    }

    public String calculateGrade() {
//        double gpa = StudentGPA;
//        if (gpa == 4.0) return "A";
//        else if (gpa >= 3.7) return "A-";
//        else if (gpa >= 3.3) return "B+";
//        else if (gpa >= 3.0) return "B";
//        else if (gpa >= 2.7) return "B-";
//        else if (gpa >= 2.3) return "C+";
//        else if (gpa >= 2.0) return "C";
//        else if (gpa >= 1.7) return "C-";
//        else if (gpa >= 1.3) return "D+";
//        else if (gpa >= 1.0) return "D";
//        else if (gpa >= 0.7) return "D-";
//        else if (gpa >= 0) return "E";
//        else return "Invalid GPA";

        int[] example = new int[]{0, 1, 2};


        HashMap<Double, String> map = new HashMap<>();
        double gpa = roundToTenth(StudentGPA);
        double[] grades = {4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0};
        String[] letterGrades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"};
        for (int i = 0; i < grades.length; i++)  map.put(grades[i], letterGrades[i]);
        if (map.get(gpa) == null)  return "Invalid GPA";
        return map.get(gpa);
    }

    public double roundToTenth(double numToRound){
        return Math.round(numToRound * 100.0) / 100.0;
    }

    public boolean canDrive(){

        return Math.max(StudentAge, 15) == StudentAge;

    }
    // Return a string representation of this object.
    public String toString()
    {
        return super.toString() +
                "Student name: "+ name + "\n" +
                "Student ID: " + SID + "\n";
    }
}
