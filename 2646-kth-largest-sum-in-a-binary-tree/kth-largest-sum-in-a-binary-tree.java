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
    private void getAllSums(TreeNode root, List<Long>sums, int curLevel){
        if(root == null) return;
        if(sums.size() == curLevel) sums.add(0L);
        sums.set(curLevel,sums.get(curLevel)+root.val);
        getAllSums(root.left,sums,curLevel+1);
        getAllSums(root.right,sums,curLevel+1);
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long>sums = new ArrayList<>();
        getAllSums(root,sums,0);
        if(sums.size() < k) return -1;
        Collections.sort(sums,Collections.reverseOrder());
        return sums.get(k-1);
    }
}