package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(nums,new ArrayList<>(),res);
        return res;
    }

    private void backtrack(int[] nums,List<Integer> path,List<List<Integer>> res){
      if(path.size()==nums.length){
          res.add(new ArrayList<>(path));
      }
      for(int num:nums){
          if(path.contains(num)) continue;
          path.add(num);
          backtrack(nums,path,res);
          path.remove(path.size()-1);
      }
    }

}
