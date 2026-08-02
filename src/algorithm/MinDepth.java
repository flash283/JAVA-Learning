package algorithm;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 叶子节点
        if (root.left == null && root.right == null) return 1;
        // 只有一边有子节点
        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;
        // 两边都有，取较小
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
