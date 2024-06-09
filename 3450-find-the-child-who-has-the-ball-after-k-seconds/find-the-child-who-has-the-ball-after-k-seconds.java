class Solution {
    public int numberOfChild(int n, int k) {
        boolean start = true;
        while(k >= n){
            k-= (n-1);
            start = !start;
        }
        if(start){
            return k;
        }
        else{
            return n-1-k;
        }
    }
}