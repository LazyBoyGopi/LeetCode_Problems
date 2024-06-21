class Solution {
    int dp[] = new int[(int)1e6+1];

    private boolean isPrime(int n){
        if(dp[n] == -1) return false;
        if(dp[n] == 1) return true;
        if(n == 2) return true;
        if(n%2 == 0) return false;
        int sqrt = (int)Math.sqrt(n)+1;
        for(int i=3;i<=sqrt;i+=2){
            if(n%i == 0) return false;
        }
        return true;
    }
    private void checkPrime(int n){
        int sqrt = (int)Math.sqrt(n);
        for(int i=2;i<=sqrt;i++){
            if(dp[i] == 0){
                if(isPrime(i)){
                    dp[i] = 1;
                }
                else dp[i] = -1;
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n) {
        checkPrime(n);
        List<List<Integer>>list = new LinkedList<>();
        for(int i=2;i<=n/2;i++){
            if(isPrime(i)){
                if(isPrime(n-i)){
                    list.add(Arrays.asList(i,n-i));
                }
            }
        }
        return list;
    }
}