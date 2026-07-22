package Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("罗贯中", "三国", 10.1));
        col.add(new Book("古龙", "小李飞刀", 5.1));
        col.add(new Book("曹雪芹", "红楼", 34.6));

        System.out.println("col=" + col);

        //1.先得到col的迭代器
        Iterator i = col.iterator();
        //2.使用while循环遍历
        while (i.hasNext()) {  //判断是否还有数据
            //返回下一个元素，类型是Object
            Object obj = i.next();
            System.out.println(obj);
        }
        //3.当退出while循环后，这时iterator迭代器，指向最后一个元素
        // i.next();
        //4.如果希望再次遍历，需要重置迭代器
        i = col.iterator();

    }
    }

    class Book{
        private String name;
        private String author;
        private double price;

        public Book(){

        }

        public Book(String author, String name, double price) {

            this.author = author;
            this.name = name;
            this.price = price;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Boo{" +
                    "author='" + author + '\'' +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

}
