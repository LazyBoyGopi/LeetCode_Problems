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
    private void getLevelSums(TreeNode root,List<Integer>list,int curLevel){
        if(root == null) return;
        if(list.size() == curLevel) list.add(0);
        list.set(curLevel,list.get(curLevel)+root.val);
        getLevelSums(root.left,list,curLevel+1);
        getLevelSums(root.right,list,curLevel+1);
    }
    private void getAns(TreeNode root,List<Integer>list,int curLevel){
        if(root == null || curLevel+1 >= list.size())return;
        int curSum = 0;
        if(root.left != null) curSum += root.left.val;
        if(root.right != null) curSum += root.right.val;
        int tSum = list.get(curLevel+1);
        if(root.left != null){
            root.left.val = tSum-curSum;
        }
        if(root.right != null){
            root.right.val = tSum-curSum;
        }
        getAns(root.left,list,curLevel+1);
        getAns(root.right,list,curLevel+1);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer>list = new ArrayList();
        getLevelSums(root,list,0);
        getAns(root,list,0);
        root.val = 0;
        return root;
    }
}