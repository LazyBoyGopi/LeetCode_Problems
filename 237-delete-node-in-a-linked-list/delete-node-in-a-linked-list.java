/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode cur = node;
        ListNode next = node.next;
        int nextval = next.val;
        next.val = cur.val;
        cur.val = nextval;
        cur.next = cur.next.next;
    }
}