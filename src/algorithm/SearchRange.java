package algorithm;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }

    // 找左边界（第一个等于 target 的位置）
    private int findFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                high = mid - 1;  // 往左找
            } else {
                low = mid + 1;
            }
        }
        // low 可能越界或不是 target
        if (low < nums.length && nums[low] == target) {
            return low;
        }
        return -1;
    }

    // 找右边界（最后一个等于 target 的位置）
    private int findLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                low = mid + 1;  // 往右找
            } else {
                high = mid - 1;
            }
        }
        // high 可能越界或不是 target
        if (high >= 0 && nums[high] == target) {
            return high;
        }
        return -1;

    }
}
