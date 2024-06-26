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
    private void inorder(TreeNode root,List<Integer>list){
        if(root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    private TreeNode buildTree(List<Integer>list,int st,int end){
        if(st > end) return null;
        int mid = (st+end) >> 1;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list,st,mid-1);
        root.right = buildTree(list,mid+1,end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>list = new LinkedList<>();
        inorder(root,list);
        return buildTree(list,0,list.size()-1);
    }
}