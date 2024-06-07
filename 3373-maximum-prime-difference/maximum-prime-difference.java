class Solution {
    static boolean primeNumbers[] = new boolean [101];
    private boolean isPrime(int n){
        if(primeNumbers[n]) return true;
        if(n == 1) return false;
        if(n == 2) return true;
        if((n & 1) == 0) return false;

        int sqrt = (int)Math.sqrt(n);
        for(int i=3;i<=sqrt;i++){
            if(n%i == 0) return false;
        }
        return primeNumbers[n] = true;
    }
    public int maximumPrimeDifference(int[] nums) {
        int minIdx = nums.length , maxIdx = -1 , len = nums.length;
        for(int i=0;i<len;i++){
            if(isPrime(nums[i])){
                minIdx = Math.min(minIdx,i);
                maxIdx = Math.max(maxIdx,i);
            }
        }
        System.out.println(Arrays.toString(primeNumbers));
        System.out.println(minIdx+" "+maxIdx);
        if(minIdx == -1 || maxIdx == -1) return 0;
        return maxIdx-minIdx;
    }
}