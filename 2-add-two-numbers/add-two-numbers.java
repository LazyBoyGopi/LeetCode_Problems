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
    private ListNode reverse(ListNode head)
    {
        ListNode pre = null , cur = head , next = null;
        while(cur != null)
        {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode org = ans;
        int rem = 0; 
        while(l1 != null && l2 != null)
        {
            int sum = l1.val+l2.val+rem;
            if(sum > 9)
            {
                ans.next = new ListNode(sum%10);
                rem = sum/10;
            }
            else{
                rem = 0;
                ans.next = new ListNode(sum);
            }
            l1 = l1.next;
            l2 = l2.next;
            ans = ans.next;
        }
        while(l1 != null)
        {
            int sum = l1.val+rem;
            if(sum > 9)
            {
                ans.next = new ListNode(sum%10);
                rem = sum/10;
            }
            else{
                rem = 0;
                ans.next = new ListNode(sum);
            }
            l1 = l1.next;
            ans = ans.next;
        }
        while(l2 != null)
        {
            int sum = l2.val+rem;
            if(sum > 9)
            {
                ans.next = new ListNode(sum%10);
                rem = sum/10;
            }
            else{
                rem = 0;
                ans.next = new ListNode(sum);
            }
            l2 = l2.next;
            ans = ans.next;
        }
        if(rem != 0)
        {
            ans.next = new ListNode(rem);
        }
        return org.next;
    }
}