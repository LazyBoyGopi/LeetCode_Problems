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
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head , fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null)
        {
            stack.push(slow.val);
            slow = slow.next;
        }
        slow = head;
        int sum = 0;
        while(!stack.isEmpty()){
            sum = Math.max(sum,stack.pop()+slow.val);
            slow = slow.next;
        }
        return sum;
    }
}