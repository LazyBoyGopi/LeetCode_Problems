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
    private TreeNode removeLeaf(TreeNode root , int target){
        if(root == null) return null;
        root.left = removeLeaf(root.left,target);
        root.right = removeLeaf(root.right,target);
        if(root.left == null && root.right == null && root.val == target){
            return  null;
        }
        return root;
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeLeaf(root,target);
    }
}