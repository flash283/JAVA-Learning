package algorithm;

public class MySqrt {
        public int mySqrt(int x) {
            if (x == 0) return 0;
            int low = 1;
            int high = x;
            int ans = 0;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mid <= x / mid) {  // 用除法避免溢出
                    ans = mid;         // 记录当前可能的答案
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return ans;
        }

}
