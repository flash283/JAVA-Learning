package algorithm;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return getdepth(root)!=-1;

    }
    private int getdepth(TreeNode root){
        if(root==null) return 0;

        int left=getdepth(root.left);
        if(left==-1) return -1;

        int right=getdepth(root.right);
        if(right==-1) return -1;

        if(Math.abs(left-right)>1) return -1;

        return Math.max(left,right)+1;
    }
}
