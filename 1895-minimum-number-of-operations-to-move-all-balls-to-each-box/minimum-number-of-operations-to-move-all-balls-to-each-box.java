class Solution {
    private int sum(List<Integer>list,int curIdx){
        int sum = 0;
        for(int idx : list) sum += Math.abs(curIdx-idx);
        return sum;
    }
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
        curVal = 0;
        for(int i=len-1;i>=0;i--){
            suf[i] = curVal;
            curVal += countOfOnesOnRight;
            if(boxes.charAt(i) == '1'){
                curVal++;
                countOfOnesOnRight++;
            }
        }
        
        System.out.println(Arrays.toString(pre)+"\n"+Arrays.toString(suf));

        int[]ans = new int[len];
        ans[0] = suf[0];
        ans[len-1] = pre[len-1];
        for(int i=1;i<len-1;i++){
            ans[i] = pre[i] + suf[i];
        }
        return ans;
    }
}