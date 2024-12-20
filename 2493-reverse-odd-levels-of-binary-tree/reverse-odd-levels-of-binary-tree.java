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
        public Pair(int idx,List<Integer>list){
            this.idx = idx;
            this.list = list;
        }
    }
    private void traverseTree(TreeNode root,int level,Map<Integer,Pair>map,boolean isTraverseing){
        if(root == null) return;
        if((level & 1) == 1){
            if(isTraverseing){
                map.putIfAbsent(level,new Pair(-1,new ArrayList()));
                map.get(level).list.add(root.val);
            }else{
                Pair curPair = map.get(level);
                List<Integer>curList = curPair.list;
                int idx = curPair.idx != -1 ? curPair.idx : curList.size()-1;
                root.val = curList.get(idx);
                curPair.idx = idx-1;
            }
        }
        traverseTree(root.left,level+1,map,isTraverseing);
        traverseTree(root.right,level+1,map,isTraverseing);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Map<Integer,Pair>map = new HashMap();
        TreeNode rootOrg = root;
        traverseTree(root,0,map,true);
        traverseTree(rootOrg,0,map,false);
        return rootOrg;
    }
}