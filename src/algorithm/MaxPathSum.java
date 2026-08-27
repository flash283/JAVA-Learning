package algorithm;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
    }
    private int dfs(TreeNode root,int[] max){
        if(root==null) return 0;
        int left=Math.max(dfs(root.left,max),0);
        int right=Math.max(dfs(root.right,max),0);
        max[0]=Math.max(max[0],left+right+root.val);
        return Math.max(left, right) + root.val;
    }
}
