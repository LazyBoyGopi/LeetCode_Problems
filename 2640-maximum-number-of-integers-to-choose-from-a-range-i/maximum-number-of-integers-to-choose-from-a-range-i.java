class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {

        boolean[]freq = new boolean[(int)1e4+1];
        for(int i=0;i<banned.length;i++){
            freq[banned[i]] = true;
        }

        int len = freq.length , sum = 0 , count = 0;
        for(int i=1;i<=n;i++){
            if(!freq[i]) {
                if((sum+i) <= maxSum){
                    sum += i;
                    count++;
                }
                else break;
            }
        }
        return count;
    }

}