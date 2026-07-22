package algorithm;

public class MoveZeros {
    /* public static void moveZeroes(int[] nums) {

         for (int i = 0; i < nums.length; i++) {
             for(int j=i+1;j<nums.length;j++){
                 if(nums[i]==0 && nums[j]!=0){
                     int t=nums[i];
                     nums[i]=nums[j];
                     nums[j]=t;
                 }
             }
         }


     }

     public static void main(String[] args){
         int[] a={0,1,0,3,5,0,12,5,12};
         MoveZeros.moveZeroes(a);
         for (int i=0;i<a.length;i++){
             System.out.print(a[i]+" ");
         }
     }

     */
    //优化：
    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;  // 指向下一个非零元素应该放的位置
        // 把所有非零元素按顺序挪到前面
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        // 后面全部补0
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}
