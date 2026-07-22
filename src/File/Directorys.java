package File;

import java.io.File;

public class Directorys {
    static void main(String[] args) {
        Directorys.m3();
    }
    //判断d:\\news1.txt 是否存在，如果存在就删除
    public static void m1(){
          String filePath="d:\\news1.txt";
        File file=new File(filePath);
        if(file.exists()){
           if( file.delete()){
               System.out.println("删除成功");
           }else {
               System.out.println("删除失败");
           }
        }else{
            System.out.println("该文件不存在");
        }
    }

    //判断 D:\\demo02是否存在,存在就删除，否则提示不存在
    //在Java编程中，目录也被当成文件
    public static void m2(){
        String filePath="D:\\demo02";
        File file=new File(filePath);
        if(file.exists()){
            if( file.delete()){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else{
            System.out.println("该目录不存在");
        }
    }
    //判断 D:\\demo\\a\\b\\c m目录是否存在,如果存在就提示已经存在，否则就创建
    public static void m3(){
        String dictoryPath ="D:\\demo\\a\\b\\c";
        File file=new File(dictoryPath);
        if(file.exists()){
            System.out.println("该目录存在");

        }else{
           if( file.mkdirs()){  //创建一级目录用mkdir(),创建多级目录用mkdirs()
               System.out.println("创建成功");
           }else{
               System.out.println("创建失败");
           }
        }
    }
}
