package Javase;

public class Student1 {
    private String name;  // 私有属性，外部不能直接访问
    private int age;

    // getter：获取属性值
    public String getName() {
        return name;
    }

    // setter：设置属性值（可以在里面加校验）
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 150) {  // 数据校验
            this.age = age;
        }
    }
}

