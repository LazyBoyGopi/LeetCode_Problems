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
    private ListNode reverseList(ListNode head)
    {
        ListNode ans = null , cur = head , next = null;
        while(head != null)
        {
            next = head.next;
            head.next = ans;
            ans = head;
            head = next;
        }
        return ans;
    }
    public ListNode doubleIt(ListNode head) {
        head = reverseList(head);
        ListNode ans = null , next = null;
        int rem = 0;
        while(head != null)
        {
            int doubleVal = (head.val*2)+rem;
            rem = doubleVal/10;
            if(doubleVal > 9)
            {
                doubleVal %= 10;
            }
            next = head.next;
            head.next = ans;
            ans = head;
            ans.val = doubleVal;
            head = next;
        }
        if(rem > 0)
        {
           ListNode temp = new ListNode(rem);
           temp.next = ans;
            ans = temp;
        }
        return ans;
    }
}