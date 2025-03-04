class Solution {

    static int[] threePowers= {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 
                   59049, 177147, 531441, 1594323, 4782969};
    int Len = 15;
    int N;
    private boolean checkPossibilities(int idx,int sum){
        if(sum == N) return true;
        if(sum > N || idx == Len) return false;
        return checkPossibilities(idx+1,sum + threePowers[idx]) || checkPossibilities(idx+1,sum);
    }
    public boolean checkPowersOfThree(int n) {
        N=n;
        return checkPossibilities(0,0);
    }
}