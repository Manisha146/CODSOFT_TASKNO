import java.util.ArrayList;

public class Student {

    String studentId;
    String name;
    ArrayList<Course> registeredCourses;

    public Student(String studentId, String name) {

        this.studentId = studentId;
        this.name = name;
        registeredCourses = new ArrayList<>();
    }

    public boolean registerCourse(Course course) {

        if (registeredCourses.contains(course)) {
            return false;
        }

        if (course.registeredStudents >= course.capacity) {
            return false;
        }

        registeredCourses.add(course);
        course.registeredStudents++;

        return true;
    }

    public boolean removeCourse(Course course) {

        if (!registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.remove(course);
        course.registeredStudents--;

        return true;
    }

    public void showRegisteredCourses() {

        if (registeredCourses.isEmpty()) {
            System.out.println("No courses registered.");
            return;
        }

        for (Course course : registeredCourses) {
            System.out.println(
                    course.courseCode + " - " +
                            course.title + " - " +
                            course.schedule
            );
        }
    }
}