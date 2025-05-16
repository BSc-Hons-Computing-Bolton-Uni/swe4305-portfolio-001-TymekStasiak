import java.io.*;
import java.util.*;

class Student {
    String studentNumber;
    String firstName;
    String surname;
    Map<String, Integer> modules;

    Student(String studentNumber, String firstName, String surname) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.surname = surname;
        this.modules = new HashMap<>();
    }

    void addOrUpdateModule(String moduleCode, int mark, Map<String, String> moduleMap) {
        if (moduleMap.containsKey(moduleCode)) {
            if (modules.containsKey(moduleCode)) {
                System.out.println("Module already added. Mark updated.");
            } else {
                System.out.println("Module added: " + moduleMap.get(moduleCode));
            }
            modules.put(moduleCode, mark);
        } else {
            System.out.println("Invalid module code.");
        }
    }

    void deleteModule(String moduleCode) {
        if (modules.containsKey(moduleCode)) {
            modules.remove(moduleCode);
            System.out.println("Module removed: " + moduleCode);
        } else {
            System.out.println("Module not found.");
        }
    }

    void displayModules(Map<String, String> moduleMap) {
        if (modules.isEmpty()) {
            System.out.println("No modules enrolled.");
            return;
        }
        System.out.println("Modules for " + firstName + " " + surname + ":");
        for (Map.Entry<String, Integer> entry : modules.entrySet()) {
            String name = moduleMap.getOrDefault(entry.getKey(), "Unknown Module");
            System.out.println(entry.getKey() + " - " + name + " | Mark: " + entry.getValue());
        }
    }

    String getGradeClassification(int mark) {
        if (mark >= 70 && mark <= 100) return "A - First Class";
        if (mark >= 60 && mark <= 69) return "B - Upper Second Class";
        if (mark >= 50 && mark <= 59) return "C - Lower Second Class";
        if (mark >= 40 && mark <= 49) return "D - Third Class";
        return "F - Fail";
    }

    void displayGradeForModule(String moduleCode, Map<String, String> moduleMap) {
        if (!modules.containsKey(moduleCode)) {
            System.out.println("Student is not enrolled in this module.");
            return;
        }
        int mark = modules.get(moduleCode);
        String classification = getGradeClassification(mark);
        String name = moduleMap.getOrDefault(moduleCode, "Unknown Module");
        System.out.println("Module: " + name);
        System.out.println("Mark: " + mark);
        System.out.println("Grade: " + classification);
    }

    String toFileString() {
        StringBuilder sb = new StringBuilder();
        sb.append(studentNumber).append("|").append(firstName).append("|").append(surname).append("|");
        for (Map.Entry<String, Integer> entry : modules.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
        }
        return sb.toString();
    }

    static Student fromFileString(String line) {
        String[] parts = line.split("\\|");
        Student student = new Student(parts[0], parts[1], parts[2]);
        if (parts.length > 3 && !parts[3].isEmpty()) {
            String[] moduleEntries = parts[3].split(",");
            for (String entry : moduleEntries) {
                String[] moduleData = entry.split(":");
                if (moduleData.length == 2) {
                    student.modules.put(moduleData[0], Integer.parseInt(moduleData[1]));
                }
            }
        }
        return student;
    }
}

class UniversitySystem {
    static Map<String, String> moduleMap = new HashMap<>();
    static Map<String, Student> students = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static final String FILE_NAME = "students.txt";

    public static void main(String[] args) {
        initialiseModules();
        loadFromFile();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. View Student Modules");
            System.out.println("4. Display Grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    editStudent();
                    break;
                case 3:
                    viewModules();
                    break;
                case 4:
                    displayGrade();
                    break;
                case 5:
                    saveToFile();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void initialiseModules() {
        moduleMap.put("COM4301", "Maths for Computing");
        moduleMap.put("COM4302", "Computer Science Fundamentals");
        moduleMap.put("SWE4303", "Computing Infrastructure");
        moduleMap.put("SWE4304", "Databases");
        moduleMap.put("SWE4305", "Object Oriented Programming");
        moduleMap.put("SWE5306", "Systems Analysis and Design");
        moduleMap.put("SWE5307", "Web Design and Programming");
        moduleMap.put("SWE5308", "Cloud Technologies");
        moduleMap.put("SWE5304", "Advanced Databases and Big Data");
        moduleMap.put("SEC5304", "Advanced Operating Systems");
        moduleMap.put("AIN5301", "Introduction to AI");
        moduleMap.put("COM6300", "Research and Professional Issues");
        moduleMap.put("COM6301", "Undergraduate Project");
        moduleMap.put("AIN6301", "Natural Language Processing");
        moduleMap.put("SEC6302", "Information Security Management");
        moduleMap.put("SEC6305", "Operations Management");
        moduleMap.put("SWE6302", "Applied Machine Learning");
        moduleMap.put("SWE6303", "Software Quality Management");
        moduleMap.put("SWE6304", "Emerging Technologies");
    }

    static void addStudent() {
        System.out.print("Enter student number: ");
        String number = scanner.nextLine();
        System.out.print("Enter forename: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter surname: ");
        String surname = scanner.nextLine();
        students.put(number, new Student(number, firstName, surname));
        System.out.println("Student added.");
        saveToFile();
    }

    static void editStudent() {
        System.out.print("Enter student number: ");
        String number = scanner.nextLine();
        Student student = students.get(number);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        while (true) {
            System.out.println("\nEdit Menu:");
            System.out.println("1. Add or Update Module");
            System.out.println("2. Remove Module");
            System.out.println("3. Return to Main Menu");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter module code to add or update: ");
                    String moduleCode = scanner.nextLine().toUpperCase();
                    System.out.print("Enter mark (0-100): ");
                    int mark = Integer.parseInt(scanner.nextLine());
                    student.addOrUpdateModule(moduleCode, mark, moduleMap);
                    saveToFile();
                    break;
                case 2:
                    System.out.print("Enter module code to remove: ");
                    String delCode = scanner.nextLine().toUpperCase();
                    student.deleteModule(delCode);
                    saveToFile();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    static void viewModules() {
        System.out.print("Enter student number: ");
        String number = scanner.nextLine();
        Student student = students.get(number);
        if (student != null) {
            student.displayModules(moduleMap);
        } else {
            System.out.println("Student not found.");
        }
    }

    static void displayGrade() {
        System.out.print("Enter student number: ");
        String number = scanner.nextLine();
        Student student = students.get(number);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter module code: ");
        String moduleCode = scanner.nextLine().toUpperCase();
        student.displayGradeForModule(moduleCode, moduleMap);
    }

    static void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student student : students.values()) {
                writer.println(student.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    static void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = Student.fromFileString(line);
                students.put(student.studentNumber, student);
            }
        } catch (IOException e) {
            // Ignore if file doesn't exist
        }
    }
}
