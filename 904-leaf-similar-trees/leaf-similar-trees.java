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
    private void getSequence(TreeNode root ,List<Integer>list)
    {
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        getSequence(root.left,list);
        getSequence(root.right,list);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>list1 = new LinkedList<>();
        List<Integer>list2 = new LinkedList<>();
        getSequence(root1,list1);
        getSequence(root2,list2);
        return list1.equals(list2);
    }
}