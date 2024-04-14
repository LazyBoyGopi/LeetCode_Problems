/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;
        int idx = 1;
        ListNode temp = head, last = null;
        while (temp != null) {
            if (idx == left) {
                int curIdx = idx;
                ListNode rev = null, front = null, temp1 = temp ;
                while (curIdx <= right) {
                    front = temp1.next;
                    temp1.next = rev;
                    rev = temp1;
                    temp1 = front;
                    curIdx++;
                }
                if(last == null && front == null) return rev;
                else if (last == null && front != null) {
                    ListNode main = rev;
                    temp1 = rev;
                    while (temp1.next != null) {
                        temp1 = temp1.next;
                    }
                    temp1.next = front;
                    return main;
                }
                else if(last != null)
                {
                    last.next = rev;
                    temp1 = last;
                    while (temp1.next != null) {
                        temp1 = temp1.next;
                    }
                    temp1.next = front;
                    break;
                }

            }
            last = temp;
            temp = temp.next;
            idx++;
        }
        return head;
    }
}