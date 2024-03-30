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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int idx = 0;
        ListNode org = list1;
        while (list1 != null) {
            if (idx == a - 1) {
                ListNode temp = list1.next;
                list1.next = list2;
                list1 = temp;
            }
            if (idx == b) {
                while (list2.next != null) {
                    list2 = list2.next;
                }
                list2.next = list1;
                break;
            }
            idx++;
            list1 = list1.next;
        }
        return org;
    }
}