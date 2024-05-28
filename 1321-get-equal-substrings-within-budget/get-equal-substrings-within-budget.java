class Solution {
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
                while(left <= right && total + lenAr[right] > maxCost){
                    total -= lenAr[left++];
                }
            }
        }
        return Math.max(max,right-left);
    }
}