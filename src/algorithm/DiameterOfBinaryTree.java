package algorithm;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
         int[] max={0};
         dfs(root,max);
         return max[0];
    }
    private int dfs(TreeNode root, int[] max){
        if(root==null) return 0;
        int left=dfs(root.left,max);
        int right=dfs(root.right,max);
        max[0]=Math.max(max[0],left+right);
        return Math.max(left, right)+1;

    }

}
