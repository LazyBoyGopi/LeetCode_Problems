/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode[] checkLeftAndRight(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return new TreeNode[]{null,null}; 
        }
        TreeNode[]left = checkLeftAndRight(root.left,p,q);
        TreeNode[]right = checkLeftAndRight(root.right,p,q);
        if((left[0] != null || left[1] != null) && (right[0] != null || right[1] != null))
            {
                return new TreeNode[]{root,null};
            }
        if((left[0] != null || left[1] != null || right[0] != null || right[1] != null) && (q.val == root.val || p.val == root.val)){
            return new TreeNode[]{root,null};
        }
        TreeNode[]ar = new TreeNode[2];
        if(root.val == p.val)
            ar[0] = p;
        else if(root.val == q.val)
            ar[1] = q;
        ar[0] = ar[0] != null ? ar[0] : (left[0] != null ? left[0] : right[0]);
        ar[1] = ar[1] != null ? ar[1] : (right[1] != null ? right[1] : left[1]);
        return ar;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return checkLeftAndRight(root,p,q)[0];
    }
}