class Solution {
    public int countPrimes(int n) {
        boolean []ar = new boolean[n+1];
        Arrays.fill(ar,true);
        int sqrt = (int)Math.sqrt(n);
        for(int i=2;i<=sqrt;i++){
            if(!ar[i]) continue;
            int mul = i*2;
            while(mul <= n){
                ar[mul] = false;
                mul += i;
            }
        }
        int count = 0;
        for(int i=2;i<n;i++){
            if(ar[i]) count++;
        }
        return count;
    }
}