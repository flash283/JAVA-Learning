package File;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    static void main(String[] args) {
     FileCreate.creat03();
    }

    //方式一： new File(String pathname)
    public static void create01(){
        String filePath="d:\\news1.txt";
        File file=new File(filePath);

        try {
            file.createNewFile();
            System.out.println("成功" );
        } catch (IOException e) {
          e.printStackTrace();
        }
    }

    //方式二：new File(File parent,String child) //根据父目录文件+子路径构建
    //d:\\news2.txt

    public static void creat02(){
       File parentFile= new File("d:\\");
       String fileName="news2.txt";
       //这里的file对象，在java程序中，只是一个对象
       //只有createNewFile 方法，才会真正的，在磁盘创建该文件
       File file =new File(parentFile,fileName);

        try {
            file.createNewFile();
            System.out.println("Ok");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式三：new File(String parent,String child) //根据父目录+子路径构建
    public static void creat03(){
        String parentPath="d:\\";
        String filePath="news3.txt";
        File file =new File(parentPath,filePath);

        try {
            file.createNewFile();
            System.out.println("Yes");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
