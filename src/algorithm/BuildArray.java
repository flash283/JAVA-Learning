package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int index = 0;  // 指向 target 当前要匹配的位置

        for (int i = 1; i <= n && index < target.length; i++) {
            result.add("Push");
            if (target[index] == i) {
                index++;          // 匹配上，看下一个
            } else {
                result.add("Pop"); // 不匹配，Push 后马上 Pop
            }
        }
        return result;
    }
}
