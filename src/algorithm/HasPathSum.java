package algorithm;

public class HasPathSum {
    public boolean hasPathSum(TreeNode4 root, int targetSum) {


        if (root == null) return false;

        // 如果是叶子节点，判断值是否等于剩余 targetSum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // 减去当前节点的值，继续往左右子树找
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }
}
class TreeNode4 {
    int val;
    TreeNode4 left;
    TreeNode4 right;
    TreeNode4() {}
    TreeNode4(int val) { this.val = val; }
    TreeNode4(int val, TreeNode4 left, TreeNode4 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
