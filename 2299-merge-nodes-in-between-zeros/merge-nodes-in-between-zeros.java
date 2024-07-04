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
    public ListNode mergeNodes(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return null;
        ListNode ans = new ListNode() , org = ans;
        int curSum = 0;
        head = head.next;
        while(head != null){
            curSum += head.val;
            if(head.val == 0){
                ans.next = new ListNode(curSum);
                ans = ans.next;
                curSum = 0;
            }
            head = head.next;
        }
        return org.next;
    }
}