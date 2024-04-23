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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ar = new int[m][n];
        int left = 0 , right = n-1 , top = 0 , bottom = m-1;
        while(left <= right && top <= bottom)
        {
            for(int i=left;i<=right && top <= bottom;i++)
            {
                int val = head != null ? head.val : -1;
                if(head != null) head = head.next;
                ar[top][i] = val;
            }
            top++;
            for(int i=top ;i<=bottom && left <= right ;i++)
            {
                int val = head != null ? head.val : -1;
                if(head != null) head = head.next;
                ar[i][right] = val;
            }
            right--;
            for(int i=right ;i>=left && top <= bottom;i--)
            {
                int val = head != null ? head.val : -1;
                if(head != null) head = head.next;
                ar[bottom][i] = val;
            }
            bottom--;
            for(int i=bottom;i>=top && left <= right;i--)
            {
                int val = head != null ? head.val : -1;
                if(head != null) head = head.next;
                ar[i][left] = val;
            }
            left++;
        }
        return ar;
    }
}