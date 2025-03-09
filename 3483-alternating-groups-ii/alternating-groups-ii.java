/*
//Brute Force(Time Limit exceeded)
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
//Better code (beats - 86%)
class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int len = colors.length;
        int[]col = new int[len*2];
        for(int i=0;i<len;i++){
            col[i] = col[i+len] = colors[i];
        }
        len += --k;
        int totCount = 0, curAlternating = 0, last = col[0];
        for(int i=1;i<len;i++){
            int curEle = col[i];
            if(last == curEle){
                int curCount = curAlternating - k+1;
                if(curCount > 0)
                    totCount += curCount;
                curAlternating = 0;
                
            }else{
                curAlternating++;
            }
            last = curEle;
        }
        int curCount = curAlternating - k+1;
                if(curCount > 0)
                    totCount += curCount;
        return totCount;
    }
}