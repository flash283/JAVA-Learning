package Javase;

public class BachelorStudent extends Student{
    public BachelorStudent(String name, String age, String grade) {
        super(name, age, grade);
    }

    public BachelorStudent() {
    }

    @Override
    public void study() {
        System.out.println("正在攻读本科");
    }
}
