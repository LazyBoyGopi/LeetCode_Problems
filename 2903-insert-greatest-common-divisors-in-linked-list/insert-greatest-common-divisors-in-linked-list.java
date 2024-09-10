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
    private int getLargestCommonDivisor(int a,int b)
    {
        if(a > b) return getLargestCommonDivisor(b,a);
        for(int i=a;i>=1;i--){
            if(b % i== 0 && a%i == 0) return i;
        }
        return 1;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dup = head;
        while(dup != null && dup.next != null){
            int last = dup.val, next = dup.next.val;
            int x = getLargestCommonDivisor(last,next);
            ListNode nextNode = dup.next;
            dup.next = new ListNode(x);
            dup = dup.next;
            dup.next = nextNode;
            dup = dup.next;
        }
        return head;
    }
}