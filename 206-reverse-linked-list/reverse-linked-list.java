/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = head;
        while(temp != null)
        {
            ListNode front = temp.next;
            temp.next = pre;
            pre = temp;
            temp = front;
        }
        return pre;
    }
}