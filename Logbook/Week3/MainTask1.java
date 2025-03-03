package Logbook.Week3;

class Student {

    public int studentID;
    public String name;
    private Course course;

    public Student(int studentID, String name, Course course) {
        this.studentID = studentID;
        this.name = name;
        this.course = course;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public void enrol(Course newCourse) {
        this.course = newCourse;
    }

    public void print() {
        System.out.println("Student ID: " + studentID + ", Name: " + name);
        if (course != null) {
            course.print();
        } else {
            System.out.println("No course enrolled.");
        }
    }
}

class Course {

    private String courseCode;
    private String courseName;

    public Course(String courseCode, String courseName) {
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void print() {
        System.out.println("Course Code: " + courseCode + ", Name: " + courseName);
    }
}

class MainTask {
    public static void main(String[] args) {
        Course course1 = new Course("001", "English");
        Course course2 = new Course("002", "Mathematics");

        Student student1 = new Student(100195304, "Tymoteusz Stasiak", course1);
        student1.print();

        System.out.println("\nEnrolling student in a new course.\n");

        student1.enrol(course2);
        student1.print();
    }
}
