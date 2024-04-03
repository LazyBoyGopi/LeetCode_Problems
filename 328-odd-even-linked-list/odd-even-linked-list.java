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
    public ListNode oddEvenList(ListNode head) {
        Queue<ListNode> stack = new ArrayDeque<>();
        ListNode ans = new ListNode();
        ListNode org = ans;
        head = head;
        while(head != null)
        {
            ans.next = head;
            ans = head;
            head = head.next;
            if(head != null)
            {
                stack.add(head);
                head = head.next;
            }
        }
        while(!stack.isEmpty())
        {
           ans.next =  stack.poll();
           ans = ans.next;
        }
        ans.next = null;
        return org.next;
    }
}