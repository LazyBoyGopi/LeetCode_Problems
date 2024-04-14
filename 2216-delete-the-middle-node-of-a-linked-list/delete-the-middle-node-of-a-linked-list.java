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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        if(head.next.next == null){
            head.next = null;
            return head;
        } 
        ListNode org = head , fast = head , slow = head;
        ListNode last = head;
        int len = 0;
        while(fast != null && fast.next != null)
        {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
            len += 2;
        }
        if(len % 2 == 1)
        {
            slow.next= slow.next.next;
        }
        else{
            last.next = last.next.next;
        }
        return org;
    }
}