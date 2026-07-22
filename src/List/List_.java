package List;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    public static void main(String[] args){
        //1.List集合类中元素有序且可重复
        List list=new ArrayList();
        list.add("jack");
        list.add("tom" );
        list.add("mary");
        list.add("tom");
        System.out.println(list);
        //2.List集合中每个元素都有其对应顺序索引,索引从0开始
        System.out.println(list.get(0));
    }

}
