package CustomException;

public class CustomException {
    static void main(String[] args) {
        int age=0;
        if(!(age>=18 && age<=120)){
            //这里可以通过构造器设置信息
            throw new AgeException("年龄须在制定范围");
        }
        System.out.println("True");
    }
}

//一般情况下，自定义异常是继承 RuntimeException,即做成 运行时异常
//好处：我们可以使用默认处理机制，比较方便
class AgeException extends RuntimeException {
    public AgeException(String message){
        super(message);
    }
}
