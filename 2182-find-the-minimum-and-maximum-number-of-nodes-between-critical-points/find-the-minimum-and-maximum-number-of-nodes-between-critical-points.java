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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head.next.next == null) return new int[]{-1,-1};
        int idx = 1 , first = -1 , last = -1,mid = -1;
        int min = Integer.MAX_VALUE , max = -1;
        int lastVal = head.val;
        head = head.next;
        while(head != null && head.next != null){
            if((head.val > lastVal && head.val > head.next.val) || (head.val < lastVal && head.val < head.next.val)){
                if(first == -1){
                    first = idx;
                    mid = idx;
                    last = idx;
                }else{
                    min = Math.min(idx-mid,min);
                    mid = idx;
                    last = idx;
                }
            }
            idx++;
            lastVal = head.val;
            head = head.next;
        }
        min = (min == Integer.MAX_VALUE) ? -1 : min;
        if(first != -1 && first != last) max = last-first;
        return new int[]{min,max};
    }
}