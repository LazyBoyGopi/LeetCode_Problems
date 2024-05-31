class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for(int ele : nums) if(ele > max) max = ele;
        int score = 0;
        while(k > 0){
            score += max;
            max++;
            k--;
        }
        return score;
    }
}