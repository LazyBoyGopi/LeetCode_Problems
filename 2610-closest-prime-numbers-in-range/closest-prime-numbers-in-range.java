class Solution {
    private boolean isPrime(int num){
        if(num == 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        int sqrt = (int)Math.sqrt(num);
        for(int i=3;i<=sqrt;i+=2)
            if(num % i == 0)
                return false;
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        int[]ans = {-1,-1};
        int last = -1;
        int min = Integer.MAX_VALUE;
        for(int i=left;i<=right;i++){
            if(isPrime(i)){
                if(last != -1){
                    int curMin = i-last;
                    if(curMin < min){
                        min = curMin;
                        ans[0] = last;
                        ans[1] = i;
                    }
                    if(curMin == 2 || curMin == 1) return ans;
                }
                last = i;
                
            }
        }
        return ans;
    }
}