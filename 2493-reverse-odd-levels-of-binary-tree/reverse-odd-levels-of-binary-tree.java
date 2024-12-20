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
    private void traverseTree(TreeNode root,int level,Map<Integer,List<Integer>>map){
        if(root == null) return;
        if((level & 1) == 1){
            map.putIfAbsent(level,new LinkedList());
            map.get(level).add(root.val);
        }
        traverseTree(root.left,level+1,map);
        traverseTree(root.right,level+1,map);
    }
    private void buildTree(TreeNode root,int level,Map<Integer,List<Integer>>map){
        if(root == null) return;
        if((level  & 1) == 1){
            List<Integer>curList = map.get(level);
            root.val = curList.get(curList.size()-1);
            curList.remove(curList.size()-1);
        }
        buildTree(root.left,level+1,map);
        buildTree(root.right,level+1,map);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        Map<Integer,List<Integer>>map = new HashMap();
        TreeNode rootOrg = root;
        traverseTree(root,0,map);
        buildTree(rootOrg,0,map);
        return rootOrg;
    }
}