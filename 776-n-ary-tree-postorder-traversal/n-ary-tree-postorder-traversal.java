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
    private static void getList(Node root,List<Integer>list){
        if(root == null) return;
        List<Node>childrens = root.children;
        for(Node children : childrens){
            getList(children,list);
            list.add(children.val);
        }
    }
    public List<Integer> postorder(Node root) {
        List<Integer>list = new LinkedList();
        getList(root,list);
        if(root != null) list.add(root.val);
        return list;
    }
}