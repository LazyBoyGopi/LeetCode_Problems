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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer>set = new HashSet<>();
        for(int ele : nums) set.add(ele);

        ListNode org = new ListNode(), ans = org;
        while(head != null){
            int val = head.val;
            if(!set.contains(val)){
                ans.next = new ListNode(val);
                ans = ans.next;
            }
            head = head.next;
        }
        return org.next;
    }
}