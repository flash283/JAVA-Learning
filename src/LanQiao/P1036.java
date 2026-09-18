package LanQiao;

import java.util.Scanner;

public class P1036 {
    static int n,k,ans=0;
    static int[] nums;
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        k=scanner.nextInt();
        nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        dfs(0,0,0);
        System.out.println(ans);

    }
    static void dfs(int start,int count,int sum){
       if(count==k){
           if(!isPrime(sum)) ans++ ;
           return;
       }
       for(int i=0;i<k;i++){
           dfs(i+1,count+1,sum+nums[i]);
       }
    }
    static boolean isPrime(int num){
        if(num<2) return false;
      for(int i=2;i*i<=num;i++){
          if(num%i==0) return false;
      }
      return true;
    }

 }
