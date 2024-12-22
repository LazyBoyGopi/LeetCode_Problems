class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0 ? true : false;
        x = Math.abs(x);
        long max = Integer.MAX_VALUE;
        long rev = 0;
        while(x > 0){
            rev = rev * 10 + x%10;
            x/=10;
            if(rev > max) return 0;
        }
        int ans = (int)rev;
        return isNeg ? -1*ans : ans;
    }
}