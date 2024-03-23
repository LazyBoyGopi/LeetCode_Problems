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
    public static ListNode reOrderList(ListNode head, ListNode cur)
    {
        ListNode temp;
        if(cur.next != null) temp = reOrderList(head,cur.next);
        else temp = head;
        if(temp == null) return null;
        if(temp == cur || temp.next == cur) {
            cur.next = null;
            return null;
        }
        cur.next = temp.next;
        temp.next = cur;
        return cur.next;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        reOrderList(head,head.next);
        // Stack<ListNode> stack = new Stack<>();
        // ListNode fast = head, slow = head;
        // while(fast != null && fast.next != null)
        // {
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // while(slow != null){
        //     stack.push(slow);
        //     slow = slow.next;
        // }
        // ListNode ans = new ListNode();
        // ListNode org = ans;
        // while(!stack.isEmpty())
        // {
        //     ans.next = head;
        //     ans = ans.next;
        //     head = head.next;
        //     ans.next = stack.pop();
        //     ans = ans.next;
        // }
        // ans.next = null;
        // head = org.next;
    }
}