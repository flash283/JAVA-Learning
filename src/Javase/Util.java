package Javase;

public class Util {
    public class ArrayUtils {
        // 构造方法私有，防止创建对象
        private ArrayUtils() {}

        // 全是静态方法，直接拿类名调用
        public static int max(int[] arr) {
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) max = arr[i];
            }
            return max;
        }

        public static int min(int[] arr) {
            int min = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) min = arr[i];
            }
            return min;
        }

        public static void reverse(int[] arr) {
            int i = 0, j = arr.length - 1;
            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }

}
