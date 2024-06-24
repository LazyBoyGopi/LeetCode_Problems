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
    private void getSum(TreeNode root,Map<Integer,List<Integer>>map,int level){
        if(root == null) return ;
        if(root.left == null && root.right == null) {
            if(map.containsKey(level)){
                map.get(level).add(root.val);
            }else{
                map.put(level,new ArrayList<>(Arrays.asList(root.val)));
            }
            return;
        }
        getSum(root.left,map,level+1);
        getSum(root.right,map,level+1);
    }
    public int deepestLeavesSum(TreeNode root) {
        Map<Integer,List<Integer>>map = new HashMap<>();
        getSum(root,map,0);
        int max = -1 , maxSum = 0;
        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()){
            if(entry.getKey() > max){
                maxSum = 0;
                for(int ele : entry.getValue()){
                    maxSum += ele;
                }
            }
        }
        return maxSum;
    }
}