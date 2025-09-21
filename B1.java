// Common interface
interface CourseComponent {
    void showDetails();
}

// Lesson class
class Lesson implements CourseComponent {
    private String title;
    private int duration; // in minutes
    private String instructorName;

    public Lesson(String title, int duration, String instructorName) {
        this.title = title;
        this.duration = duration;
        this.instructorName = instructorName;
    }

    @Override
    public void showDetails() {
        System.out.println("Lesson: " + title +
                " | Duration: " + duration + " mins" +
                " | Instructor: " + instructorName);
    }
}

// CourseModule class
class CourseModule implements CourseComponent {
    private String moduleName;

    public CourseModule(String moduleName) {
        this.moduleName = moduleName;
    }

    @Override
    public void showDetails() {
        System.out.println("Module: " + moduleName);
    }
}

// Factory class
class CourseFactory {
    public static CourseComponent createComponent(String type, String name, int duration, String instructor) {
        if (type.equalsIgnoreCase("LESSON")) {
            return new Lesson(name, duration, instructor);
        } else if (type.equalsIgnoreCase("MODULE")) {
            return new CourseModule(name);
        } else {
            throw new IllegalArgumentException("Unknown component type: " + type);
        }
    }
}

// Main class
public class B1 {
    public static void main(String[] args) {
        // Create lessons using factory
        CourseComponent l1 = CourseFactory.createComponent("LESSON", "Intro to Java", 45, "Alice");
        CourseComponent l2 = CourseFactory.createComponent("LESSON", "OOP Concepts", 60, "Bob");

        // Create module using factory
        CourseComponent m1 = CourseFactory.createComponent("MODULE", "OOP Module", 0, null);

        // Display details
        m1.showDetails();
        l1.showDetails();
        l2.showDetails();
    }
}

// main
// class Lesson implements CourseComponent {
// private String title;
// private int duration; // <--- added in main branch

// public Lesson(String title, int duration) {
// this.title = title;
// this.duration = duration;
// }

// @Override
// public void showDetails() {
// System.out.println("Lesson: " + title + " | Duration: " + duration + "
// mins");
// }
// }

// feature
// class Lesson implements CourseComponent {
// private String title;
// private String instructorName; // <--- added in feature branch

// public Lesson(String title, String instructorName) {
// this.title = title;
// this.instructorName = instructorName;
// }

// @Override
// public void showDetails() {
// System.out.println("Lesson: " + title + " | Instructor: " + instructorName);
// }
// }
