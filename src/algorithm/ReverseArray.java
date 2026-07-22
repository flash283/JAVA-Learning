package algorithm;

public class ReverseArray {
 /*  public static void main(String[] args){
        int[] a={1,2,3,4,5,6,7,8,9};
      for(int i=0;i<a.length/2;i++){
          for(   int j=a.length-1;j>i;j--) {
                 if ((i + j) == (a.length - 1)) {
                    int t = a[i];
                     a[i] = a[j];
                    a[j] = t;

                }
            }
       }
       for (int i=0;i<a.length;i++){
           System.out.print(a[i]+" ");
        }
       }

  */
    //优化后：
    public static void reverse(int[] a){
        if(a==null ||a.length==0){
            return;
        }
        int left=0;
        int right=a.length-1;
        while(left<right){
            int t=a[left];
            a[left]=a[right];
            a[right]=t;
            left++;
            right--;
        }
    }

    public static void print(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();

    }
    public  static void main(String[] args){
        int[] a={1,2,3,4,5,6};
        System.out.println("原数组：");
        ReverseArray.print(a);
        System.out.println("反转后：");
        ReverseArray.reverse(a);
        ReverseArray.print(a);
    }
}
