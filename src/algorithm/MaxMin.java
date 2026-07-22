package algorithm;

import java.util.Arrays;

public class MaxMin {
   /* public static void main(String[] args){
        int[] arr={1,5,6,9,8,7,877,98,45,0,9584};
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
        int min=arr[0],max=arr[arr.length-1];

    }

    */
    //优化后的

    // 找最大值
        public static int max(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }

        // 找最小值
        public static int min(int[] arr) {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }

        // 主方法，测试用
        public static void main(String[] args) {
            int[] arr = {1, 5, 6, 9, 8, 7, 877, 98, 45, 0, 9584};

            System.out.println("最大值：" + max(arr));
            System.out.println("最小值：" + min(arr));
        }
    }

