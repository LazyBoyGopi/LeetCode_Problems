class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int totCount = 0, curAlternating = 0, last = colors[0];
        for(int i=1;i<len+k-1;i++){
            int curEle = colors[i%len];
            if(last == curEle){
                curAlternating = 0;
            }else{
                curAlternating++;
                if(curAlternating == k-1){
                    curAlternating--;
                    totCount++;
                }
            }
            last = curEle;
        }
        return totCount;
    }
}