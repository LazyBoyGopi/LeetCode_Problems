class Solution {
    private static boolean backTrack(int[]unUsed,int[]curAr,int curIdx)
    {
        if(curIdx == curAr.length){
            return true;
        }
        if(curAr[curIdx] != 0){
            return backTrack(unUsed,curAr,curIdx+1);
        }
        for(int i = 0;i<unUsed.length;i++){
            int ele = unUsed[i];
            if(ele == -1) continue;
            if(ele == 1){
                curAr[curIdx] = 1;
                unUsed[i] = -1;
                if(backTrack(unUsed,curAr,curIdx+1))
                    return true;
                
                unUsed[i] = ele;
                curAr[curIdx] = 0;
            }
            else if(curAr[curIdx] == 0 && curIdx+ele < curAr.length && curAr[curIdx+ele] == 0){
                curAr[curIdx] = ele;
                curAr[curIdx+ele] = ele;
                unUsed[i] = -1;
                if(backTrack(unUsed,curAr,curIdx+1))
                    return true;
                unUsed[i] = ele;
                curAr[curIdx] = 0;
                curAr[curIdx+ele] = 0;
            } 
        }
        return false;
    }
    public static int[] constructDistancedSequence(int n) {
        int[]unUsed = new int[n];
        int temp = n;
        for(int i=0;i<n;i++)
            unUsed[i] = temp--;
        int len = (n-1)*2+1;
        int[]res = new int[len];
        backTrack(unUsed,res,0);
        return res;
    }
}