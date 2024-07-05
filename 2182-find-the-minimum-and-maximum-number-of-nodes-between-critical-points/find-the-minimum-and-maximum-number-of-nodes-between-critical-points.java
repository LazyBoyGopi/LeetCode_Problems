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
        List<Integer>list = new ArrayList<>();
        int idx = 1;
        int last = head.val;
        head = head.next;
        while(head != null && head.next != null){
            if((head.val > last && head.val > head.next.val) || (head.val < last && head.val < head.next.val)){
                list.add(idx);
            }
            idx++;
            last = head.val;
            head = head.next;
        }
        if(list.size() < 2) return new int[]{-1,-1};
        int min = Integer.MAX_VALUE;
        int max = list.get(list.size()-1) - list.get(0);
        for(int i=0;i<list.size()-1;i++){
            min = Math.min(min,list.get(i+1)-list.get(i));
        }
        return new int[]{min,max};
    }
}