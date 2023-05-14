// Programming Exercise 07: OOP
// by Meekah Yzabelle A. Carballo (2021-05127)
//    Khublei Mo Satori Pelayo (2021-00529)

import java.util.Scanner;

public class Carballo_Pelayo_PE07 {
    public static void main(String[] args) {
        // Create an instance of the Student class
        Student student = new Student();

        // Create an instance of the Scanner class to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user and accept string input for the first name
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        // Prompt the user and accept string input for the last name
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        // Prompt the user and accept string input for the gender
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();

        // Prompt the user and accept string input for the student number
        System.out.print("Enter student number (Format: 20xx-xxxx): ");
        String studentNum = scanner.nextLine();

        // Prompt the user and accept string input for the department
        System.out.print("Enter department: ");
        String studentDept = scanner.nextLine();

        // Prompt the user and accept string input for the college
        System.out.print("Enter college: ");
        String studentCollege = scanner.nextLine();

        // Set the input values using the setters of the Person class
        student.setfName(firstName);
        student.setlName(lastName);
        student.setGender(gender);

        // Set the input values using the setters of the Student class
        student.setStudentNum(studentNum, true);
        student.setStudentDept(studentDept);
        student.setStudentCollege(studentCollege);

        // Get the values using the getters of the Person class
        String retrievedFirstName = student.getfName();
        String retrievedLastName = student.getlName();
        String retrievedGender = student.getGender();

        // Get the values using the getters of the Student class
        String retrievedStudentNum = student.getStudentNum();
        String retrievedStudentDept = student.getStudentDept();
        String retrievedStudentCollege = student.getStudentCollege();

        // Print the retrieved values
        System.out.print("\n\n" + student.getFullName());
        System.out.println(", here's the data you gave me.");
        System.out.println("\nPersonal Information ");
        System.out.println("First Name: " + retrievedFirstName);
        System.out.println("Last Name: " + retrievedLastName);
        System.out.println("Gender: " + retrievedGender);

        // Print the retrieved student-specific values
        System.out.println("\nStudent Information");
        System.out.println("Student Number: " + retrievedStudentNum);
        System.out.println("Department: " + retrievedStudentDept);
        System.out.println("College: " + retrievedStudentCollege);
    }
}

// Parent class
class Person {
    // ENCAPSULATION Implementation
    // Access modifiers make the fields not directly accessible from outside the
    // class
    private String fName;
    private String lName;
    private String gender;

    public Person() {
    }

    public Person(String fName, String lName, String gender) {
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
    }

    // will be the function to be overriden in class student
    public String getFullName() {
        return fName + " " + lName;
    }

    // Set and get Person's first name
    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfName() {
        return fName;
    }

    // Set and get Person's last name
    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlName() {
        return lName;
    }

    // Set and get Person's gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

}

// INHERITANCE Implementation
// Child class (Student) inherits attributes from Person
class Student extends Person {
    // ENCAPSULATION Implementation
    // Access modifiers make the fields not directly accessible from outside the
    // class
    private String studentNum;
    private String studentDept;
    private String studentCollege;

    public Student(String fName, String lName, String gender) {
        super(fName, lName, gender);
    }

    public Student() {
    }

    // Set and get Student's student number
    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    // overloads setStudentnum to add validation to the value of studentNum
    public void setStudentNum(String studentNum, boolean validate) {
        if (validate) {
            if (studentNum.length() == 10) {
                this.studentNum = studentNum;
            } else {
                System.out.println("Invalid Student Number detected\n");
                this.studentNum = "(Invalid)";
            }
        } else {
            this.studentNum = studentNum;
        }
    }

    public String getStudentNum() {
        return studentNum;
    }

    // Set and get Student's department
    public void setStudentDept(String studentDept) {
        this.studentDept = studentDept;
    }

    public String getStudentDept() {
        return studentDept;
    }

    // Set and get Student's college
    public void setStudentCollege(String studentCollege) {
        this.studentCollege = studentCollege;
    }

    public String getStudentCollege() {
        return studentCollege;

    }

    // overrides getFullName from class person to include studentNum and a greeting
    public String getFullName() {
        return "Hey, " + super.getFullName() + " (" + studentNum + ")";
    }
}