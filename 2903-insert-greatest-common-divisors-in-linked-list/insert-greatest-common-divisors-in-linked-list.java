/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int getGCD(int a, int b) {
        while(b != 0)
        {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode ans = new ListNode();
        ListNode org = ans;
        int lastVal = head.val;
        ans.next = head;
        ans = ans.next;
        head = head.next;
        while (head != null) {
            int temp = getGCD(lastVal,head.val);
            ans.next = new ListNode(temp);
            ans = ans.next;
            ans.next = head;
            ans = ans.next;
            lastVal = head.val;
            head = head.next;
        }
        if(ans != null)
        ans.next = null;
        return org.next;
    }
}