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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        while(head != null)
        {
            stack.push(head);
            head = head.next;
        }
        ListNode ans = new ListNode();
        ListNode org = ans;
        while(!stack.isEmpty())
        {
            ans.next = stack.pop();
            ans = ans.next;
        }
        ans.next = null;
        return org.next;
    }
}