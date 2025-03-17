package Logbook.Week4;

import java.util.ArrayList;
import java.util.Scanner;

enum Grade {
    A(85), B(70), C(60), D(50), E(30), F(0);

    private int minMark;

    Grade(int minMark) {
        this.minMark = minMark;
    }

    public int getMinMark() {
        return minMark;
    }

    public static Grade fromMark(int mark) {
        if (mark >= 85) return A;
        if (mark >= 70) return B;
        if (mark >= 60) return C;
        if (mark >= 50) return D;
        if (mark >= 30) return E;
        return F;
    }

    public String getGradeDescription() {
        switch (this) {
            case A: return "Excellent";
            case B: return "Good";
            case C: return "Average";
            case D: return "Pass";
            case E: return "Below Pass";
            case F: return "Fail";
            default: return "Unknown";
        }
    }
}

class Course {
    private String courseCode;
    private String courseName;
    private String description;

    public Course(String courseCode, String courseName, String description) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
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
    private ArrayList<Grade> grades;

    public Student(int studentID, String name, Course course) {
        this.studentID = studentID;
        this.name = name;
        this.courses = new ArrayList<>();
        this.courses.add(course);
        this.grades = new ArrayList<>();
        this.grades.add(null);
    }

    public void enrol(Course newCourse) {
        courses.add(newCourse);
        grades.add(null);
    }

    public void inputMarks() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to enter marks for the subjects (yes/no)? ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes")) {
            for (int i = 0; i < courses.size(); i++) {
                int mark;
                do {
                    System.out.print("Enter mark for " + courses.get(i).getCourseName() + " (0-100): ");
                    mark = scanner.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Error: Marks must be between 0 and 100.");
                    }
                } while (mark < 0 || mark > 100);
                grades.set(i, Grade.fromMark(mark));
            }
        } else {
            for (int i = 0; i < grades.size(); i++) {
                grades.set(i, null);
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

        System.out.println("Grades:");
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) == null) {
                System.out.println("Grade for " + courses.get(i).getCourseName() + ": Not entered");
            } else {
                System.out.println("Grade for " + courses.get(i).getCourseName() + ": " + grades.get(i) + " (" + grades.get(i).getGradeDescription() + ")");
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

        student1.inputMarks();
        student1.print();
    }
}
