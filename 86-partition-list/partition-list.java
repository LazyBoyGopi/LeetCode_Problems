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
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode() , higher = new ListNode() , org = lesser , higherOrg = higher;

        while(head != null){
            if(head.val < x){
                lesser.next = head;
                lesser = lesser.next;
            }
            else{
                higher.next = head;
                higher = higher.next;
            }
            head = head.next;
        }
        higher.next = null;
        lesser.next = higherOrg.next;
        return org.next;
    }
}