class Solution {
    public int passThePillow(int n, int time) {
        int rounds = time/(n-1);
        int rem = time%(n-1);
        if((rounds & 1) == 0)
            return rem+1;
        return n-rem;
    }
}