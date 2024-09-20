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
    private void getAns(List<List<Integer>>ans,TreeNode root,int level){
        if(root == null) return;
        if(level %2 == 0){
           if(ans.size() > level){
                List<Integer> list = ans.get(level);
                list.add(root.val);
           }else{
                 List<Integer> list = new LinkedList();
                 list.add(root.val);
                 ans.add(list);
           }
        }else{
            if(ans.size() > level){
                List<Integer> list = ans.get(level);
                list.add(0,root.val);
           }else{
                 List<Integer> list = new LinkedList();
                 list.add(root.val);
                 ans.add(list);
           }
        }
        getAns(ans,root.left,level+1);
        getAns(ans,root.right,level+1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList();
        getAns(list,root,0);
        return list;
    }
}