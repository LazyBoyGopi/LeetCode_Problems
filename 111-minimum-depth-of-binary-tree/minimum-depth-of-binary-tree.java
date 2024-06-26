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
    int min = (int)1e5+1;
    private void getAns(TreeNode root,int level){
        if(root == null) return;
        if(root.left == null && root.right == null){
            min = Math.min(min,level);
            return;
        }
        getAns(root.left,level+1);
        getAns(root.right,level+1);
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        getAns(root,1);
        return min;
    }
}