class Solution {
    public int maxScore(String s) {
        int len = s.length(), maxScore = 0;
        int leftZeroes = 0;
        for(int i=0;i<len-1;i++){
            if(s.charAt(i) == '0') leftZeroes++;
            int rightOnes = 0;
            for(int j = i+1;j<len;j++){
                if(s.charAt(j) == '1') rightOnes++;
            }
            maxScore = Math.max(maxScore,rightOnes+leftZeroes);
        }
        return maxScore;
    }
}