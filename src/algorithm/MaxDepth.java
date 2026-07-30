package algorithm;

public class MaxDepth {
    public int maxDepth(TreeNode2 root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

 class TreeNode {
      int val;
      TreeNode2 left;
      TreeNode2 right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode2 left, TreeNode2 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }