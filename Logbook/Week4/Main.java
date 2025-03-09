package Logbook.Week4;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseCode;
    private String courseName;
    private String description;

    public Course(String courseCode, String courseName, String description) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
    }

    public void print() {
        System.out.println("Course Code: " + courseCode + ", Name: " + courseName);
        System.out.println("Description: " + description);
    }
}

class Student {
    public int studentID;
    public String name;
    private ArrayList<Course> courses;
    private int[] marks;

    public Student(int studentID, String name, Course course) {
        this.studentID = studentID;
        this.name = name;
        this.courses = new ArrayList<>();
        this.courses.add(course);
        this.marks = new int[4];
    }

    public void enrol(Course newCourse) {
        courses.add(newCourse);
    }

    public void inputMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to enter marks for the 4 subjects (yes/no)? ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            for (int i = 0; i < marks.length; i++) {
                int mark;
                do {
                    System.out.print("Enter mark for subject " + (i + 1) + " (0-100): ");
                    mark = scanner.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Error: Marks must be between 0 and 100.");
                    }
                } while (mark < 0 || mark > 100);
                marks[i] = mark;
            }
        } else {
            for (int i = 0; i < marks.length; i++) {
                marks[i] = -1;
            }
        }
    }

    public void print() {
        System.out.println("Student ID: " + studentID + ", Name: " + name);
        if (!courses.isEmpty()) {
            System.out.println("Enrolled in the following courses:");
            for (Course course : courses) {
                course.print();
            }
        } else {
            System.out.println("No courses enrolled.");
        }

        System.out.println("Marks:");
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] == -1) {
                System.out.println("Mark " + (i + 1) + ": Not entered");
            } else {
                System.out.println("Mark " + (i + 1) + ": " + marks[i]);
            }
        }
    }
}

class MainTask {
    public static void main(String[] args) {
        Course course1 = new Course("001", "English", "Study of the English language, its literature, and linguistic structures.");
        Course course2 = new Course("002", "Mathematics", "Explore advanced mathematical concepts, theories, and problem-solving methods.");
        Course course3 = new Course("003", "Geography", "Understanding the Earth's landscapes, environments, and human interactions with them.");
        Course course4 = new Course("004", "Computer Science", "Learn about programming, algorithms, data structures, and software development.");
        Course course5 = new Course("005", "Science", "Study of physical and natural sciences, including physics, chemistry, and biology.");
        Course course6 = new Course("006", "French", "Learning the French language, its grammar, vocabulary, and cultural aspects.");

        Student student1 = new Student(100195304, "Tymoteusz Stasiak", course1);
        student1.inputMarks();
        student1.print();

        System.out.println("\nEnrolling student in new courses.\n");

        student1.enrol(course2);
        student1.enrol(course3);
        student1.enrol(course4);
        student1.enrol(course5);
        student1.enrol(course6);
        student1.print();
    }
}
