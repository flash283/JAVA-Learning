package algorithm;

import java.util.HashMap;
import java.util.HashSet;

public class deteCycle {
    public ListNode detectCycle(ListNode head) {

       /*
        HashSet<ListNode> set=new HashSet<>();
        ListNode p=head;
        while (p!=null){
            if(set.contains(p)){
                return p;
            }
            set.add(p);
            p=p.next;
        }
        return null;

        */
        //优化：快慢指针
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
