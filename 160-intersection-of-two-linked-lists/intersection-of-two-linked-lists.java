/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    private int getLength(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    private ListNode moveCur(ListNode head, int diff) {
        while (diff > 0 && head != null) {
            head = head.next;
            diff--;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int diff = lenA - lenB;
        ListNode temp1 = headA, temp2 = headB;
        if (diff == 0)
            ;
        else if (diff > 0) {
            temp1 = moveCur(temp1, diff);
        } else {
            temp2 = moveCur(temp2, Math.abs(diff));
        }
        while (temp1 != null && temp2 != null) {
            if (temp1 == temp2)
                return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}