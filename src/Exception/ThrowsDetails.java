package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDetails {
    static void main(String[] args) {
             f2();
    }
    public static void f2(){
        //对于编译异常，程序中必须处理，比如 try-catch 或者 throws
        //对于运行时异常，程序中如果没有处理，默认就是throws的方式处理

        int n1=10;
        int n2=0;
        double res=n1/n2;
    }
    public  static void f1() throws Exception{
        //f3()方法抛出的是一个编译异常
        //这时，就要f1（）必须处理这个编译异常
        //在f1中，要么try-catch-finally,要么继续throws
        f3();  //抛出异常
    }
    public  static  void f3() throws FileNotFoundException {
        FileInputStream fis=new FileInputStream("d:aa.text");
    }

   public static void f4() {
      //在f4中调用f5（） OK
       //原因是f5（）抛出的是运行异常
       //而Java中，并不要求程序员显示处理，因为有默认处理机制
        f5();
    }

    public static void f5() throws ArithmeticException {

    }
}
class Father{ //父类
    public void method(){}
}
class Son extends Father{  //子类
    //子类重写父类方法时，对抛出异常的规定：
    //子类重写父类方法所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常的子类
   //在throws过程中，如果有方法 try-catch，就相当于处理异常，就可以不必throws
    public void method(){}
}