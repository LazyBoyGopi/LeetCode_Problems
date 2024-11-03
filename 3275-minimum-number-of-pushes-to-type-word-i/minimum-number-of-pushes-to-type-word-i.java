class Solution {
    public int minimumPushes(String word) {
        int kt = 1, curCount = 0, ans = 0;
        for(int ele : word.toCharArray()){
            ans += kt;
            curCount++;
            if(curCount == 8) {
                curCount = 0;
                kt++;
            }
        }
        return ans;
    }
}