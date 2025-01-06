class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int countOfOnesOnLeft = 0,countOfOnesOnRight = 0;
        int curVal = 0;

        int[]pre = new int[len];
        int[]suf = new int[len];

        for(int i=0;i<len;i++){
            pre[i] = curVal;
            curVal += countOfOnesOnLeft;
            if(boxes.charAt(i) == '1'){
                curVal++;
                countOfOnesOnLeft++;
            }
        }
        int[]ans = new int[len];
        ans[len-1] = pre[len-1];

        curVal = 0;
        for(int i=len-1;i>=0;i--){
            ans[i] = pre[i] + curVal;
            curVal += countOfOnesOnRight;
            if(boxes.charAt(i) == '1'){
                curVal++;
                countOfOnesOnRight++;
            }
        }
        return ans;
    }
}