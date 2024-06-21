class Solution {
    int dp[] = new int[(int)1e6+1];
    private boolean isPrime(int num){
        if(dp[num] == 1) return true;
        if(dp[num] == -1) return false;
        if(num == 2) return true;
        if(num%2 == 0) {
            dp[num] = -1;
            return false;
        }
        int sqrt = (int)Math.sqrt(num)+1;
        for(int i=3;i<=sqrt;i+=2){
            if(num%i == 0) {
                dp[num] = -1;
                return false;
            }
        }
        dp[num] = 1;
        return true;
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> list = new LinkedList<>();
        for(int i=2;i<=n/2;i++){
            if(isPrime(i)){
                int comp = n-i;
                if(isPrime(comp)){
                    list.add(new ArrayList<>(Arrays.asList(i,comp)));
                }
            }
        }
        return list;
    }
}