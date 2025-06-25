import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, Please try again!!!.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (findStudentById(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();
        scanner.nextLine();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }


    private static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("\nStudent Records:");
        for (Student student : studentList) {
            student.display();
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new marks: ");
        int newMarks = scanner.nextInt();

        student.setName(newName);
        student.setMarks(newMarks);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        studentList.remove(student);
        System.out.println("Student deleted successfully.");
    }

    private static Student findStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
















