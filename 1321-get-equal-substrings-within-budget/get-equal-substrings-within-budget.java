class Solution {
    private static int maxLen = 0;
    private void helper(String s,String t,int maxCost,int idx,int curLen){
        int cost = Math.abs(s.charAt(idx)-t.charAt(idx));
        if((idx == s.length()) || (s.charAt(idx) != t.charAt(idx) && maxCost < cost)){
                maxLen = Math.max(maxLen,curLen);
                return;
            }
            // for(int i=idx;i<s.length();i++){
                cost = Math.abs(s.charAt(idx)-t.charAt(idx));
                if(maxCost >= cost){
                helper(s,t,maxCost-cost,idx+1,curLen+1);
            }
            else {
                maxLen = Math.max(maxLen,curLen);
                return;
            // }
            }
    }
    public int equalSubstring(String s, String t, int maxCost) {
        int[] lenAr = new int[s.length()];
        for(int i=0;i<s.length();i++){
            lenAr[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        int left = 0 , right = 0 , max = 0 , total = 0;
        while(right < s.length()){
            if(total + lenAr[right] <= maxCost){
                total += lenAr[right++];
            }
            else{
                max = Math.max(max,right-left);
                total -= lenAr[left++];
            }
        }
        return Math.max(max,right-left);

        // maxLen = 0;
        // helper(s,t,maxCost,0,0);
        // return maxLen;
    }
}