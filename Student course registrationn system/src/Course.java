public class Course {

    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    int registeredStudents;

    public Course(String courseCode, String title, String description,
                  int capacity, String schedule) {

        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = 0;
    }

    public int getAvailableSlots() {
        return capacity - registeredStudents;
    }

    public void displayCourse() {
        System.out.println("Course Code : " + courseCode);
        System.out.println("Title       : " + title);
        System.out.println("Description : " + description);
        System.out.println("Capacity    : " + capacity);
        System.out.println("Schedule    : " + schedule);
        System.out.println("Available   : " + getAvailableSlots());
        System.out.println("----------------------------------------");
    }
}
