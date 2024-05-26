class Solution {
    public int maximumScore(int a, int b, int c) {
        int score =0;
        while((a != 0 && b != 0) || (c != 0 && a!= 0) || (b != 0 && c != 0)){
            score++;
            if(a >= b && a >= c){
                if(b > c){
                    b--;
                }
                else c--;
                a--;
            }
            else if(b >= a && b>=c){
                if(a > c) a--;
                else c--;
                b--;
            }
            else{
                if(a > b) a--;
                else b--;
                c--;
            }
        }
        return score;
    }
}