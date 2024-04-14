class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int st = 1 , end = x;
        while(st <= end)
        {
            long mid = (long)st+(end-st)/2;
            if(mid*mid <= x && (mid+1)*(mid+1) > x) return (int)mid;
            if(mid*mid > x) end = (int)mid-2;
            else st = (int)mid+1;
        }
        return st;
    }
}