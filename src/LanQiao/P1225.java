package LanQiao;

import java.math.BigInteger;
import java.util.Scanner;

public class P1225 {
   public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        BigInteger a=BigInteger.ONE;
        BigInteger b=BigInteger.TWO;

        if(n<=2){
            System.out.println(n);
            return;
        }

        for(int i=3;i<=n;i++){
            BigInteger c=a.add(b);
            a=b;
            b=c;
        }

        System.out.println(b);




    }
}
