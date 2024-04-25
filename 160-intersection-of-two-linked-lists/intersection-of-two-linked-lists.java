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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int diff = 0;
        ListNode temp1 = null, temp2 = null;
       if (lenA > lenB) {
            temp1 = headA;
            temp2 = headB;
            diff = lenA-lenB;
        } else {
            temp1 = headB;
            temp2 = headA;
            diff = lenB-lenA;
        }
        while(diff > 0 && temp1 != null)
        {
            temp1 = temp1.next;
            diff--;
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