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
        ListNode pre = null , cur = mid;
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head , fast = head;
        int count =0;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }
        ListNode mid = reverseListFromMid(slow);
        slow = head;
        int tempCount = 0;
        while(tempCount < count && mid != null )
        {
            if(mid.val != slow.val) return false;
            mid = mid.next;
            slow = slow.next;
            tempCount++;
        }
        return true;
    }
}