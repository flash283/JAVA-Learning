package Collection;


import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    public static void main(String[] args){
       List list=new ArrayList();

       //add:添加单个元素
        list.add("jack");
        list.add(10);
        list.add(true);
        System.out.println(list);

        //remove:删除指定元素
        list.remove(true);
     //   list.remove(new Integer(10));
        System.out.println("list="+list);

        //contains:查找元素是否存在
        System.out.println( list.contains(0));

        //size:获取元素个数
        System.out.println(list.size());

        //isEmpty:判断是否为空
        System.out.println(list.isEmpty());

        //clear:清空
       list.clear();
        System.out.println(list);

        //addAll:添加多个元素
        ArrayList list2=new ArrayList();
        list2.add("红楼梦");
        list2.add("三国");
        list.addAll(list2);
        System.out.println("list="+list);

        //containsAll:查找多个元素是否存在
        System.out.println(list.contains(list2));

        //removeAll:删除多个元素
        list.add("聊斋");
        list.removeAll(list2);
        System.out.println(list);

    }

}
