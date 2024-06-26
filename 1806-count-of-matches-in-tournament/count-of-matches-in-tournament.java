class Solution {
    public int numberOfMatches(int n) {
        int totalMatches = 0;
        while(n != 1)
        {
            // if(n == 2) return ++totalMatches;
            if(n % 2 == 0){
                totalMatches += n/2;
                n /=2;
            }
            else{
                totalMatches += n/2;
                n = ( n/2 )+1;
            }
        }
        return totalMatches;
    }
}