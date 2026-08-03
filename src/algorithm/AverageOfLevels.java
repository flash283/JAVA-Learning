package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
       List<Double> list=new ArrayList<>();
       if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()){
           double sum=0;
           int size=queue.size();
           for (int i=0;i<size;i++){
               TreeNode node=queue.poll();
               sum+=node.val;
               if(node.right!=null) queue.offer(node.right);

               if(node.left!=null) queue.offer(node.left);

           }
       list.add(sum/size);
       }
       return list;
    }
}
