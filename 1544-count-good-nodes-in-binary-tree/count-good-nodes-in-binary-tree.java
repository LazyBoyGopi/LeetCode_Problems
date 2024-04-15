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
    private int getGoodNodes(TreeNode root,int max)
    {
        if(root == null) return 0;
        max = Math.max(max,root.val);
        int count =0;
        if(root.val >= max) count++;
        return count + getGoodNodes(root.left,max) + getGoodNodes(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        return getGoodNodes(root,Integer.MIN_VALUE);
    }
}