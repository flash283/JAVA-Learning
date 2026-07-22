package Reader;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_ {
    static void main(String[] args) throws Exception{
        String filePath="d:\\story.txt";
        //创建bufferedReader
        BufferedReader bufferedReader=new BufferedReader(new FileReader(filePath));
        //读取
        String line; //按行读取,效率高
        //1.  bufferedReader.readLine()是按行读取文件
        //2.当返回null时，表示文件读取完毕
      while((line=bufferedReader.readLine())!=null){
          System.out.println(line);
      }
      //关闭流，这里只需要关闭 BufferedReader
        bufferedReader.close();


    }
}
