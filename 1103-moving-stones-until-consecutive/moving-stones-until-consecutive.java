class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int x ,y,z;
        if(a > b && a > c){
            x = a;
            if(b > c) {
                y = b;
                z = c;
            }
            else {
                y = c;
                z = b;
            }
        }
        else if(b > c && b > a){
            x = b;
            if(c > a){
                y = c;
                z = a;
            }
            else{
                z = c;
                y = a;
            }
        }
        else{
            x = c;
            if(a > b){
                y = a;
                z = b;
            }
            else{
                y = b;
                z = a;
            }
        }
        int gap1 = y-z-1 , gap2 = x-y-1;
        int minmoves;
        if(gap1 == 0 && gap2 == 0){
            minmoves = 0;
        }
        else if(gap1 <= 1 || gap2 <= 1){
            minmoves = 1;
        }
        else minmoves = 2;
        return new int[]{minmoves,gap1+gap2};
        
        // int[]ar = new int[2];
        // if((Math.abs(a-b) == 1 && Math.abs(b-c) == 1) || (Math.abs(a-c) == 1 && Math.abs(c-b) == 1)) {
        //     return ar;
        // }
        // else if(Math.abs(a-b)-1 <= 2 || Math.abs(a-c)-1 == 2 || Math.abs(b-c)-1 <= 2) {
        //     ar[0] = 1;
        //     ar[1] = 2;
        // }
        // else{
        //     ar[0] = 2;
        //     ar[1] = Math.abs(a-b)-1 + Math.abs(b-c)-1;
        // }
        //  return ar;
    } 
}