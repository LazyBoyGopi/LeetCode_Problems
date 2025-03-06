class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int len = grid.length, max = len*len;
        boolean freq[] = new boolean[max+1];
        int[]ans = new int[2];
        for(int [] g : grid){
            for(int ele : g){
                if(freq[ele]){
                    ans[0] = ele;
                }
                freq[ele] = true;
            }
        }
        for(int i=1;i<=max;i++){
            if(!freq[i]){
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}