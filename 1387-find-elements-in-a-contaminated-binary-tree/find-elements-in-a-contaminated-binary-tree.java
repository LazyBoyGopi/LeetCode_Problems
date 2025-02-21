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
class FindElements {
    private Set<Integer>set;
    private void addIntoSet(TreeNode root,int val){
        if(root == null)
            return;
        if(root.left != null){
            int curVal = val*2+1;
            set.add(curVal);
            addIntoSet(root.left,curVal);
        }
        if(root.right != null){
            int curVal = val*2+2;
            set.add(curVal);
            addIntoSet(root.right,curVal);   
        }
    }
    public FindElements(TreeNode root) {
        set = new HashSet();
        set.add(0);
        addIntoSet(root,0);
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */