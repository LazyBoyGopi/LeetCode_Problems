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
    public int pairSum(ListNode head) {
        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        while(slow != null)
        {
            stack.add(slow.val);
            slow = slow.next;
        }
        int max = 0;
        slow = head;
        while(!stack.isEmpty())
        {
            max = Math.max(max,slow.val+stack.pop());
            slow = slow.next;
        }
        return max;
    }
}