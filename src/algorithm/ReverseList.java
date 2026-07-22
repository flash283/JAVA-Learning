package algorithm;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
    /*  容易出现问题
        ListNode p=head;
        while(p!=null){
            ListNode l=p.next;
            l.next.next=p.next;
            p=l;
        }
        return p;
    }

     */
        //新方法：
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;  // 记下下一个节点
            curr.next = prev;           // 反转当前节点
            prev = curr;                // prev 后移
            curr = next;                // curr 后移
        }
        return prev;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}