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
    private void getAllSums(TreeNode root, Map<Integer,Long>sums, int curLevel){
        if(root == null) return;
        sums.put(curLevel,sums.getOrDefault(curLevel,0l)+root.val);
        getAllSums(root.left,sums,curLevel+1);
        getAllSums(root.right,sums,curLevel+1);
    }
    public long kthLargestLevelSum(TreeNode root, int k) {
        Map<Integer,Long>sums = new HashMap();
        getAllSums(root,sums,0);
        List<Long> list = new LinkedList();
        for(Long sum : sums.values()){
            list.add(sum);
        }
        Collections.sort(list);
        if(list.size() < k) return -1;
        return list.get(list.size()-k);
    }
}