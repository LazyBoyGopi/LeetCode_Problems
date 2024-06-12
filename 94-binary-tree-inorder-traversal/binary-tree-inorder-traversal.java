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
    private void recu(TreeNode root,List<Integer>list){
        if(root == null) return;
        if(root.right == null && root.left == null) {
            list.add(root.val);
            return;
        }
        recu(root.left,list);
        list.add(root.val);
        recu(root.right,list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list = new LinkedList<>();
        recu(root,list);
        return list;
    }
}