package Logbook.Week3;

class Student {

    public int studentID;
    public String name;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println("Student ID: " + studentID + ", Name: " + name);
    }

    public static void main(String[] args) {
        Student student1 = new Student(100195304, "Tymoteusz Stasiak");
        student1.print();
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
}
