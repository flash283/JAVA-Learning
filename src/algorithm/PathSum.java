package algorithm;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
       List<List<Integer>> result=new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode root,int targetsum,List<Integer> path, List<List<Integer>> result){
        if(root==null) return;

        path.add(root.val);

        if (root.left == null && root.right == null && targetsum == root.val) {
            result.add(new ArrayList<>(path));
        }

        dfs(root.left, targetsum - root.val, path, result);
        dfs(root.right, targetsum - root.val, path, result);

        path.remove(path.size() - 1);


    }
}
