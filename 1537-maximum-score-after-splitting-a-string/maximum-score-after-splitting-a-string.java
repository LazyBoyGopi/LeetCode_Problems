class Solution {
    public int maxScore(String s) {
        int len = s.length();

        int[]preSum = new int[len];
        preSum[0] = s.charAt(0) == '0' ? 1 : 0;
        for(int i=1;i<len;i++){
            preSum[i] = preSum[i-1] + (s.charAt(i) == '0' ? 1 : 0);
        }
        System.out.println(Arrays.toString(preSum));
        int maxScore = 0;
        int totalZeroes = preSum[len-1];
        for(int i=1;i<len;i++){
            int leftZero = preSum[i-1];
            int rightLen = len-i;
            int rightZeroes = totalZeroes - leftZero;
            int rightOnes = rightLen - rightZeroes;
            int curScore = leftZero + rightOnes;
            maxScore = Math.max(maxScore,curScore);
        }
        return maxScore;
    }
}