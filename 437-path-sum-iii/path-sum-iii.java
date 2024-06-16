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
    int count = 0;
    private void recu(TreeNode root,int targetSum,long sum){
        if(root == null) {
            return;
        }
        sum += root.val;
        if(sum == targetSum) count++;
        recu(root.left,targetSum,sum);
        recu(root.right,targetSum,sum);
    }
    private void count(TreeNode root,int targetSum){
        if(root == null) return;
        recu(root,targetSum,0L);
        count(root.left,targetSum);
        count(root.right,targetSum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        count(root,targetSum);
        return count;
    }
}