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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) return head;
        if(head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        int idx = 1;
        ListNode start = null , end = null , temp = head;
        while(temp != null)
        {
            if(idx == left-1) start = temp;
            if(idx >= left && idx <= right)
            {
                stack.push(temp);
            }
            if(idx == right+1){
                end = temp;
                 break;
            }
            temp = temp.next;
            idx++;
        }
        boolean isStartFirst = start == null ? true : false;
        if(start == null)
        {
            start = stack.pop();
        }
        ListNode ans = start;

        while(!stack.isEmpty())
        {
            start.next = stack.pop();
            start = start.next;
        }

        start.next = end;
        if(isStartFirst) return ans;
        return head;
    }
}