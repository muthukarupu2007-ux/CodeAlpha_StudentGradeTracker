import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGradeTracker {
    private static final ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("===== STUDENT GRADE TRACKER =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Calculate Statistics");
            System.out.println("4. Search Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    viewAllStudents();
                    break;
                case 3:
                    calculateStatistics();
                    break;
                case 4:
                    searchStudent(scanner);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid menu item.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();

        if (studentId.isEmpty() || name.isEmpty()) {
            System.out.println("Student ID and name cannot be empty.");
            return;
        }

        double marks = readMarks(scanner);
        if (marks == -1) {
            return;
        }

        Student student = new Student(studentId, name, marks);
        students.add(student);

        System.out.println("Student added successfully.");
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        System.out.println("\nStudent Report");
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-12s %-20s %-8s %-5s%n", "Student ID", "Name", "Marks", "Grade");
        System.out.println("---------------------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-12s %-20s %-8.2f %-5s%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getMarks(),
                    student.getGrade());
        }
        System.out.println("---------------------------------------------------------");
    }

    private static void calculateStatistics() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        double total = 0;
        double highest = students.get(0).getMarks();
        double lowest = students.get(0).getMarks();

        for (Student student : students) {
            total += student.getMarks();
            if (student.getMarks() > highest) {
                highest = student.getMarks();
            }
            if (student.getMarks() < lowest) {
                lowest = student.getMarks();
            }
        }

        double average = total / students.size();

        System.out.println("\nStatistics Summary");
        System.out.println("------------------------------");
        System.out.printf("Average Marks: %.2f%n", average);
        System.out.printf("Highest Score: %.2f%n", highest);
        System.out.printf("Lowest Score: %.2f%n", lowest);
        System.out.println("------------------------------");
    }

    private static void searchStudent(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students available to search.");
            return;
        }

        System.out.print("Enter Student ID to search: ");
        String studentId = scanner.nextLine().trim();

        boolean found = false;
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                System.out.println("\nStudent Found");
                System.out.println("-------------------------------");
                System.out.println("ID: " + student.getStudentId());
                System.out.println("Name: " + student.getName());
                System.out.println("Marks: " + student.getMarks());
                System.out.println("Grade: " + student.getGrade());
                System.out.println("-------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID " + studentId + " was not found.");
        }
    }

    private static double readMarks(Scanner scanner) {
        while (true) {
            System.out.print("Enter Marks (0-100): ");
            String input = scanner.nextLine().trim();

            try {
                double marks = Double.parseDouble(input);
                if (marks >= 0 && marks <= 100) {
                    return marks;
                } else {
                    System.out.println("Marks must be between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
