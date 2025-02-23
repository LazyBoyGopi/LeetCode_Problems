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
    int rIdx, lIdx;
    private TreeNode constructTree(int[] preorder,int[] postorder){
        if(lIdx >= preorder.length || rIdx >= postorder.length)
            return null;
        TreeNode root = new TreeNode(preorder[lIdx]);
        lIdx++;

        if(root.val != postorder[rIdx])
            root.left = constructTree(preorder,postorder);
        if(root.val != postorder[rIdx])
            root.right = constructTree(preorder,postorder);
            
        rIdx++;
        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        lIdx = 0;
        rIdx = 0;
        return constructTree(preorder,postorder);
    }
}