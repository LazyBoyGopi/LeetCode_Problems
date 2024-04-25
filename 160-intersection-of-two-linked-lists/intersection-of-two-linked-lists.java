/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private void fillStack(Stack<ListNode>s, ListNode head)
    {
        ListNode temp = head;
        while(temp != null)
        {
            s.push(temp);
            temp = temp.next;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode>s1 = new Stack<>();
        Stack<ListNode>s2 = new Stack<>();
        fillStack(s1,headA);
        fillStack(s2,headB);
        ListNode ans = null;
        while(!s1.isEmpty() && !s2.isEmpty())
        {
            if(s1.peek() != s2.peek()) return ans;
            ans = s1.pop();
            s2.pop();
        }
        return ans;
    }
}