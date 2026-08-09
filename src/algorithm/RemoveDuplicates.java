package algorithm;

public class RemoveDuplicates{
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();  // 当栈用
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);  // 相同就删
            } else {
                sb.append(c);  // 不同就加
            }
        }
        return sb.toString();
    }
}
