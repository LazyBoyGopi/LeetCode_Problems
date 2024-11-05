class Solution {
    int[]ar = new int[101];
    final int MOD = 1_000_000_007;

    public int numPrimeArrangements(int n) {
        if(ar[2] != 1) getAllPrimeNumbers();
        return (int) (factorial(ar[n]) * (factorial(n-ar[n])) % MOD);
    }
    private void getAllPrimeNumbers(){
        ar[2] = 1;

        long tillNow = 2;
        for(int i=3;i<=100;i++){
            ar[i] = ar[i-1] + checkPrime(i);
        }
    }
    private int checkPrime(int n){
        int sqrt = (int)Math.sqrt(n);
        if(n % 2 == 0) return 0;
        for(int i=3;i<=sqrt;i+=2){
            if(n%i == 0) return 0;
        }
        return 1;
    }
    private long factorial(int n){
        long fac = 1;
        for(int i = 2;i<=n;i++) fac = (fac*i)%MOD;
        return fac;
    }
}