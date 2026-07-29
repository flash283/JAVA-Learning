package algorithm;

import java.util.HashMap;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
     if(s.length()!=t.length()){
         return false;
     }

        HashMap<Character,Character> m1=new HashMap<>();
        HashMap<Character,Character> m2=new HashMap<>();

       for(int i=0;i<s.length();i++){
           char c1=s.charAt(i);
           char c2=t.charAt(i);

           if( m1.containsKey(c1) &&  m1.get(c1)!=c2  ){
               return false;
           }
           if( m2.containsKey(c2) &&  m1.get(c1)!=c1){
               return false;
           }

           m1.put(c1,c2);
           m2.put(c2,c1);
       }
       return true;
    }
}
