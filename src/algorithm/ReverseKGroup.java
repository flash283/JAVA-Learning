package algorithm;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        // 判断剩余是否有 k 个
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count < k) return head;  // 不够 k 个，不翻

        // 翻转前 k 个
        ListNode prev = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // 递归翻转后面的，接到当前组后面
        head.next = reverseKGroup(curr, k);

        return prev;  // prev 是翻转后的新头
    }
}
