class Solution {
    private long integerReplacement1(long n,Map<Long,Long>dp){
        if(n <= 1) return 0;
        if(dp.containsKey(n)) return dp.get(n);
        if(n%2 == 0) return integerReplacement1(n/2,dp)+1;
        long min =  Math.min(integerReplacement1(n+1,dp),integerReplacement1(n-1,dp))+1;
        dp.put(n,min);
        return dp.get(n);
    }
    public int integerReplacement(int n) {
        Map<Long,Long> dp = new HashMap();
        return (int)integerReplacement1(n,dp);
    }
}