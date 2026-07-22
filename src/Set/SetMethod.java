package Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMethod {
   public static void main(String[] args) {
       //set 接口的实现类的对象（Set接口对象）,不能存放重复的元素，可以添加一个null
       //存放数据是无序的
       //注意：取出的顺序虽然不是添加的顺序，但顺序是固定的
       Set set=new HashSet();
       set.add("john");
       set.add("lucy");
       set.add("jack");
       set.add("null");
       System.out.println(set);

       //遍历
       //1.迭代器
       Iterator iterator= set.iterator();
       while (iterator.hasNext()) {
           Object next =  iterator.next();
           System.out.println(next);
       }
       //2.增强for
       for(Object o:set){
           System.out.println(o);
       }
       //不能通过索引来获取
    }
}
