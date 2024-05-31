class Solution {
    public int[] numMovesStones(int a, int b, int c) {

        int []ar = {a,b,c};
        Arrays.sort(ar);
        int gap1 = ar[1]-ar[0]-1 , gap2 = ar[2]-ar[1]-1;
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