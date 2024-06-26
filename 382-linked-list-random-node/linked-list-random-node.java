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
    List<Integer>list;
    static Random random = new Random();
    int size = 0;
    public Solution(ListNode head) {
        ListNode temp = head;
        list = new ArrayList();
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
            size++;
        }
    }
    
    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */