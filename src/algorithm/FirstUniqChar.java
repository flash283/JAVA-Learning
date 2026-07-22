package algorithm;

import java.util.HashMap;

public class FirstUniqChar {
    public int firstUniqChar(String s){
   /*     char[] a=s.toCharArray();
      for(int i=0;i<a.length;i++){
          int count=0;
          for(int j=0;j<a.length;j++){
              if(a[i]==a[j]){
                  count++;
              }
          }
          if(count==1){
              return i;
          }
      }
          return -1;

    */
        //优化：
        //其中getOrDefault 是 HashMap 的一个方法，用来安全地取值，取不到就给个默认值。
        //如果 键 存在，返回对应的值
        //如果 键 不存在，返回你指定的默认值

            HashMap<Character, Integer> map = new HashMap<>();

            // 第一次遍历：统计每个字符出现次数
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);  // c 出现过就取原来的次数+1，没出现过就默认 0 + 1
            }

            // 第二次遍历：找第一个出现次数为 1 的
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

