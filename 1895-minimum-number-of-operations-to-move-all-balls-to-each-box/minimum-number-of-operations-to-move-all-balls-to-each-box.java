class Solution {
    public int[] minOperations(String boxes) {
        int len = boxes.length();
        int countOfOnesOnLeft = 0,countOfOnesOnRight = 0;
        int curVal = 0;
        int[]ans = new int[len];

        for(int i=0;i<len;i++){
            ans[i] = curVal;
            curVal += countOfOnesOnLeft;
            if(boxes.charAt(i) == '1'){
                curVal++;
                countOfOnesOnLeft++;
            }
        }
        curVal = 0;
        for(int i=len-1;i>=0;i--){
            ans[i] += curVal;
            curVal += countOfOnesOnRight;
            if(boxes.charAt(i) == '1'){
                curVal++;
                countOfOnesOnRight++;
            }
        }
        return ans;
    }
}