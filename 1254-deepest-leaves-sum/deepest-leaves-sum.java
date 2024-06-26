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
    int maxLevel = -1;
    private void getSum(TreeNode root,int level){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(level > maxLevel){
                sum = root.val;
                maxLevel = level;
            }
            else if(level == maxLevel) 
                sum += root.val;
            return;
        }
        getSum(root.left,level+1);
        getSum(root.right,level+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        getSum(root,0);
        return sum;
    }
}