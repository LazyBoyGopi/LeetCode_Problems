/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maxLevel = 0;
    private void getMaxDepth(Node root,int level){
        if(root == null) return;
        maxLevel = Math.max(maxLevel,level+1);
        if(root.children == null){
            return;
        }
        List<Node>children = root.children;
        for(int i=0;i<children.size();i++){
            getMaxDepth(children.get(i),level+1);
        }
    } 
    public int maxDepth(Node root) {
        maxLevel = 0;
        getMaxDepth(root,0);
        return maxLevel;
    }
}