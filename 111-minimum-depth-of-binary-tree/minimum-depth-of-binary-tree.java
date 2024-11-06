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
    int minDepth = Integer.MAX_VALUE;
    private void getDepth(TreeNode root,int curDepth){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth,curDepth+1);
            return;
        }
        getDepth(root.left,curDepth+1);
        getDepth(root.right,curDepth+1);
    }
    public int minDepth(TreeNode root) {
        minDepth = Integer.MAX_VALUE;
        getDepth(root,0);
        return minDepth == Integer.MAX_VALUE ? 0 : minDepth;
    }
}