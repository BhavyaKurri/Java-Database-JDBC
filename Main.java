
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                String choice = sc.nextLine().trim();

                try {
                    switch (choice) {
                        case "1": {
                            System.out.print("Name: ");
                            String name = sc.nextLine().trim();
                            System.out.print("Email: ");
                            String email = sc.nextLine().trim();
                            System.out.print("Course: ");
                            String course = sc.nextLine().trim();
                            System.out.print("Age: ");
                            int age = Integer.parseInt(sc.nextLine().trim());

                            if (name.isEmpty() || email.isEmpty()
                                    || course.isEmpty() || age < 1 || age > 120) {
                                System.out.println("Enter valid student details.");
                                break;
                            }

                            if (dao.addStudent(new Student(name, email, course, age))) {
                                System.out.println("Student added successfully!");
                            }
                            break;
                        }

                        case "2": {
                            List<Student> students = dao.getAllStudents();
                            if (students.isEmpty()) {
                                System.out.println("No student records found.");
                            } else {
                                System.out.println("ID | Name | Email | Course | Age");
                                for (Student s : students) {
                                    System.out.println(s);
                                }
                            }
                            break;
                        }

                        case "3": {
                            System.out.print("Student ID to update: ");
                            int id = Integer.parseInt(sc.nextLine().trim());
                            System.out.print("New name: ");
                            String name = sc.nextLine().trim();
                            System.out.print("New email: ");
                            String email = sc.nextLine().trim();
                            System.out.print("New course: ");
                            String course = sc.nextLine().trim();
                            System.out.print("New age: ");
                            int age = Integer.parseInt(sc.nextLine().trim());

                            if (name.isEmpty() || email.isEmpty()
                                    || course.isEmpty() || age < 1 || age > 120) {
                                System.out.println("Enter valid student details.");
                            } else if (dao.updateStudent(id, name, email, course, age)) {
                                System.out.println("Student updated successfully!");
                            } else {
                                System.out.println("Student ID not found.");
                            }
                            break;
                        }

                        case "4": {
                            System.out.print("Student ID to delete: ");
                            int id = Integer.parseInt(sc.nextLine().trim());
                            if (dao.deleteStudent(id)) {
                                System.out.println("Student deleted successfully!");
                            } else {
                                System.out.println("Student ID not found.");
                            }
                            break;
                        }

                        case "5":
                            System.out.println("Thank you for using the system!");
                            return;

                        default:
                            System.out.println("Invalid option. Choose 1-5.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Age and ID must be valid whole numbers.");
                } catch (SQLException e) {
                    System.out.println("Database operation failed: " + e.getMessage());
                    System.out.println("Check your MySQL connection and input values.");
                }
            }
        }
    }
}
