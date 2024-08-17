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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode ans = new ListNode(),org = ans;

        while(l1 != null || l2 != null){
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int n = n1+n2+rem , cur;
            if(n > 9) {
                cur = n%10;
                n/=10;
                rem = n;
            }
            else {
                cur = n;
                rem = 0;
            }
            ans.next = new ListNode(cur);
            ans = ans.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if(rem != 0){
            ans.next = new ListNode(rem);
            ans = ans.next;
        } 
        return org.next;
    }
}