package Map;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {
    static void main(String[] args) {
        Map map=new HashMap();

        //put:添加
        map.put("邓超","l");
        map.put("邓超","孙俪");//替换
        map.put(null,null);
        map.put("w","l");
        System.out.println(map);

        //remove:根据键删除映射关系
        map.remove(null);
        System.out.println(map);

        //get:根据键获取值
        Object k=map.get("邓超");
        System.out.println(k);

        //size:获取元素个数
        System.out.println(map.size());

        //isEmpty:判断个数是否为0
        System.out.println(map.isEmpty());

        //clear:清除k-v
        map.clear();
        System.out.println(map);

        //containsKey:查找键是否存在
        System.out.println(map.containsKey("d"));
    }
}
