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
    int deepestLevel;
    int leafsWithDeepestLevel;
    TreeNode ans;
    private void getNumberLeafNodes(TreeNode root, int level){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(deepestLevel < level){
                leafsWithDeepestLevel = 1;
                deepestLevel = level;
            }else if(deepestLevel == level){
                leafsWithDeepestLevel++;
            }
            return;
        }
        getNumberLeafNodes(root.left,level+1);
        getNumberLeafNodes(root.right,level+1);
    }
    private int getRootOfLCA(TreeNode root, int level){
        if(root == null)
            return 0;
        int leftLeafs = getRootOfLCA(root.left,level+1);
        int rightLeafs = getRootOfLCA(root.right,level+1);
        if(leftLeafs == -1 || rightLeafs == -1){
            return -1;
        }
        if(leftLeafs + rightLeafs == leafsWithDeepestLevel){
            ans = root;
            return -1;
        }
        if(root.left == null && root.right == null){
            if(level == deepestLevel)
            {
                if(leafsWithDeepestLevel == 1)
                    {
                        ans = root;
                        return -1;
                    }
                return 1;
            }
            return 0;
        }
        return leftLeafs+rightLeafs;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        deepestLevel = 0;
        leafsWithDeepestLevel = 0;
        getNumberLeafNodes(root, 0);
        getRootOfLCA(root,0);
        return ans;
    }
}