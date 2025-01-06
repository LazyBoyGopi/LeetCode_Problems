class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int[]ans = new int[len];
        for(int i=0;i<len;i++){
            int curOperations = 0;
            for(int j=0;j<len;j++){
                if(boxes.charAt(j) == '1'){
                    curOperations += Math.abs(i-j);
                }
            }
            ans[i] = curOperations;
        }
        return ans;
    }
}