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
    private boolean recu(TreeNode root,int targetSum,int sum){
        if(root == null) return false;
        sum += root.val;
        if(root.left == null && root.right == null){
            return sum == targetSum;
        }
        if(recu(root.left,targetSum,sum)) return true;
        return recu(root.right,targetSum,sum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recu(root,targetSum,0);
    }
}