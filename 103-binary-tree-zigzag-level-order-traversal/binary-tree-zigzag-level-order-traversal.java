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
    private void getElementsByLevel(TreeNode root,Map<Integer,List<Integer>>map,int level){
        if(root == null) return;
        if(map.containsKey(level)){
            map.get(level).add(root.val);
        }else{
            List<Integer> list = new LinkedList();
            list.add(root.val);
            map.put(level,list);
        }
        getElementsByLevel(root.left,map,level+1);
        getElementsByLevel(root.right,map,level+1);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Map<Integer,List<Integer>>map = new HashMap();
        getElementsByLevel(root,map,0);
        List<List<Integer>> ans = new LinkedList();
        int level = 0;
        while(map.containsKey(level)){
            List<Integer> list = new LinkedList();
            List<Integer> curList = map.get(level);
            if(level % 2 == 0){
                for(int i=0;i<curList.size();i++){
                    list.add(curList.get(i));
                }
            }else{
                for(int i=curList.size()-1;i>=0;i--){
                    list.add(curList.get(i));
                }
            }
            ans.add(list);
            level++;
        }
        return ans;
    }
}