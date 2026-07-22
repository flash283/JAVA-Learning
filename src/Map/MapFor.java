package Map;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class MapFor {
    static void main(String[] args) {
        Map map=new HashMap();
        map.put("邓超","l");
        map.put("邓超","孙俪");
        map.put(null,null);
        map.put("w","l");

        //第一组：先取出所有的Key,通过Key取出对应的Value
        Set keyset=map.keySet();
        //(1)增强for
        System.out.println("------------");
        for(Object key:keyset){
            System.out.println(key+"-"+map.get(key));
        }
        //(2)迭代器
        System.out.println("------------");
        Iterator iterator=keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key+"-"+map.get(key));
        }

        //第二组：把所有的value取出
        Collection values=map.values();
        //可以用遍历Collection的方法

        //第三组：通过EntrySet来获取k-v
        Set entrySet=map.entrySet();//EntrySet<Map.Entry<k,v>>
        //(1)增强for
        for(Object entry:entrySet){
            //将entry转换成Map.Entry
            Map.Entry m=(Map.Entry) entry;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
       // (2)迭代器
        Iterator iterator1=entrySet.iterator();
        while (iterator1.hasNext()) {
            Object next =  iterator1.next();
            Map.Entry m=(Map.Entry)next;
            System.out.println(m.getKey()+"-"+m.getValue());
        }
    }
}
