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
    private void traverse(TreeNode root,Map<Integer,Integer>map,int level){
        if(root == null) return;
        if(map.containsKey(level)){
            if(map.get(level) < root.val)
                map.put(level,root.val);
        }else map.put(level,root.val);

        traverse(root.left,map,level+1);
        traverse(root.right,map,level+1);
    }
    public List<Integer> largestValues(TreeNode root) {
        Map<Integer,Integer>map = new HashMap();
        traverse(root,map,0);
        int row = 0;
        List<Integer>list = new ArrayList();
        while(map.containsKey(row)){
            list.add(map.get(row++));
        }
        return list;
    }
}