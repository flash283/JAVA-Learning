package Jdbc;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionTest {
    //获取数据库连接
    //方式一：
    public static void testConnection1() throws SQLException {
     //获取Driver实现类的对象
     Driver driver=new com.mysql.jdbc.Driver();

     //jdbc:mysql:协议
     //localhost:ip地址
     //3306:默认mysql的端口号
     //test：test的数据库
        String url="jdbc:mysql://localhost:3306/mydb";

        Properties info=new Properties();
        //将用户名和密码封装在Properties
        info.setProperty("user","root");
        info.setProperty("password","Ldp1704110!");

      Connection conn= driver.connect(url,info);

      System.out.println(conn);
    }

    //方式二：对方式一的迭代
    public static void testConnection2() throws Exception{
        //1.获取Driver实现类的对象：使用反射
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver) clazz.newInstance();

        //2.提供要连接的数据库
        String url="jdbc:mysql://localhost:3306/mydb";

        //3.提供连接需要的用户名和密码
        Properties info=new Properties();
        info.setProperty("user","root");
        info.setProperty("password","Ldp1704110!");

        //4.获取连接
        Connection conn= driver.connect(url,info);
        System.out.println(conn);

    }

    //方式三：使用DriverManager替代Driver
    public static void testConnection3() throws Exception{
        //1.获取Driver实现类的对象：使用反射
        Class clazz=Class.forName("com.mysql.jdbc.Driver");
        Driver driver=(Driver) clazz.newInstance();

        //2.提供另外三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/mydb";
        String user="root";
        String password="Ldp1704110!";

        //注册驱动
        DriverManager.registerDriver(driver);

        //获取连接
        Connection conn= DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

    //方式四：可以只是加载驱动，不用显示的注册驱动
    public static void testConnection4() throws Exception{
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.提供另外三个连接的基本信息
        String url="jdbc:mysql://localhost:3306/mydb";
        String user="root";
        String password="Ldp1704110!";

        //获取连接
        Connection conn= DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

    //方式五：将数据库需要的4个基本信息声明在配置文件中，通过读取配置文件的方式，获取连接
    public static void getConnection5() throws Exception {
      //1.读取配置文件中的4个基本信息
        InputStream is=ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros=new Properties();
        pros.load(is);

        String user=pros.getProperty("user");
        String password=pros.getProperty("password");
        String url=pros.getProperty("url");
        String driverClass=pros.getProperty("driverClass");

        //2.加载驱动
        Class.forName(driverClass);

        //3.获取连接
        Connection conn=DriverManager.getConnection(url,user,password);
        System.out.println(conn);
    }

    public static void main(String[] args) throws Exception {
        ConnectionTest.getConnection5();
    }
}
