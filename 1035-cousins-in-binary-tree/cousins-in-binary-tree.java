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
    public int[]ar = {-1,-1};
    private void getAns(TreeNode root, int x, int y,int curLevel){
        if(root == null) return;
        if(root.left != null && root.right != null && ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x))) {
            ar[0] = -2;
            ar[1] = -2;
            return;
        }
        if(root.left != null ){
            if(root.left.val == x)
                ar[0] = curLevel;
            else if(root.left.val == y) ar[1] = curLevel;
        }
        if(root.right != null ){
            if(root.right.val == y)
                ar[1] = curLevel;
            else if(root.right.val == x)
                ar[0] = curLevel;
        }

        getAns(root.left,x,y,curLevel+1);
        getAns(root.right,x,y,curLevel+1);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        ar[0] = 0;
        ar[1] = 0;
        getAns(root,x,y,0);
        System.out.println(ar[0]+" "+ar[1]);

        if((ar[0] == 0 || ar[1] == 0) || (ar[0] == -2 || ar[1] == -2)) return false;
        return ar[0] == ar[1];
    }
}