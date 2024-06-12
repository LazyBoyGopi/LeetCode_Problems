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
/*class Solution {
    private void left(TreeNode root,List<Integer>list){
        if(root == null) {
            list.add(101);
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        left(root.left,list);
        list.add(root.val);
        left(root.right,list);
    }
    private void right(TreeNode root,List<Integer>list){
        if(root == null) {
            list.add(101);
            return;
        }
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        } 
        right(root.right,list);
        list.add(root.val);
        right(root.left,list);
    }
    public boolean isSymmetric(TreeNode root) {
        List<Integer>left = new LinkedList<>() , right = new LinkedList<>();
        left(root.left,left);
        right(root.right,right);
        return left.equals(right);
    }
}*/
class Solution {
    private boolean recu(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        if((left == null || right == null)) return false;
        if(left.val != right.val) return false;
        return recu(left.left,right.right) && recu(left.right,right.left) ;
    }
    public boolean isSymmetric(TreeNode root) {
        return recu(root.left,root.right);
    }
}