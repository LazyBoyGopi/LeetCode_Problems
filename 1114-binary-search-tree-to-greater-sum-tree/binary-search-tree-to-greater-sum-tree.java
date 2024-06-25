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
    int sum = 0;
    private void getAns(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            sum += root.val;
            root.val = sum;
            return;
        }
        getAns(root.right);
        sum += root.val;
        root.val = sum;
        getAns(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        getAns(root);
        return root;
    }
}