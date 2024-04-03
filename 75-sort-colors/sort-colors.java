class Solution {
    private void fillArray(int st,int end,int ele,int []nums)
    {
        for(int i=st;i<=end;i++)
        {
            nums[i] = ele;
        }
    }
    public void sortColors(int[] nums) {
        int countOfOnes = 0 , countOfZeroes = 0 , countOfTwos = 0;
        for(int ele : nums)
        {
            if(ele == 0) countOfZeroes++;
            else if(ele == 1) countOfOnes++;
            else countOfTwos++;
        }
        fillArray(0,countOfZeroes-1,0,nums);
        fillArray(countOfZeroes,countOfZeroes+countOfOnes-1,1,nums);
        fillArray(countOfOnes+countOfZeroes,countOfZeroes+countOfOnes+countOfTwos-1,2,nums);
    }
}