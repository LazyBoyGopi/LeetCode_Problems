class Solution {
    private boolean isSquare(long num){
        long st = 0 , end = num;
        while(st <= end){
            long mid = st+(end-st)/2;
            if(mid*mid == num) return true;
            if(mid*mid < num) st = mid+1;
            else end = mid-1;
        }
        return false;
    }
    private boolean check(int st,int end,int c,boolean increase){
        while(st <= end){
            int mid = st+(end-st)/2;
            long num = (mid)*mid;
            if(num == c) return true;
            else{
                long diff = c-num;
                if(isSquare(diff)) return true;
                if(increase) st = mid+1;
                else end = mid-1;
            }
        }
        return false;
    }
    public boolean judgeSquareSum(int c) {
        // int st = 0 , end = c;
        // while(st <= end){
        //     int mid = st+(end-st)/2;
        //     long num = (long)mid*mid;
        //     if(num == c) return true;
        //     if(num  > c) end = mid-1;
        //     else {
        //         long diff = (long)c-num;
        //         if(isSquare(diff)) return true;
        //         if(check(st,mid-1,c,true) || check(mid+1,end,c,false)) return true;
        //         st = mid+1;
        //     }
        // }
        // return false;
         int st = 0, end = (int) Math.sqrt(c);
        while (st <= end) {
            long num = (long) st * st + (long) end * end;
            if (num == c) return true;
            if (num < c) st++;
            else end--;
        }
        return false;
    }
}