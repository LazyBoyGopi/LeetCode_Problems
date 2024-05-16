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
    private boolean getAns(TreeNode root){
        if(root.left == null && root.right == null){
            if(root.val == 1) return true;
            return false;
        }
        if(root.val == 2){
            return getAns(root.left) || getAns(root.right);
        }
        else return getAns(root.left) && getAns(root.right);
    }
    public boolean evaluateTree(TreeNode root) {
        return getAns(root);
    }
}