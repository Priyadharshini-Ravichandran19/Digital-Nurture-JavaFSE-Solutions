class Course {

    String title;
    String instructor;
    int durationHours;

    void displayCourse() {
        System.out.println("Title: " + title);
        System.out.println("Instructor: " + instructor);
        System.out.println("Duration: " + durationHours + " hours");
    }
}

public class ClassObject {

    public static void main(String[] args) {

        Course c1 = new Course();

        c1.title = "Java Programming";
        c1.instructor = "Priyadharshini";
        c1.durationHours = 40;

        c1.displayCourse();
    }
}