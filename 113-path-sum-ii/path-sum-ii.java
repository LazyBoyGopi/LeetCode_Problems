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
    private void recu(TreeNode root,int targetSum ,int curSum ,List<List<Integer>>list,List<Integer>tempList){
        if(root == null) return;
        curSum += root.val;
        tempList.add(root.val);
        if(root.left == null && root.right == null){
            if(curSum == targetSum){
                list.add(new ArrayList<>(tempList));
            }
            tempList.remove(tempList.size()-1);
            return;
        }
            recu(root.left,targetSum,curSum,list,tempList);
            recu(root.right,targetSum,curSum,list,tempList);
        tempList.remove(tempList.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>list = new LinkedList<>();
        recu(root,targetSum,0,list,new LinkedList<>());
        return list;
    }
}