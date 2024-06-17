class Solution {
    public boolean isPerfectSquare(int num) {
        int st = 0 , end = num;
        while(st <= end){
            int mid = st+(end-st)/2;
            long square = (long)mid*mid;
            if(square == num) return true;
            if(square > num) end = mid-1;
            else st = mid+1;
        }
        return false;
    }
}