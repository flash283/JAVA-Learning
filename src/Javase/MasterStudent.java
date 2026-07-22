package Javase;

public class MasterStudent extends Student{
    public MasterStudent() {
    }

    public MasterStudent(String name, String age, String grade) {
        super(name, age, grade);
    }

    @Override
    public void study() {
        System.out.println("正在攻读研究生");
    }
}
