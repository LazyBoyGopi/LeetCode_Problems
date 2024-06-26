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
    private void getAllElements(TreeNode root,List<Integer>list){
        if(root == null) return;
        if(root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        getAllElements(root.left,list);
        list.add(root.val);
        getAllElements(root.right,list);
    }
    private TreeNode buildTree(List<Integer>list,TreeNode root,int st ,int end){
        if(st > end) return null;
        int mid = (st+end) >> 1;
        root = new TreeNode(list.get(mid));
        root.left = buildTree(list,root.left,st,mid-1);
        root.right = buildTree(list,root.right,mid+1,end);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>list = new LinkedList<>();
        getAllElements(root,list);
        TreeNode ans = new TreeNode() , org = ans;
        return buildTree(list,ans,0,list.size()-1);
    }
}