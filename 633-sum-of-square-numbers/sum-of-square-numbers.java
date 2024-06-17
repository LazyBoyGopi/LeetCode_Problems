class Solution {
    public boolean judgeSquareSum(int c) {
        int st = 0 , end = (int)Math.sqrt(c);
        while(st <= end){
            long num = (long)st*st+(long)end*end;
            if(num == c) return true;
            if(num > c) end--;
            else st++;
        }
        return false;
    }
}