package Javase;

public class Student extends Person{
    private String grade;

    public Student(){
    }

    public Student(String name, String age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void study(){
        System.out.println("学习");
    }
}
