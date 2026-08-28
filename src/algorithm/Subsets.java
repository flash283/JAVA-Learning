package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));  // 每种状态都是子集

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);              // 选
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);   // 撤销
        }
    }
}
