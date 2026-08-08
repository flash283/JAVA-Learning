package algorithm;

public class Search1 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            // 左半部分有序
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;  // target 在左半部分
                } else {
                    left = mid + 1;   // target 在右半部分
                }
            }
            // 右半部分有序
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;   // target 在右半部分
                } else {
                    right = mid - 1;  // target 在左半部分
                }
            }
        }
        return -1;
    }
}
