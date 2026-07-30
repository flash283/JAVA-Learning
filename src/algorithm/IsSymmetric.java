package algorithm;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode2 root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode2 p, TreeNode2 q) {
        if (p == null && q == null) return true;   // 都为空 → 对称
        if (p == null || q == null) return false;  // 一个为空 → 不对称
        if (p.val != q.val) return false;           // 值不等 → 不对称
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}
class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2() {}
    TreeNode2(int val) { this.val = val; }
    TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}