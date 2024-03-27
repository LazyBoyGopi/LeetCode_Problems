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
    void addAllNodes(List<Integer>list ,TreeNode root)
    {
        if(root == null) return ;
        list.add(root.val);
        addAllNodes(list,root.left);
        addAllNodes(list,root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>list = new LinkedList<>();
        addAllNodes(list,root);
        return list;
    }
}