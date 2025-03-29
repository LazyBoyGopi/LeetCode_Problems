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
    private int ifOneEmpty(ListNode l1, ListNode ans, int rem) {
        ListNode newNode = null;
        int curVal = 0, last = 0;
        while (l1 != null) {
            curVal = l1.val + rem;
            last = curVal % 10;
            if (curVal > 9) {
                curVal /= 10;
                rem = curVal % 10;
            } else {
                rem = 0;
            }
            newNode = new ListNode(last);
            newNode.next = ans;
            ans = newNode;
        }
        return rem;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(), org = ans, newNode = null;
        int rem = 0, curVal = 0, last = 0;
        while (l1 != null && l2 != null) {
            curVal = l1.val + l2.val + rem;
            last = curVal % 10;
            if (curVal > 9) {
                curVal /= 10;
                rem = curVal % 10;
            } else {
                rem = 0;
            }
            newNode = new ListNode(last);
            ans.next = newNode;
            ans = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                curVal = l1.val + rem;
                last = curVal % 10;
                if (curVal > 9) {
                    curVal /= 10;
                    rem = curVal % 10;
                } else {
                    rem = 0;
                }
                newNode = new ListNode(last);
                ans.next = newNode;
                ans = newNode;
                l1 = l1.next;
            }
        } else if (l2 != null) {
            while (l2 != null) {
                curVal = l2.val + rem;
                last = curVal % 10;
                if (curVal > 9) {
                    curVal /= 10;
                    rem = curVal % 10;
                } else {
                rem = 0;
                }
                newNode = new ListNode(last);
                ans.next = newNode;
                ans = newNode;
                l2 = l2.next;
            }
        }
        if (rem != 0) {
            newNode = new ListNode(rem);
            ans.next = newNode;
            ans = newNode;
        }
        return org.next;
    }
}