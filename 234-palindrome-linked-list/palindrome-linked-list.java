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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
       ListNode slow = head , fast = head;
       while(fast != null && fast.next != null)
       {
        slow = slow.next;
        fast = fast.next.next;
       }
       fast = slow;
       slow = head;
       Stack<Integer> stack = new Stack<>();
        while(fast != null)
        {
            stack.push(fast.val);
            fast = fast.next;
        }
        while(!stack.isEmpty())
        {
            if(slow.val != stack.pop()) return false;
            slow = slow.next;
        }
       return true;
    }
}