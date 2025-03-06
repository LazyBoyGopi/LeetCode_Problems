class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer>set = new HashSet();
        int[]ans = new int[2];
        for(int [] g : grid){
            for(int ele : g){
                if(set.contains(ele)){
                    ans[0] = ele;
                }
                set.add(ele);
            }
        }
        int max = grid.length*grid.length;
        for(int i=1;i<=max;i++){
            if(!set.contains(i)){
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}