package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListFor {
    public static void main(String[] args){
        List list=new ArrayList();
        list.add("659");
        list.add("kkd");
        list.add("dpl");

        //遍历
        //1.迭代器
        Iterator iterator= list.iterator();
        while(iterator.hasNext()){
            Object o= iterator.next();
            System.out.println(o);
        }

        //2.增强for
        for(Object o:list){
            System.out.println(o);
        }

        //3.普通for
        for(int i=0;i<list.size();i++){
            Object o=list.get(i);
            System.out.println(o);
        }
}

}
