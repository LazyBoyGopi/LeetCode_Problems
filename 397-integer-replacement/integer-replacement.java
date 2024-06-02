class Solution {
    private int integerReplacement1(long n){
        if(n <= 1) return 0;
        if(n%2 == 0) return integerReplacement1(n/2)+1;
        return Math.min(integerReplacement1(n+1),integerReplacement1(n-1))+1;
    }
    public int integerReplacement(int n) {
        return integerReplacement1(n);
    }
}