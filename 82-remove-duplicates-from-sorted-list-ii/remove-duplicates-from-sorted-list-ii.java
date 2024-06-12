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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode preLast = new ListNode(),org = preLast;

        ListNode last = head;
        head = head.next;
        boolean found = false;
        while(head != null){
            if(last.val == head.val){
                found = true;
            }
            while(head != null && last.val == head.val) head = head.next;
            if(!found) {
                preLast.next = last;
                preLast = preLast.next;
            } 
            System.out.println(last.val);
            last = head;
            found = false;
            if(head != null)
            head = head.next;
        }
        preLast.next = last;

        return org.next;
    }
}