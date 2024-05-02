class Solution {
    public int findMaxK(int[] nums) {
        int max = -1;
        int[]freq = new int[1001];
        for(int ele : nums)
        {
            if(ele > 0)
            {
                if(freq[ele] < 0) max = Math.max(max,ele);
                if(freq[ele] == 0) freq[ele]++;
            }
            else if(ele < 0){
                if(freq[-1 * ele] > 0) max = Math.max(max,-1*ele);
                if(freq[-1*ele] == 0) freq[-1*ele]--;
            }
        }
        return max;
    }
}