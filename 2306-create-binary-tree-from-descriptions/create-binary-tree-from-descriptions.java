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
/*class Solution {
    private int getMax(int[][]descriptions){
        int max = 1;
        for(int [] ar: descriptions){
            max = Math.max(max,Math.max(ar[1],ar[0]));
        }
        return max;
    }
    private int createMap(int[][]descriptions,int[][]map){
        for(int [] ar : descriptions){
            if(ar[2] == 1)
                map[ar[0]][0] = ar[1];
            else
                map[ar[0]][1] = ar[1];
        }
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        int max = getMax(descriptions);
        int[][] map = new int[max+1][2];
        createMap(descriptions,map);
        return null;
    }
} */

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> childrenSet = new HashSet<>();
        Map<Integer, int[]> childrenHashmap = new HashMap<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;

            childrenHashmap.putIfAbsent(parent, new int[]{-1, -1});
            childrenSet.add(child);

            if (isLeft) {
                childrenHashmap.get(parent)[0] = child;
            } else {
                childrenHashmap.get(parent)[1] = child;
            }
        }

        int headNodeVal = 0;
        for (int parent : childrenHashmap.keySet()) {
            if (!childrenSet.contains(parent)) {
                headNodeVal = parent;
                break;
            }
        }

        return constructTree(headNodeVal, childrenHashmap);
    }

    private TreeNode constructTree(int curNodeVal, Map<Integer, int[]> childrenHashmap) {
        TreeNode newNode = new TreeNode(curNodeVal);
        if (childrenHashmap.containsKey(curNodeVal)) {
            int[] children = childrenHashmap.get(curNodeVal);
            if (children[0] != -1) {
                newNode.left = constructTree(children[0], childrenHashmap);
            }
            if (children[1] != -1) {
                newNode.right = constructTree(children[1], childrenHashmap);
            }
        }
        return newNode;
    }
}