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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        ListNode ans = new ListNode();
        ListNode org = ans;
        while(!stack.isEmpty())
        {
            ans.next = head;
            ans = ans.next;
            head = head.next;
            ans.next = stack.pop();
            ans = ans.next;
        }
        ans.next = null;
        head = org.next;
    }
}