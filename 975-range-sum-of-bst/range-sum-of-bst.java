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
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int rootVal = root.val , total = 0;
        if(rootVal >= low && rootVal <= high){
            total += rootVal + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        }
        else{
            if(rootVal > high){
                total += rangeSumBST(root.left,low,high);
            }
            if(rootVal < low){
                total += rangeSumBST(root.right,low,high);
            }
        }
        return total;
    }
}