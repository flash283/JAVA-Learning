package Set;

import java.util.HashSet;
import java.util.Set;

public class HashSet_ {
   public static void main(String[] args) {
      //HashSet可以存放null,但只能存放一个null
       Set hashset=new HashSet();
       hashset.add(null);
       hashset.add(null);
       System.out.println(hashset);
   }

}
