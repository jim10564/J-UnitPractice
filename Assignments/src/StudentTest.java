import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

//    Add new members to the student class, these members are; age and gpa (choose proper types for the members)
//    Make sure to add the new members to the constructors (default and parameter constructors).
//    Add helper methods (get and set methods) for age and gpa.
//    Write a new method to check if the student can or cannot drive based on their age (can drive if the age is 16 or above).
//    Write tests for SID, age and gpa  (like the test you did for name in CW1).
//    Write number of tests to check the new methods with different cases (different age inputs).
//    Submit all files in the project’s folder.
class StudentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getStudentID() {
    }

    @Test
    void setName() {
        Student student1 = new Student();
        student1.setName("Manuel");
        assertEquals("Manuel", student1.getName());
    }

    @Test
    void getName() {
    }

    @Test
    void testToString() {
    }

    @Test
    void setStudentAge() {
        //Student 1 should be true
        Student student1 = new Student();
        student1.setStudentAge(20);
        assertEquals(20, student1.getStudentAge());


        Student student2 = new Student();
        student2.setStudentAge(18);
        assertEquals(18, student2.getStudentAge());
    }

    @Test
    void setStudentGPA() {
        Student student1 = new Student();
        student1.setStudentGPA(3.5);
        assertEquals(3.5, student1.getStudentGPA());

        Student student2 = new Student();
        student2.setStudentGPA(3.8);
        assertEquals(3.8, student2.getStudentGPA());
    }

    @Test
    void setSID() {
    }

    @Test
    void getStudentAge() {

    }

    @Test
    void getStudentGPA() {
    }

    @Test
    void getSID() {
        Student student1 = new Student();
        student1.setSID("123");
        assertEquals("123", student1.getSID());
    }

    @Test
    void testGetStudentID() {
    }

    @Test
    void testSetName() {
    }

    @Test
    void testGetName() {
    }

    @Test
    void canDrive() {
        Student student1 = new Student();
        student1.setStudentAge(20);
        assertEquals(true, student1.canDrive());

        Student student2 = new Student();
        student2.setStudentAge(14);
        assertEquals(false, student2.canDrive());

        Student student3 = new Student();
        student3.setStudentAge(16);
        assertEquals(true, student3.canDrive());

    }

    @Test
    void calculateGrade() {

        assertAll(
                () -> {
                    Student student1 = new Student();
                    student1.setStudentGPA(4.0);
                    assertEquals("A", student1.calculateGrade());
                },
                () -> {
                    Student student2 = new Student();
                    student2.setStudentGPA(3.7);
                    assertEquals("A-", student2.calculateGrade());
                },
                () -> {
                    Student student3 = new Student();
                    student3.setStudentGPA(3.3);
                    assertEquals("B+", student3.calculateGrade());
                },

                () -> {

                    Student student16 = new Student();
                    student16.setStudentGPA(0.0);
                    assertEquals("E", student16.calculateGrade());
                },

                () -> {

                    Student student17 = new Student();
                    student17.setStudentGPA(-5);
                    assertEquals("Invalid GPA", student17.calculateGrade());
                }

        );


    }

    @Test
    void testToString1() {
    }
}