class Solution {
    private static boolean isPossible(int org,String num,int idx,int curSum){
        if(idx == num.length()){
            return curSum == org;
        }
        int len = num.length();
        for(int i=idx;i<=len;i++){
            String str = num.substring(idx,i);
            if(str.length() == 0) continue;
            int s = Integer.parseInt(str);
            if(isPossible(org,num,i,curSum+s))
                return true;
        }
        return false;
    }
    public static int punishmentNumber(int n) {
        int punishmentNum = 0;
        for(int i=1;i<=n;i++){
            if(isPossible(i,(i*i)+"",0,0)){
                punishmentNum += (i*i);
            }
        }
        return punishmentNum;
    }
}