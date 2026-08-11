import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static ArrayList<Course> courses = new ArrayList<>();
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        addCourses();

        while (true) {

            System.out.println("\n========================================");
            System.out.println("  STUDENT COURSE REGISTRATION SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. View Courses");
            System.out.println("4. Register Course");
            System.out.println("5. View Registered Courses");
            System.out.println("6. Remove Course");
            System.out.println("7. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    viewCourses();
                    break;

                case 4:
                    registerCourse();
                    break;

                case 5:
                    viewRegisteredCourses();
                    break;

                case 6:
                    removeCourse();
                    break;

                case 7:
                    System.out.println("Thank you for using the system!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add courses
    public static void addCourses() {

        courses.add(new Course(
                "CS101",
                "Java Programming",
                "Learn Java programming",
                3,
                "Monday 10:00 AM"
        ));

        courses.add(new Course(
                "CS102",
                "Database Management",
                "Learn SQL and database concepts",
                2,
                "Tuesday 11:00 AM"
        ));

        courses.add(new Course(
                "CS103",
                "Web Development",
                "Learn HTML, CSS and JavaScript",
                4,
                "Wednesday 2:00 PM"
        ));

        courses.add(new Course(
                "CS104",
                "Data Structures",
                "Learn basic data structures",
                3,
                "Thursday 10:00 AM"
        ));
    }

    // Add student
    public static void addStudent() {

        System.out.println("\n---------- ADD STUDENT ----------");

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        if (findStudent(id) != null) {
            System.out.println("Student already exists!");
            return;
        }

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        students.add(new Student(id, name));

        System.out.println("Student added successfully!");
    }

    // View students
    public static void viewStudents() {

        System.out.println("\n---------- STUDENTS ----------");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {

            System.out.println(
                    "Student ID: " + student.studentId +
                            " | Name: " + student.name
            );
        }
    }

    // View courses
    public static void viewCourses() {

        System.out.println("\n---------- AVAILABLE COURSES ----------");

        for (Course course : courses) {
            course.displayCourse();
        }
    }

    // Register course
    public static void registerCourse() {

        System.out.println("\n---------- COURSE REGISTRATION ----------");

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        viewCourses();

        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();

        Course course = findCourse(code);

        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        if (student.registerCourse(course)) {

            System.out.println("Course registered successfully!");

        } else {

            if (course.getAvailableSlots() == 0) {
                System.out.println("No slots available!");
            } else {
                System.out.println("You are already registered!");
            }
        }
    }

    // View registered courses
    public static void viewRegisteredCourses() {

        System.out.println("\n---------- REGISTERED COURSES ----------");

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Student: " + student.name);

        student.showRegisteredCourses();
    }

    // Remove course
    public static void removeCourse() {

        System.out.println("\n---------- REMOVE COURSE ----------");

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();

        Student student = findStudent(id);

        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        student.showRegisteredCourses();

        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine();

        Course course = findCourse(code);

        if (course == null) {
            System.out.println("Course not found!");
            return;
        }

        if (student.removeCourse(course)) {
            System.out.println("Course removed successfully!");
        } else {
            System.out.println("You are not registered for this course!");
        }
    }

    // Find student
    public static Student findStudent(String id) {

        for (Student student : students) {

            if (student.studentId.equalsIgnoreCase(id)) {
                return student;
            }
        }

        return null;
    }

    // Find course
    public static Course findCourse(String code) {

        for (Course course : courses) {

            if (course.courseCode.equalsIgnoreCase(code)) {
                return course;
            }
        }

        return null;
    }
}