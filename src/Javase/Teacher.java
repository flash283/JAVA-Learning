package Javase;

public class Teacher extends Person{
    private String subject;

    public Teacher(String name, String age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public Teacher() {

    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public void teach() {
        System.out.println("教书");
    }
}
