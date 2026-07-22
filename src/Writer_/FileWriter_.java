package Writer_;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {
    static void main(String[] args) {
        String filePath="d:\\story.txt";
        //创建FileWriter对象
        FileWriter fileWriter=null;
        char[] chars={'a','b','c'};
        try {
            fileWriter=new FileWriter(filePath); //默认是覆盖写入
            //  1.write(int):写入单个字符
            fileWriter.write('H');
            //  2.write(char[]):写入指定数组
            fileWriter.write(chars);
            //  3.write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(),0,3);
            //  4.write(String):写入整个字符串
            fileWriter.write(" 你好北京~");
            //  5.write(String,off,len):写入指定字符串的指定部分
            fileWriter.write("上海天津",0,2);
            //数据多时，用循环操作

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //fileWriter.flush();
                //关闭文件流，等价于flush()+关闭
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
