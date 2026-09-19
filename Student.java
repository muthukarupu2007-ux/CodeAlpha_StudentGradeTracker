public class Student {
    private String studentId;
    private String name;
    private double marks;
    private String grade;

    public Student(String studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
        this.grade = determineGrade(marks);
    }

    public static String determineGrade(double marks) {
        if (marks >= 90 && marks <= 100) {
            return "A+";
        } else if (marks >= 80 && marks < 90) {
            return "A";
        } else if (marks >= 70 && marks < 80) {
            return "B";
        } else if (marks >= 60 && marks < 70) {
            return "C";
        } else if (marks >= 50 && marks < 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
