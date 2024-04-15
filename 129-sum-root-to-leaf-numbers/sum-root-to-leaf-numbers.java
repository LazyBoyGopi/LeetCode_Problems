/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int getSum(TreeNode root,int curVal)
    {
        if(root == null) return 0;
        if(root.left == null && root.right == null)
        {
            curVal = curVal*10 + root.val;
            return curVal;
        }
        int sum = 0;
        curVal = curVal*10+root.val;
        sum += getSum(root.left,curVal);
        sum += getSum(root.right,curVal);
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        return getSum(root,0);
    }
}