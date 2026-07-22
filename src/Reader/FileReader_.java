package Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {

    static void main(String[] args) {
        String filePath = "d:\\story.txt";
        FileReader fileReader = null;

        //1.创建Filereader对象
       /* try {
            fileReader = new FileReader(filePath);
            //循环读取 方式一：使用read，单个字符读取
            int data=0;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char)data);
            }

            } catch(IOException e){
                throw new RuntimeException(e);
            }finally{
              if(fileReader!=null){
                  try {
                      fileReader.close();
                  } catch (IOException e) {
                      throw new RuntimeException(e);
                  }
              }
            }

        */

        //方式二：使用read（buf）,返回的是实际读取到的字符数
        //如果返回-1，说明文件结束
         char[] buf=new char[8];
         int readlen=0;
        try {
            fileReader=new FileReader(filePath);
            while ((readlen = fileReader.read(buf))!=-1){
          System.out.print(new String(buf,0,readlen));
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            if(fileReader!=null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
