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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode org = l1;
        ListNode pre = l1;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + rem;
            if (sum > 9) {
                l1.val = sum % 10;
                rem = sum / 10;
            } else {
                rem = 0;
                l1.val = sum;
            }
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + rem;
            if (sum > 9) {
                l1.val = sum % 10;
                rem = sum / 10;
            } else {
                rem = 0;
                l1.val = sum;
            }
            pre = l1;
            l1 = l1.next;
        }
        l1 = pre;
        while (l2 != null) {
            int sum = l2.val + rem;
            if (sum > 9) {
                l1.next = new ListNode(sum % 10);
                rem = sum / 10;
            } else {
                rem = 0;
                l1.next = new ListNode(sum);
            }
            pre = l1;
            l2 = l2.next;
            l1 = l1.next;
        }

        if (rem != 0) {
            if(l1 == null)
                l1 = pre;
            l1.next = new ListNode(rem);
        }
        return org;
    }
}