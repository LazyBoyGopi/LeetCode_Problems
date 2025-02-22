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



 class Solution {
    int idx;
    private int countLevel(String traversal,int idx){
        int l = 0, len = traversal.length(), temp = idx;
        while(idx < len && traversal.charAt(idx) == '-'){
            l++;
            idx++;
        }
        return l;
    }
    private TreeNode constructTree(String traversal,int level,TreeNode root){
        if(idx >= traversal.length())
            return;
        int temp = idx;
        int nextLevel = countLevel(traversal,idx);
        if(nextLevel > level){
            root.left = constructTree(traversal,level+1,root);
        }
    }
    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root = new TreeNode(Integer.parseInt(traversal.get(0)));
        idx = 1;
        constructTree(traversal,idx,0,root);
        return root;
    }
}
 */
class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int level = 0;
            while (i < n && traversal.charAt(i) == '-') {
                level++;
                i++;
            }

            int start = i;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                i++;
            }
            int val = Integer.parseInt(traversal.substring(start, i));

            TreeNode node = new TreeNode(val);
            while (stack.size() > level) {
                stack.pop(); // Ensure the correct parent is found
            }
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}
