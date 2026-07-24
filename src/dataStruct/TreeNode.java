package dataStruct;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public  TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
    // 先序
    void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
    // 中序
    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    //后序
    void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

}
