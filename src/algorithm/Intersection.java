package algorithm;

import java.util.HashSet;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
      /*  HashSet<Integer> set=new HashSet<>();
        for(int n:nums1){
            for(int i=0;i<nums2.length;i++){
                if(n==nums2[i] && !set.contains(n)){
                    set.add(n);
                }
            }
        }
        int[] array = new int[set.size()];
        int index = 0;
        for (int num : set) {
            array[index++] = num;
        }
        return array;

       */
        //优化：
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int n : nums1) set1.add(n);
        for (int n : nums2) {
            if (set1.contains(n)) resultSet.add(n);
        }

        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int n : resultSet) result[i++] = n;
        return result;
    }
}
