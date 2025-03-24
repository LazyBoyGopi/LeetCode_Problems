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
    private boolean traverseTree(TreeNode root,int k,Set<Integer>set){
        if(root == null){
            return false;
        }
        int val = root.val, comp = k-val;
        if(set.contains(comp))
            return true;
        set.add(val);
        return traverseTree(root.left,k,set) || traverseTree(root.right,k,set);
    }
    public boolean findTarget(TreeNode root, int k) {
        return traverseTree(root,k,new HashSet());
    }
}