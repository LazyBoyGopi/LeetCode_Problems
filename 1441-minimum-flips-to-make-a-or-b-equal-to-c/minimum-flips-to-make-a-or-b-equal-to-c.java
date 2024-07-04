
class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        int or = a|b;
        while(or != c){
            int a1 = a&1;
            int b1 = b&1;
            int c1 = c&1;
            if((a1 | b1) != c1){
                if(c1 == 0){
                    if(a1 == 1 && b1 == 1) count += 2;
                    else count++;
                }else{
                    count++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
            or = a|b;
        }
        return count;
    }
}
