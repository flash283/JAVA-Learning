package Collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    public static void main(String[] args) {
        Collection co = new ArrayList();

        co.add(new Boo("罗贯中", "三国", 10.1));
        co.add(new Boo("古龙", "小李飞刀", 5.1));
        co.add(new Boo("曹雪芹", "红楼", 34.6));

        //使用增强for
        for(Object b:co){
            System.out.println(b);
        }
        //也可用在数组
        int[] num={1,2,3};
        for(int i:num){
            System.out.println(i);
        }

    }
}
class Boo {
    private String name;
    private String author;
    private double price;

    public Boo(){

    }

    public Boo(String author, String name, double price) {

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