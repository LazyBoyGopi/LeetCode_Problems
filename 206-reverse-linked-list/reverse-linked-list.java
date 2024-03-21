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
        List<ListNode> list = new LinkedList<>();
        while(head != null)
        {
            list.add(head);
            head = head.next;
        }
        ListNode ans = new ListNode();
        ListNode org = ans;
        for(int i=list.size()-1;i>=0;i--)
        {
            ans.next = list.get(i);
            ans = ans.next;
            System.out.println(ans.val);
        }
        ans.next = null;
        return org.next;
    }
}