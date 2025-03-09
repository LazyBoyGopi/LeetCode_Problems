/*
//Brute Force
class Solution {
    private static boolean isAlternate(int[]col,int st,int k){
        int end = st+k;
        int i=st;
        boolean isZero = col[i++] == 0;
        while(i < end){
            if(isZero && col[i] == 0)
                return false;
            if(!isZero && col[i] == 1)
                return false;
            isZero = !isZero;
            i++;
        }
        return true;
    }
    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int[]col = new int[len*2];
        for(int i=0;i<len;i++){
            col[i] = col[i+len] = colors[i];
        }
        int count = 0;
        for(int i=0;i<len;i++){
            if(isAlternate(col,i,k))
               {
                 count++;
                 System.out.println(i);
                }
        }
        return count;
    }
}
 */

class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int[]col = new int[len*2];
        for(int i=0;i<len;i++){
            col[i] = col[i+len] = colors[i];
        }
        len += k-1;
        int totCount = 0, curAlternating = 0, last = col[0];
        for(int i=1;i<len;i++){
            if(last == col[i]){
                curAlternating = 0;
            }else{
                curAlternating++;
                if(curAlternating == k-1){
                    curAlternating--;
                    totCount++;
                }
            }
            last = col[i];
        }
        return totCount;
    }
}