package algorithm;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String first = strs[0];  // 以第一个字符串为基准

        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            // 和其他所有字符串比较第 i 位
            for (int j = 1; j < strs.length; j++) {
                // 某个字符串长度不够了，或者字符不相等
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);  // 返回前面匹配的部分
                }
            }
        }
        return first;  // 第一个字符串全部匹配
    }
}
