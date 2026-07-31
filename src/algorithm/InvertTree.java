package algorithm;

public class InvertTree {
    public TreeNode4 invertTree(TreeNode4 root) {
        if (root == null) return null;           // 空节点直接返回

        // 交换左右子树
        TreeNode4 temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 递归翻转左右子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
   class TreeNode3 {
      int val;
      TreeNode4 left;
      TreeNode4 right;
      TreeNode3() {}
      TreeNode3(int val) { this.val = val; }
      TreeNode3(int val, TreeNode4 left, TreeNode4 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}
