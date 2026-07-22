package Javase;

public class JavaBean {
     class Student {
        private String name;   // 属性私有
        private int age;

        public Student() {}    // 无参构造（必须）

        public String getName() { return name; }     // getter
        public void setName(String name) { this.name = name; }  // setter
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }
}
