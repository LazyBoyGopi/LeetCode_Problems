/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        traverse(root.left, list);
        traverse(root.right, list);
    }

    public void flatten(TreeNode root) {
        List<Integer>list = new ArrayList();
        traverse(root,list);
        TreeNode org = root;
        int len = list.size();
        for(int i=0;i<len;i++){
            root.val = list.get(i);
            root.left = null;
            if(i != len-1)
            {
                if(root.right != null)
                root = root.right;
            else {
                TreeNode r = new TreeNode();
                root.right = r;
                root = r;
            }
            }
        }
        root = org;
    }
}