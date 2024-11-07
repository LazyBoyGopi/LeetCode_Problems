class Solution {
    int len;
    private void getAllCombinations(int[]candidates,int idx,int and,int curLen){
        if(idx == candidates.length) {
            if(and > 0)
            len = Math.max(len,curLen);
            return;
        }
        if(and > 0)
            len = Math.max(len,curLen);
        getAllCombinations(candidates,idx+1,and,curLen);
        getAllCombinations(candidates,idx+1,and & candidates[idx],curLen+1);
    }
    public int largestCombination(int[] candidates) {
        // len = 0;
        // getAllCombinations(candidates,0,0,0);
        // return len;
        int[]ar = new int[24];
        for(int ele : candidates){
            int idx = 23;
            while(ele > 0){
                if((ele & 1) == 1)
                    ar[idx]++;
                ele >>= 1;
                idx--;
            }
        }
        int max = 0;
        for(int ele : ar){
            max = Math.max(ele,max);
        }
        System.out.println(Arrays.toString(ar));
        return max;
    }
}