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
    private class Pair{
        int idx;
        List<Integer>list;
        public Pair(int idx,List<Integer>_list){
            this.idx = idx;
            list = _list;
        }
    }
    private void traverseTree(TreeNode root,int level,Map<Integer,Pair>map){
        if(root == null) return;
        if((level & 1) == 1){
            map.putIfAbsent(level,new Pair(-1,new ArrayList()));
            map.get(level).list.add(root.val);
        }
        traverseTree(root.left,level+1,map);
        traverseTree(root.right,level+1,map);
    }
    private void buildTree(TreeNode root,int level,Map<Integer,Pair>map){
        if(root == null) return;
        if((level  & 1) == 1){
            Pair curPair = map.get(level);
            List<Integer>curList = curPair.list;
            int idx = curPair.idx != -1 ? curPair.idx : curList.size()-1;
            root.val = curList.get(idx);
            curPair.idx = idx-1;
        }
        buildTree(root.left,level+1,map);
        buildTree(root.right,level+1,map);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Map<Integer,Pair>map = new HashMap();
        TreeNode rootOrg = root;
        traverseTree(root,0,map);
        buildTree(rootOrg,0,map);
        return rootOrg;
    }
}