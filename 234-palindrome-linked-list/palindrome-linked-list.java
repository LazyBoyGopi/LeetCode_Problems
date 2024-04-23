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
    private ListNode reverseListFromMid(ListNode mid)
    {
        ListNode pre = null , cur = mid , next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head , slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode end = reverseListFromMid(slow);
        slow = head;
        while(slow != null && end != null)
        {
            if(slow.val != end.val) return false;
            slow = slow.next;
            end = end.next;
        }
        return true;
    }
}