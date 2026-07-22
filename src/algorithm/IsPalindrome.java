package algorithm;

public class IsPalindrome {
    class Solution {
        public static boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                char c1 = s.charAt(left);
                char c2 = s.charAt(right);

                // 跳过左边非字母数字
                if (!((c1 >= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z') || (c1 >= '0' && c1 <= '9'))) {
                    left++;
                    continue;
                }
                // 跳过右边非字母数字
                if (!((c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z') || (c2 >= '0' && c2 <= '9'))) {
                    right--;
                    continue;
                }

                // 统一转小写比较
                if (c1 >= 'A' && c1 <= 'Z') c1 += 32;  // 大写转小写
                if (c2 >= 'A' && c2 <= 'Z') c2 += 32;

                if (c1 != c2) return false;

                left++;
                right--;
            }
            return true;
        }

        //进阶版：
        /*
        class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // 跳过左边非字母数字
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // 跳过右边非字母数字
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            // 比较（统一转小写）
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
         */
        public static void main(String[] args) {
            String s1 = "A man, a plan, a canal: Panama";
            String s2 = "race a car";
            System.out.println(isPalindrome(s1));  // true
            System.out.println(isPalindrome(s2));  // false
        }
    }
}
