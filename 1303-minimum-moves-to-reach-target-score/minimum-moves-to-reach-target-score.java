class Solution {
    public int minMoves(int target, int maxDoubles) {
        int steps = 0 ;
        while(target != 1){
            if(maxDoubles > 0 && target %2 == 0){
                maxDoubles--;
                target /= 2;
            }
            else {
                if(maxDoubles == 0) return steps+(target-1);
                target--;
            }
            steps++;
        }
        return steps;
    }
}