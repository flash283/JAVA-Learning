package File;

import java.io.File;

public class FileInformation {
    static void main(String[] args) {
       FileInformation.info();
    }
    //获取文件信息
    public static void info(){
        //先创建文件对象
        File file=new File("d:\\news1.txt");

        //调用相应方法，得到对应信息
        System.out.println("文件名字="+file.getName());

        //getName,getAbsolutePath,getParent,length,exits,isFile,isDirectory
        System.out.println("文件绝对路径="+file.getAbsolutePath());
        System.out.println("文件父级目录="+file.getParent());
        System.out.println("文件大小（字节）="+file.length());
        System.out.println("文件是否存在="+file.exists());
        System.out.println("是不是一个文件="+file.isFile());
        System.out.println("是不是一个目录="+file.isDirectory());
    }
}
