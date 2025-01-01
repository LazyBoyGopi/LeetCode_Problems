class Solution {
    public int maxScore(String s) {

        int len = s.length();

        int totalZeroes = 0;

        for(int i=0;i<len;i++){
            totalZeroes +=  (s.charAt(i) == '0' ? 1 : 0);
        }

        int maxScore = 0;
        int leftZeroes = s.charAt(0) == '0' ? 1 : 0;
        for(int i=1;i<len;i++){
            
            int rightZeroes = totalZeroes - leftZeroes;

            int rightLen = len-i;
            int rightOnes = rightLen - rightZeroes;

            int curScore = leftZeroes + rightOnes;

            maxScore = Math.max(maxScore,curScore);

            leftZeroes += (s.charAt(i) == '0' ? 1 : 0);
        }
        return maxScore;
    }
}