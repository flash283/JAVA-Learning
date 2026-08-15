package algorithm;

public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pLeft, int pRight,
                           int[] inorder, int iLeft, int iRight) {
        if (pLeft > pRight) return null;

        int rootVal = preorder[pLeft];   // 前序第一个是根
        TreeNode root = new TreeNode(rootVal);

        int index = iLeft;
        while (inorder[index] != rootVal) index++;  // 在中序找根的位置

        int leftSize = index - iLeft;    // 左子树节点数

        root.left = build(preorder, pLeft + 1, pLeft + leftSize,
                inorder, iLeft, index - 1);
        root.right = build(preorder, pLeft + leftSize + 1, pRight,
                inorder, index + 1, iRight);
        return root;
    }
}