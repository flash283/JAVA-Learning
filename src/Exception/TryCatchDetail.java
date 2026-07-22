package Exception;

public class TryCatchDetail {
    static void main(String[] args) {
        //如果异常发生，则异常后面的代码不会执行，直接进入到catch块
        //如果没有发生，则顺序执行try的代码块，不会进入到catch
        //如果希望不管是否发生异常，都执行某段代码，则使用finally
        //可以有多个catch语句捕获不同异常，要求父类在子类异常之后
        //如果发生异常只会匹配一个catch
        //可以进行try-finally 配合使用，相当于没有捕获异常
        //因此程序会直接崩掉/退出。应用场景就是执行一段代码，不管是否发生异常，都必须执行某个业务逻辑
        // ctrl+alt+t
    /*    try {
            String str="123a";
            int a=Integer.parseInt(str);
            System.out.println("数字："+a);
        } catch (NumberFormatException e) {
            System.out.println("异常信息"+e.getMessage());
        } finally {
            System.out.println("finally代码块执行");
        }
        System.out.println("程序继续....");
    }

     */
        try {
            Person p = new Person();
            p=null;
            System.out.println(p.getName()); //NullPointerException
            int n1=10;
            int n2=0;
            int res=n1/n2;   //ArithmeticException
        }catch (NullPointerException e) {
            System.out.println("空指针异常: "+e.getMessage());
        } catch (ArithmeticException e){
            System.out.println("算数异常: "+e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
        }

    }
}
class Person{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
