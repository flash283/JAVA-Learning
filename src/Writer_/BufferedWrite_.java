package Writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWrite_ {
    static void main(String[] args) throws Exception{
        String filePath="d:\\story.txt";
        //创建BufferedWriter
        //1.new BufferedWriter(new FileWriter(filePath,true)) 表示以追加的方式写入
        //1.new BufferedWriter(new FileWriter(filePath)) 表示以覆盖的方式写入
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(filePath,true));
        bufferedWriter.write("hello,韩顺平教育");
        bufferedWriter.newLine(); //插入一个和系统相关的换行
        bufferedWriter.write("hello1,韩顺平教育");
        bufferedWriter.close();
    }
}
