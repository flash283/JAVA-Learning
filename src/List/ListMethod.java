package List;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    public static void main(){
        List list =new ArrayList();
        list.add("jangsan");
        list.add("lk");
        //void add(int index,Object ele):在index位置插入ele元素
        //在index=1的位置插入一个对象
        list.add(1,"han");
        System.out.println(list);
        //boolean addAll(int index,Collection eles):从index位置开始将所有的元素添加进来
        List list2=new ArrayList();
        list2.add("jack");
        list2.add("y");
        list.addAll(1,list2);
        System.out.println(list);
        //Object get(int index):获取指定index位置元素

        //int indexOf(Object obj):返回obj在当前集合中首次出现的位置
         System.out.println(list.indexOf("y"));
         //int lastIndexOf(Object obj):返回obj在集合中最后一次出现的位置
        list.add("lk");
        System.out.println(list.lastIndexOf("lk"));
        //Object remove(int index):移除指定位置index的元素,并返回此元素
        list.remove(0);
        System.out.println(list);
        //Object set(int index,Object ele):设置指定位置index的元素为ele，相当于是替换
       list.set(1,"ma");
        System.out.println(list);
        //List subList(int fromIndex,int toIndex):返回从fromIndex到toIndex位置的子集合
        //注意返回的子集合   fromIndex <= sublist < toIndex
        List list1 = list.subList(0, 2);
        System.out.println(list1);


    }
}
