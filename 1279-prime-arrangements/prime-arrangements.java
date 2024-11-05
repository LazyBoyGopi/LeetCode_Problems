class Solution {
    int[]ar = new int[101];
    long[]factorial = new long[101];
    final int MOD = 1_000_000_007;

    public int numPrimeArrangements(int n) {
        if(ar[2] != 1) getAllPrimeNumbers();
        return (int) (factorial[ar[n]] * (factorial[n-ar[n]]) % MOD);
    }
    private void getAllPrimeNumbers(){
        ar[2] = 1;
        factorial[0] = 1;
        factorial[1] = 1;
        factorial[2] = 2;
        long tillNow = 2;
        for(int i=3;i<=100;i++){
            ar[i] = ar[i-1] + checkPrime(i);
            factorial[i] = (tillNow *i) % MOD;
            tillNow = (tillNow*i)%MOD;
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
    private int factorial(int n){
        int fac = 1;
        for(int i=1;i<=n;i++) fac *= i;
        return fac;
    }
}