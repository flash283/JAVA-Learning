package algorithm;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
     /* 太复杂，并且有问题   ListNode l=list1;
        ListNode l1=list1;
        ListNode l2=list2;
        int a=l1.next.val;
        int b=0;
        while(l!=null){
            b=l.next.val;
            l=l.next;
        }
        while(l2!=null){
            ListNode n1=l1.next;
            ListNode n2=l2.next;
          if(n2.val<=a){
              l2.next=n2.next;
              n2.next=n1;
              continue;
          }else if(n2.val<n1.next.val){
              l2.next=n2.next;
              n2.next=n1.next;
          }else if(n2.val>b){
              l.next=l2;
          }
        }
        return l1;
    }

      */

        // 简洁：


                ListNode dummy = new ListNode(0);  // 虚拟头节点
                ListNode curr = dummy;

                while (list1 != null && list2 != null) {
                    if (list1.val <= list2.val) {
                        curr.next = list1;
                        list1 = list1.next;
                    } else {
                        curr.next = list2;
                        list2 = list2.next;
                    }
                    curr = curr.next;
                }

                // 把剩下的直接接上
                curr.next = (list1 != null) ? list1 : list2;

                return dummy.next;  // 返回虚拟头节点的下一个
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