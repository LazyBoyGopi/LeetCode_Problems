class Solution {
    final int MOD = 1_000_000_007;

    public int numPrimeArrangements(int n) {
        int c = getAllPrimeNumbers(n);
        return (int) (factorial(c) * (factorial(n-c)) % MOD);
    }
    private int getAllPrimeNumbers(int n){
        int count = 0;
        for(int i=2;i<=n;i++){
            if(checkPrime(i)) count++;
        }
        return count;
    }
    private boolean checkPrime(int n){
        if(n == 1) return false;
        if(n == 2) return true;
        int sqrt = (int)Math.sqrt(n);
        if(n % 2 == 0) return false;
        for(int i=3;i<=sqrt;i+=2){
            if(n%i == 0) return false;
        }
        return true;
    }
    private long factorial(int n){
        long fac = 1;
        for(int i = 2;i<=n;i++) fac = (fac*i)%MOD;
        return fac;
    }
}